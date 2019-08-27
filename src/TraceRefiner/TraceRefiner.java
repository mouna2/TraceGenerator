package TraceRefiner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.swing.JTable;

import ALGO.AlgoFinal;
import ALGO.DatabaseInput;
import ALGO.DatabaseReading;
import ALGO.PredictionValues;
import Chess.LogInfo;
import Chess.PredictionEvaluation;
import mypackage.ClassTrace2;
import mypackage.MethodTrace;

public class TraceRefiner {

	
	 PredictionValues zeroPred= new PredictionValues(0,0,0); 

	 PredictionEvaluation TotalPattern = new PredictionEvaluation();
		PredictionEvaluation RemainingPattern = new PredictionEvaluation();
		PredictionEvaluation Step2Pattern = new PredictionEvaluation();
		PredictionEvaluation Step3Pattern = new PredictionEvaluation();
		PredictionEvaluation Step4Pattern = new PredictionEvaluation();

		PredictionEvaluation Step2PatternCumulative = new PredictionEvaluation();
		PredictionEvaluation Step3PatternCumulative = new PredictionEvaluation();
		PredictionEvaluation Step4PatternCumulative = new PredictionEvaluation();

		
		
		
		static List<MethodTrace> methodtraces = new ArrayList<MethodTrace>();
		HashMap<String, List<String>> classMethodsHashMap = new HashMap<String, List<String>>();
		public static HashMap<String, MethodTrace> methodtraces2HashMap = new HashMap<String, MethodTrace>();
		LinkedHashMap<String, ClassTrace2> methodtracesRequirementClass = new LinkedHashMap<String, ClassTrace2>();


	
	
	
	
	
	
	JTable table = new JTable();
	public  void TracePredictionFunction( String ProgramName) throws Exception {
		
		
		AlgoFinal af= new AlgoFinal(); 
		// TODO Auto-generated method stub
		BufferedWriter bwfile1 =null; 
		BufferedWriter bwfile2 = null ; 
		BufferedWriter bwfile3 = null ; 
		
	if(ProgramName.equals("chess")) {
		File file1log = new File("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\InterfacesNewRule.txt");
		FileOutputStream fosfila1 = new FileOutputStream(file1log);
		 bwfile1 = new BufferedWriter(new OutputStreamWriter(fosfila1));
		
		File file2log = new File("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\LogFileUnderstandFP.txt");
		FileOutputStream fosfila2 = new FileOutputStream(file2log);
		 bwfile2 = new BufferedWriter(new OutputStreamWriter(fosfila2));
		 
			File file3log = new File("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\LogFileUnderstandFN.txt");
			FileOutputStream fosfila3 = new FileOutputStream(file3log);
			 bwfile3 = new BufferedWriter(new OutputStreamWriter(fosfila3));
	}
		// TODO Auto-generated method stub
		LogInfo.CreateLogFiles(ProgramName);

		
		


		
		DatabaseReading DatabaseReading= new DatabaseReading(ProgramName); 
		
		methodtraces2HashMap = DatabaseReading.getMethodtracehashmap();
		methodtraces = DatabaseReading.getMethodtracesList(); 

		
		

		LinkedHashMap<String, LogInfo> LogInfoHashMap = new LinkedHashMap<String, LogInfo>();
		

		Collection<MethodTrace> MethodTracesHashmapValues = methodtraces2HashMap.values();


		
		
		PredictionValues TotalPredictionValues = new PredictionValues(); 
		PredictionValues RemainingpredictionValues = new PredictionValues(); 
		PredictionValues Step2PredictionValues = new PredictionValues(); 
		PredictionValues Step3PredictionValues = new PredictionValues(); 
		PredictionValues Step4PredictionValues = new PredictionValues(); 
		PredictionValues Step4PredictionValuesCumulative = new PredictionValues(); 

		PredictionValues PredictionClassTraceBefore = new PredictionValues(); 
		PredictionValues PredictionClassTraceAfter = new PredictionValues(); 
		 PredictionValues OwnerClassPredictionValues = new PredictionValues(); 

		LogInfo.InitializeLogInfoHashMap(LogInfoHashMap,MethodTracesHashmapValues, AlgoFinal.methodtraces2HashMap ); 

		LogInfo.bwTraceClass.write("BEFORE PATTERN 0 "+PredictionClassTraceBefore.toString());
		LogInfo.bwTraceClass.newLine();

		 

		

		LogInfo.bwTraceClass.write("AFTER PATTERN 0 "+PredictionClassTraceAfter.toString());
		LogInfo.bwTraceClass.close();
	
		LogInfoHashMap=LogInfo.InitializeLogInfoHashMapTraceClassNewValue(LogInfoHashMap,MethodTracesHashmapValues, AlgoFinal.methodtraces2HashMap ); 

	
		MethodTracesHashmapValues = AlgoFinal.methodtraces2HashMap.values();
		LogInfoHashMap=af.InitializeHashMapWithPrecisionRecall(AlgoFinal.methodtraces2HashMap, LogInfoHashMap);
	
		

	
		
		//////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////
		//STEP 1
		//////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			// OWNER CLASS PATTERN
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
	int counter=0;
		for (String key : AlgoFinal.methodtraces2HashMap.keySet()) {

			MethodTrace methodtrace=AlgoFinal.methodtraces2HashMap.get(key); 
					
					String reqClass= methodtrace.Requirement.ID+"-"+methodtrace.Method.Owner.ID; 
					String reqMethod= methodtrace.Requirement.ID+"-"+methodtrace.Method.ID; 
		
				
					if (DatabaseInput.OwnerTraceHashMap.get(reqClass) != null) {
				
					if (DatabaseInput.OwnerTraceHashMap.get(reqClass).equals("T") )
				{
					methodtrace.SetPrediction(LogInfoHashMap, "E","E,Owner");

					//DO NOTHING 
					
				

				} 
					
					else if (DatabaseInput.OwnerTraceHashMap.get(reqClass).equals("N") ) 
					{
					methodtrace.SetPrediction(LogInfoHashMap, "N","N,Owner");
					
					
				}

				else {
					methodtrace.SetPrediction(LogInfoHashMap, "E","E,Owner");

					//DO NOTHING 
				}
			

		
					System.out.println("STEP 1" );
			
		}
		}
		System.out.println(counter);
		af.SetSubjectGoldDeveloperGoldEqualityFlag(AlgoFinal.methodtraces2HashMap, TotalPattern, LogInfoHashMap, ProgramName); 
			

			LogInfo.ComputePrecisionAndRecallNONCUMULATIVE(AlgoFinal.methodtraces2HashMap,TotalPattern, ProgramName, OwnerClassPredictionValues, LogInfoHashMap);

			LogInfo.updateResultsLog(TotalPattern, OwnerClassPredictionValues, ProgramName, "OWNER CLASS PRED", "owner class prediction values", "INDIVIDUAL");
		
		
		

		int ITERATION = 0;
	//	MethodTracesHashmapValues=methodtraces2HashMap.values(); 

		af.ComputeStepResults2(Step2PatternCumulative, OwnerClassPredictionValues, LogInfoHashMap, ProgramName, "Step 1 Cumulative", "Step 1 Prediction Values Cumulative", zeroPred); 

		
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			//STEP 2
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////

		MethodTracesHashmapValues=AlgoFinal.methodtraces2HashMap.values(); 

		while (MethodTrace.modified) {
			MethodTrace.modified = false;
			////////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			// PURE AND MIXED PATTERNS	PATTERN 1-2
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////

			//////////////////////////////////////////////////////////////////////////////////////////
		

			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			// PURE PATTERNS
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////

			
			// PRINT

			
			
			
			
			
			
			
			
			
			
			
			
			
			
		

			
			// END PRINT
			
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			// SUPERCLASSES , CHILDREN , INTERFACES , IMPLEMENTATIONS  PATTERN 3
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
				
			
			for (String key : AlgoFinal.methodtraces2HashMap.keySet()) {

				MethodTrace methodtrace=AlgoFinal.methodtraces2HashMap.get(key); 
							
							
							if (

							methodtrace.Method.getCallersShell().AllNs(methodtrace.Requirement, AlgoFinal.methodtraces2HashMap) 
							

						) {

						methodtrace.SetPrediction(LogInfoHashMap,"N", "N,AllNCallers");
						System.out.println("STEP 2 ALL CALLERS iteration" +ITERATION);



				}
				

				
				 
//			}
				
			
			
			
			
				//////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////
				//ALL CALLEES PATTERN 5
				//////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////
//			System.out.println("YESS3");

//			for (MethodTrace methodtrace : MethodTracesHashmapValues) {
				
//				System.out.println("PATTERN 5");

				
				

			
				
				
				
				

						else if (

				methodtrace.Method.getCalleesShell().AllNs(methodtrace.Requirement, AlgoFinal.methodtraces2HashMap) 
				
				
				) {
				
					methodtrace.SetPrediction(LogInfoHashMap,"N", "N,AllNCallees");
					System.out.println("STEP 2 ALL CALLEES iteration" +ITERATION);

				
				
				}
			
				}	
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			// END PATTERNS 
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			
			
			
			
			
			
			

			
			
			// PRINT
			af.SetLogFileIterations(MethodTracesHashmapValues, methodtraces, LogInfoHashMap, ITERATION); 
			
			
			// END PRINT
			ITERATION++;
			System.out.println("ITERATION  "+ITERATION);
		}
		af.ComputeStepResults(Step2Pattern, Step2PredictionValues, LogInfoHashMap, ProgramName,  "Step 2", "Step 2 Prediction Values", OwnerClassPredictionValues); 
		af.ComputeStepResults2(Step2PatternCumulative, Step2PredictionValues, LogInfoHashMap, ProgramName, "Step 2 Cumulative", "Step 2 Prediction Values Cumulative", zeroPred); 

		System.out.println("ITERATION  "+ITERATION);
		System.out.println("ITERATION  "+ITERATION);

		

		

		
		//////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////
		// STEP 3
		//////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////
		//SET EVERYTHING ELSE TO T IF THE OWNER CLASS IS T 
				for (String key : AlgoFinal.methodtraces2HashMap.keySet()) {

					MethodTrace methodtrace = AlgoFinal.methodtraces2HashMap.get(key); 
					String reqMethod = methodtrace.Requirement.ID + "-" + methodtrace.Method.ID;
					String reqClass = methodtrace.Requirement.ID + "-" + methodtrace.Method.Owner.ID;
			

					
					
					
					
					
					
					
					
					
					if(methodtrace.prediction.equals("E") && DatabaseInput.OwnerTraceHashMap.get(reqClass).equals("T") ) {
						//MIXED T 
						if(
									
						
								methodtrace.Method.getCallersShell().getOwnerClasses(methodtrace.Requirement).AtLeast1T(methodtrace.Requirement)
								&& methodtrace.Method.getCalleesShell().getOwnerClasses(methodtrace.Requirement).AtLeast1T(methodtrace.Requirement)			
								&& !methodtrace.Method.getCallersShell().AtLeast1N(methodtrace.Requirement, AlgoFinal.methodtraces2HashMap)
								&& !methodtrace.Method.getCalleesShell().AtLeast1N(methodtrace.Requirement, AlgoFinal.methodtraces2HashMap)
								 


								)
							{
								LogInfo loginfo = LogInfoHashMap.get(reqMethod); 
								methodtrace.SetPrediction(LogInfoHashMap,"T", "T,Remaining/MixedTSTEP3");
						
						LogInfoHashMap.put(reqMethod, loginfo); 
							}
							 //MIXED T LEAF 
						else 	 if(
							 			

										 methodtrace.Method.getCallersShell().getOwnerClasses(methodtrace.Requirement).AtLeast1T(methodtrace.Requirement)
							 			 && methodtrace.Method.getCalleesShell().isEmpty()		
										&& !methodtrace.Method.getCallersShell().AtLeast1N(methodtrace.Requirement, AlgoFinal.methodtraces2HashMap)


											)
										{
											LogInfo loginfo = LogInfoHashMap.get(reqMethod); 
											methodtrace.SetPrediction(LogInfoHashMap,"T", "T,Remaining/MixedTLeafSTEP3");
									
									LogInfoHashMap.put(reqMethod, loginfo); 
										}


								
								
						
								
								 //ALL CALLERS 
								
						else	if (	
								

										methodtrace.Method.getCallersShell().getOwnerClasses(methodtrace.Requirement).AllTs(methodtrace.Requirement)
										&& !methodtrace.Method.getCallersShell().AtLeast1N(methodtrace.Requirement, AlgoFinal.methodtraces2HashMap)
										&& !methodtrace.Method.getCalleesShell().AtLeast1N(methodtrace.Requirement, AlgoFinal.methodtraces2HashMap)

										) {
									LogInfo loginfo = LogInfoHashMap.get(reqMethod); 
									methodtrace.SetPrediction(LogInfoHashMap,"T", "T,Remaining/AllCallersTSTEP3");
							
							LogInfoHashMap.put(reqMethod, loginfo); 
								}
					
								//ALL CALLEES 
						else	if (	
										 methodtrace.Method.getCalleesShell().getOwnerClasses(methodtrace.Requirement).AllTs(methodtrace.Requirement)
										&& !methodtrace.Method.getCalleesShell().AtLeast1N(methodtrace.Requirement, AlgoFinal.methodtraces2HashMap) 
										&& !methodtrace.Method.getCallersShell().AtLeast1N(methodtrace.Requirement, AlgoFinal.methodtraces2HashMap)



										) {
									LogInfo loginfo = LogInfoHashMap.get(reqMethod); 
									methodtrace.SetPrediction(LogInfoHashMap,"T", "T,Remaining/AllCalleesTSTEP3");
							
							LogInfoHashMap.put(reqMethod, loginfo); 
								}
					}
					
					
					
						
					

				}
				
				System.out.println("STEP 3" );
				af.ComputeStepResults(Step3Pattern, Step3PredictionValues, LogInfoHashMap, ProgramName, "Step 3", "Step 3 Prediction Values", Step2PredictionValues); 
				af.ComputeStepResults2(Step3PatternCumulative, Step3PredictionValues, LogInfoHashMap, ProgramName, "Step 3 Cumulative", "Step 3 Prediction Values Cumulative", zeroPred); 

		
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			// STEP 4
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
		ITERATION=0; 
		MethodTrace.modified=true; 
		while (MethodTrace.modified) {
			MethodTrace.modified = false;
			////////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			// PURE AND MIXED PATTERNS	PATTERN 1-2
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////

			//////////////////////////////////////////////////////////////////////////////////////////
		

		
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////


			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			// MIXED PATTERNS
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			
			for (String key : AlgoFinal.methodtraces2HashMap.keySet()) {
				
				
				MethodTrace methodtrace = AlgoFinal.methodtraces2HashMap.get(key); 
				 


				

				
				 
				// MIXED T LEAF PATTERN
				 if (methodtrace.Method.getCalleesShell().isEmpty() 
						 && methodtrace.Method.getCallersShell().AtLeast1T(methodtrace.Requirement, AlgoFinal.methodtraces2HashMap) 

				) {
						methodtrace.SetPrediction(LogInfoHashMap,"T", "T,MixedTLeafSTEP4");

						System.out.println("STEP 4 MIXED T LEAF iteration" +ITERATION );
				}

				

			
//			}
			
			// PRINT

			
			
			
			
			
			
			
			
			
			
			
			
			
			
		

			
			// END PRINT
			
		
			
			
			
			
			
			
			
			

			
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
				

					
				
			
	

				
			
			

		
		
				

		
				
				

			
		
			
			
				
				
			
				

				
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			// ALL CALLERS PATTERN 4
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
				


			
			
				
				
				// ALL T CALLERS 
				 else if (!methodtrace.Method.getCallersShell().isEmpty() 
					&& methodtrace.Method.getCallersShell().AllTs(methodtrace.Requirement, AlgoFinal.methodtraces2HashMap) 
					

				) {
						System.out.println("STEP 4 ALL CALLERS iteration" +ITERATION );

						methodtrace.SetPrediction(LogInfoHashMap,"T", "T,AllTCallersSTEP4");
						
				}

				

				
				 
				
				
//			}
				
			
			
			
			
				//////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////
				//ALL CALLEES PATTERN 5
				//////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////


				
				

			
				
				
				
				
				//ALL T CALLEES 
				 else if (!methodtrace.Method.getCalleesShell().isEmpty() 
				&& methodtrace.Method.getCalleesShell().AllTs(methodtrace.Requirement, AlgoFinal.methodtraces2HashMap) 
				
				
				) {
					System.out.println("STEP 4 ALL CALLEES iteration" +ITERATION);

					methodtrace.SetPrediction(LogInfoHashMap,"T", "T,AllTCalleesSTEP4");

				
				
				}

				
				}	
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			// END PATTERNS 
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			
			
			
			
			
			
			

			
			
			// PRINT
			af.SetLogFileIterations(MethodTracesHashmapValues, methodtraces, LogInfoHashMap, ITERATION); 
			
			System.out.println("STEP 4 ITERATION "+ ITERATION);
			// END PRINT
			ITERATION++;
			
		}
		
		af.ComputeStepResults(Step4Pattern, Step4PredictionValues, LogInfoHashMap, ProgramName, "Step 4", "Step 4 Prediction Values", Step3PredictionValues); 

				
		af.ComputeStepResults2(Step4PatternCumulative, Step4PredictionValues, LogInfoHashMap, ProgramName, "Step 4 Cumulative", "Step 4 Prediction Values Cumulative", zeroPred); 
			
		LogInfo.CheckCallersCalleesSymmetry(); 
				
				int counter2=0; 
				
				for (MethodTrace methodtrace : MethodTracesHashmapValues) {
					
						methodtrace.UpdateCallersCallees(LogInfoHashMap);
						counter2++; 
						System.out.println("COUNTER2  "+counter2);
				}	
	
				
					
					
	
					
					
		System.out.println(ITERATION);
		System.out.println("FINISJED");
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	
	
	

		if(ProgramName.equals("chess")) {
			bwfile2.close(); 
			bwfile1.close(); 
			bwfile3.close();
		}
	
		
		
		
		LogInfo.WriteMethodCalls(ProgramName);
		System.out.println("RemainingpredictionValues"+RemainingpredictionValues);
		System.out.println("OWNERRRRRRRRRR");



		 TotalPredictionValues = new PredictionValues(); 
		 TotalPattern = new PredictionEvaluation();
		 RemainingpredictionValues = new PredictionValues(); 
		
		 System.out.println("YES");
		

		 LogInfo.updateInheritanceLogs(ProgramName, MethodTracesHashmapValues, LogInfoHashMap); 
		 af.ResetAllTraceSetFlags(AlgoFinal.methodtraces2HashMap);
		 System.out.println("YES2");
		 af.ComputeStepResults(TotalPattern, TotalPredictionValues, LogInfoHashMap, ProgramName, "TOTAL  PREDICTION", "total prediction values", zeroPred); 

		 

		 
		 
	 LogInfo.updateTableLog(ProgramName, MethodTracesHashmapValues, LogInfoHashMap);

		 System.out.println("YES6");
		 LogInfo.closeLogFile(); 
		
		

		
		LogInfo.CloseFiles(ProgramName); 
		
		
	}
}
