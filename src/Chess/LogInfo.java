package Chess;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.eclipse.jdt.core.search.MethodNameMatch;

import ALGO.AlgoFinal;
import ALGO.DatabaseInput;
import TraceValidator.ENTGoldValues;
import ALGO.MethodList;
import ALGO.PredictionValues;
import Tables.methodcalls;
import mypackage.ClassTrace2;
import mypackage.Method;
import mypackage.MethodTrace;
import mypackage.Requirement;

public class LogInfo {
	String MethodID; 
	String MethodName; 
	String RequirementID; 
	String RequirementName; 
	String ClassID; 
	String ClassName; 
	String TraceValue;
	String TraceClassOldValue; 
	String TraceClassNewValue; 
	String Prediction; 
	public String PrecisionRecall; 
	String GoldFinal; 
	String SubjectGold; 
	List<String> IterationValues= new ArrayList<String>();
	boolean SubjectDeveloperEqualityFlag; 
	String Reason; 
	public String PredictionSummary=""; 
	public String MethodGoldSummary=""; 
	public String ClassGeneralizedPredictionSummary=""; 

	
	List<String> ExtendedCallersText=new ArrayList<String>();
	
	List<String> ClassCalleesOwnerClasses=new ArrayList<String>();
	List<String> ClassCallersOwnerClasses=new ArrayList<String>();
	int ClassMethodsSize=0; 
	
	List<String> Callers=new ArrayList<String>(); 
	List<String> CallersPredictions=new ArrayList<String>(); 
	List<String> CallersOwners=new ArrayList<String>(); 
	
	List<String> Callees=new ArrayList<String>(); 
	List<String> CalleesPredictions=new ArrayList<String>(); 
	List<String> CalleesOwners=new ArrayList<String>(); 
	
	List<String> InterfaceCallers=new ArrayList<String>();
	List<String> InterfaceCallerPredictions=new ArrayList<String>();
	List<String> InterfaceCallersOwners=new ArrayList<String>();
	
	List<String> SuperclassCallers=new ArrayList<String>();
	List<String> SuperclassCallerPredictions=new ArrayList<String>();
	List<String> SuperclassCallersOwners=new ArrayList<String>();
	
	List<String> ImplementationCallers=new ArrayList<String>();
	List<String> ImplementationCallerPredictions=new ArrayList<String>();
	List<String> ImplementationCallersOwners=new ArrayList<String>();
	
	List<String> ChildrenCallers=new ArrayList<String>();
	List<String> ChildrenCallerPredictions=new ArrayList<String>();
	List<String> ChildrenCallersOwners=new ArrayList<String>();

	
	List<String> ImplementationCallees=new ArrayList<String>();
	List<String> ImplementationCalleePredictions=new ArrayList<String>();
	List<String> ImplementationCalleesOwners=new ArrayList<String>();

	

	List<String> ChildrenCallees=new ArrayList<String>();
	List<String> ChildrenCalleePredictions=new ArrayList<String>();
	List<String> ChildrenCalleesOwners=new ArrayList<String>();

	List<String> SuperclassCallees=new ArrayList<String>();
	List<String> SuperclassCalleePredictions=new ArrayList<String>();
	List<String> SuperclassCalleesOwners=new ArrayList<String>();

	
	public List<String> CalleesCalleesInterfaceInheritance=new ArrayList<String>(); 
	public List<String> CalleesCalleesInterfaceInheritancePredictions=new ArrayList<String>(); 
	public List<String> CalleesCalleesInterfaceInheritanceOwners=new ArrayList<String>(); 

	
	
	public List<String> ExtendedCallersFinal=new ArrayList<String>(); 
	public List<String> ExtendedCalleesFinal=new ArrayList<String>(); 
	public List<String> ExtendedCallersPredictionsFinal=new ArrayList<String>(); 
	public List<String> ExtendedCalleesPredictionsFinal=new ArrayList<String>(); 
	public List<String> ExtendedOwnerCalleesFinal=new ArrayList<String>(); 
	public List<String> ExtendedOwnerCallersFinal=new ArrayList<String>(); 
	
	
	public List<String> ExecutedCallers=new ArrayList<String>(); 
	public List<String> ExecutedCallersPredictions=new ArrayList<String>(); 
	public List<String> ExecutedOwnerCallers=new ArrayList<String>(); 
	public List<String> ExecutedCallees=new ArrayList<String>(); 
	public List<String> ExecutedCalleesPredictions=new ArrayList<String>(); 
	public List<String> ExecutedOwnerCallees=new ArrayList<String>(); 

	
	public List<String> Parents=new ArrayList<String>(); 
	public List<String> ParentsPredictions=new ArrayList<String>(); 
	public List<String> Children=new ArrayList<String>(); 
	public List<String> ChildrenPredictions=new ArrayList<String>(); 
	public List<String> Interfaces=new ArrayList<String>(); 
	public List<String> InterfacesPredictions=new ArrayList<String>(); 
	public List<String> Implementations=new ArrayList<String>(); 
	public List<String> ImplementationsPredictions=new ArrayList<String>(); 
	
	
	public static BufferedWriter bwchessRunResultsWriter =null; 
	public static BufferedWriter bwGanttRunResultsWriter =null; 
	public static BufferedWriter bwJHotDrawRunResultsWriter =null; 
	public static BufferedWriter bwiTrustRunResultsWriter =null; 
	public List<String> getExecutedCallers() {
		return ExecutedCallers;
	}
	public void setExecutedCallers(List<String> executedCallers) {
		ExecutedCallers = executedCallers;
	}
	public List<String> getExecutedCallersPredictions() {
		return ExecutedCallersPredictions;
	}
	public void setExecutedCallersPredictions(List<String> executedCallersPredictions) {
		ExecutedCallersPredictions = executedCallersPredictions;
	}
	public List<String> getExecutedOwnerCallers() {
		return ExecutedOwnerCallers;
	}
	public void setExecutedOwnerCallers(List<String> executedOwnerCallers) {
		ExecutedOwnerCallers = executedOwnerCallers;
	}
	public List<String> getExecutedCallees() {
		return ExecutedCallees;
	}
	public void setExecutedCallees(List<String> executedCallees) {
		ExecutedCallees = executedCallees;
	}
	public List<String> getExecutedCalleesPredictions() {
		return ExecutedCalleesPredictions;
	}
	public void setExecutedCalleesPredictions(List<String> executedCalleesPredictions) {
		ExecutedCalleesPredictions = executedCalleesPredictions;
	}
	public List<String> getExecutedOwnerCallees() {
		return ExecutedOwnerCallees;
	}
	public void setExecutedOwnerCallees(List<String> executedOwnerCallees) {
		ExecutedOwnerCallees = executedOwnerCallees;
	}
	public List<String> getCalleesCalleesInterfaceInheritancePredictions() {
		return CalleesCalleesInterfaceInheritancePredictions;
	}
	public void setCalleesCalleesInterfaceInheritancePredictions(
			List<String> calleesCalleesInterfaceInheritancePredictions) {
		CalleesCalleesInterfaceInheritancePredictions = calleesCalleesInterfaceInheritancePredictions;
	}
	public List<String> getCalleesCalleesInterfaceInheritanceOwners() {
		return CalleesCalleesInterfaceInheritanceOwners;
	}
	public void setCalleesCalleesInterfaceInheritanceOwners(List<String> calleesCalleesInterfaceInheritanceOwners) {
		CalleesCalleesInterfaceInheritanceOwners = calleesCalleesInterfaceInheritanceOwners;
	}
	public List<String> getCalleesCalleesInterfaceInheritance() {
		return CalleesCalleesInterfaceInheritance;
	}
	public void setCalleesCalleesInterfaceInheritance(List<String> calleesCalleesInterfaceInheritance) {
		CalleesCalleesInterfaceInheritance = calleesCalleesInterfaceInheritance;
	}
	public List<String> getImplementationCallers() {
		return ImplementationCallers;
	}
	public void setImplementationCallers(List<String> implementationCallers) {
		ImplementationCallers = implementationCallers;
	}
	public List<String> getImplementationCallerPredictions() {
		return ImplementationCallerPredictions;
	}
	public void setImplementationCallerPredictions(List<String> implementationCallerPredictions) {
		ImplementationCallerPredictions = implementationCallerPredictions;
	}
	public List<String> getImplementationCallersOwners() {
		return ImplementationCallersOwners;
	}
	public void setImplementationCallersOwners(List<String> implementationCallersOwners) {
		ImplementationCallersOwners = implementationCallersOwners;
	}
	public List<String> getChildrenCallers() {
		return ChildrenCallers;
	}
	public void setChildrenCallers(List<String> childrenCallers) {
		ChildrenCallers = childrenCallers;
	}
	public List<String> getChildrenCallerPredictions() {
		return ChildrenCallerPredictions;
	}
	public void setChildrenCallerPredictions(List<String> childrenCallerPredictions) {
		ChildrenCallerPredictions = childrenCallerPredictions;
	}
	public List<String> getChildrenCallersOwners() {
		return ChildrenCallersOwners;
	}
	public void setChildrenCallersOwners(List<String> childrenCallersOwners) {
		ChildrenCallersOwners = childrenCallersOwners;
	}
	public List<String> getSuperclassCallees() {
		return SuperclassCallees;
	}
	public void setSuperclassCallees(List<String> superclassCallees) {
		SuperclassCallees = superclassCallees;
	}
	public List<String> getSuperclassCalleePredictions() {
		return SuperclassCalleePredictions;
	}
	public void setSuperclassCalleePredictions(List<String> superclassCalleePredictions) {
		SuperclassCalleePredictions = superclassCalleePredictions;
	}
	public List<String> getSuperclassCalleesOwners() {
		return SuperclassCalleesOwners;
	}
	public void setSuperclassCalleesOwners(List<String> superclassCalleesOwners) {
		SuperclassCalleesOwners = superclassCalleesOwners;
	}
	public List<String> getExtendedOwnerCalleesFinal() {
		return ExtendedOwnerCalleesFinal;
	}
	public void setExtendedOwnerCalleesFinal(List<String> extendedOwnerCalleesFinal) {
		ExtendedOwnerCalleesFinal = extendedOwnerCalleesFinal;
	}
	public List<String> getExtendedOwnerCallersFinal() {
		return ExtendedOwnerCallersFinal;
	}
	public void setExtendedOwnerCallersFinal(List<String> extendedOwnerCallersFinal) {
		ExtendedOwnerCallersFinal = extendedOwnerCallersFinal;
	}
	public List<String> getExtendedCallersFinal() {
		return ExtendedCallersFinal;
	}
	public void setExtendedCallersFinal(List<String> extendedCallersFinal) {
		ExtendedCallersFinal = extendedCallersFinal;
	}
	public List<String> getExtendedCalleesFinal() {
		return ExtendedCalleesFinal;
	}
	public void setExtendedCalleesFinal(List<String> extendedCalleesFinal) {
		ExtendedCalleesFinal = extendedCalleesFinal;
	}
	public List<String> getExtendedCallersPredictionsFinal() {
		return ExtendedCallersPredictionsFinal;
	}
	public void setExtendedCallersPredictionsFinal(List<String> extendedCallersPredictionsFinal) {
		ExtendedCallersPredictionsFinal = extendedCallersPredictionsFinal;
	}
	public List<String> getExtendedCalleesPredictionsFinal() {
		return ExtendedCalleesPredictionsFinal;
	}
	public void setExtendedCalleesPredictionsFinal(List<String> extendedCalleesPredictionsFinal) {
		ExtendedCalleesPredictionsFinal = extendedCalleesPredictionsFinal;
	}
	
	public List<String> getCallersPredictions() {
		return CallersPredictions;
	}
	public void setCallersPredictions(List<String> callersPredictions) {
		CallersPredictions = callersPredictions;
	}
	public List<String> getCallersOwners() {
		return CallersOwners;
	}
	public void setCallersOwners(List<String> callersOwners) {
		CallersOwners = callersOwners;
	}
	public List<String> getCalleesPredictions() {
		return CalleesPredictions;
	}
	public void setCalleesPredictions(List<String> calleesPredictions) {
		CalleesPredictions = calleesPredictions;
	}
	public List<String> getCalleesOwners() {
		return CalleesOwners;
	}
	public void setCalleesOwners(List<String> calleesOwners) {
		CalleesOwners = calleesOwners;
	}
	
	public List<String> getImplementationCalleesOwners() {
		return ImplementationCalleesOwners;
	}
	public void setImplementationCalleesOwners(List<String> implementationCalleesOwners) {
		ImplementationCalleesOwners = implementationCalleesOwners;
	}
	public List<String> getInterfaceCallersOwners() {
		return InterfaceCallersOwners;
	}
	public void setInterfaceCallersOwners(List<String> interfaceCallersOwners) {
		InterfaceCallersOwners = interfaceCallersOwners;
	}
	public List<String> getChildrenCalleesOwners() {
		return ChildrenCalleesOwners;
	}
	public void setChildrenCalleesOwners(List<String> childrenCalleesOwners) {
		ChildrenCalleesOwners = childrenCalleesOwners;
	}
	public List<String> getSuperclassCallersOwners() {
		return SuperclassCallersOwners;
	}
	public void setSuperclassCallersOwners(List<String> superclassCallersOwners) {
		SuperclassCallersOwners = superclassCallersOwners;
	}
	
	public List<String> getImplementations() {
		return Implementations;
	}
	public void setImplementations(List<String> implementations) {
		Implementations = implementations;
	}
	public List<String> getInterfaces() {
		return Interfaces;
	}
	public void setInterfaces(List<String> interfaces) {
		Interfaces = interfaces;
	}
	public List<String> getSuperclasses() {
		return Superclasses;
	}
	public void setSuperclasses(List<String> superclasses) {
		Superclasses = superclasses;
	}
	List<String> ExtendedCallerPredictions=new ArrayList<String>();
	List<String> ExtendedCalleesText=new ArrayList<String>();
	List<String> ExtendedCalleePredictions=new ArrayList<String>();
	List<String> OuterCalleesPredictions=new ArrayList<String>();
	List<String> OuterCallersPredictions=new ArrayList<String>();
	
	
	List<String> OuterOwnerCalleesPredictions=new ArrayList<String>();
	List<String> OuterOwnerCallersPredictions=new ArrayList<String>();
	
	
	List<String> OuterOwnerCallees=new ArrayList<String>();
	List<String> OuterOwnerCallers=new ArrayList<String>();
	

	
	public List<String> CallersText=new ArrayList<String>();
	public List<String> CallerPredictionsText=new ArrayList<String>();
	public List<String> CalleesText=new ArrayList<String>();
	public List<String> CalleePredictionsText=new ArrayList<String>();
	
	List<String> ImplementationOwners=new ArrayList<String>();
	List<String> InterfaceOwners=new ArrayList<String>();
	List<String> SuperclassOwners=new ArrayList<String>();
	List<String> ChildrenOwners=new ArrayList<String>();
	
	List<String> ImplementationOwnersPredictions=new ArrayList<String>();
	List<String> InterfaceOwnersPredictions=new ArrayList<String>();
	List<String> SuperclassOwnersPredictions=new ArrayList<String>();
	List<String> ChildrenOwnersPredictions=new ArrayList<String>();
	
	
//	List<String> Implementations;
//	List<String> Interfaces;
	List<String> Superclasses=new ArrayList<String>();
//	List<String> Children;
	
	List<String> ImplementationPredictions=new ArrayList<String>();
	List<String> InterfacePredictions=new ArrayList<String>();
	List<String> SuperclassPredictions=new ArrayList<String>();
//	List<String> ChildrenPredictions;
	
	
	
	
	

	public List<String> getClassCalleesOwnerClasses() {
		return ClassCalleesOwnerClasses;
	}
	public List<String> getParents() {
		return Parents;
	}
	public void setParents(List<String> parents) {
		Parents = parents;
	}
	public List<String> getParentsPredictions() {
		return ParentsPredictions;
	}
	public void setParentsPredictions(List<String> parentsPredictions) {
		ParentsPredictions = parentsPredictions;
	}
	public List<String> getInterfacesPredictions() {
		return InterfacesPredictions;
	}
	public void setInterfacesPredictions(List<String> interfacesPredictions) {
		InterfacesPredictions = interfacesPredictions;
	}
	public List<String> getImplementationsPredictions() {
		return ImplementationsPredictions;
	}
	public void setImplementationsPredictions(List<String> implementationsPredictions) {
		ImplementationsPredictions = implementationsPredictions;
	}
	public void setClassCalleesOwnerClasses(List<String> classCalleesOwnerClasses) {
		ClassCalleesOwnerClasses = classCalleesOwnerClasses;
	}
	public List<String> getClassCallersOwnerClasses() {
		return ClassCallersOwnerClasses;
	}
	public void setClassCallersOwnerClasses(List<String> classCallersOwnerClasses) {
		ClassCallersOwnerClasses = classCallersOwnerClasses;
	}
	public int getClassMethodsSize() {
		return ClassMethodsSize;
	}
	public void setClassMethodsSize(int classMethodsSize) {
		ClassMethodsSize = classMethodsSize;
	}
	public List<String> getImplementation() {
		return Implementations;
	}
	public void setImplementation(List<String> implementation) {
		Implementations = implementation;
	}
	public List<String> getInterface() {
		return Interfaces;
	}
	public void setInterface(List<String> interface1) {
		Interfaces = interface1;
	}
	public List<String> getSuperclass() {
		return Superclasses;
	}
	public void setSuperclass(List<String> superclass) {
		Superclasses = superclass;
	}
	public List<String> getChildren() {
		return Children;
	}
	public void setChildren(List<String> children) {
		Children = children;
	}
	public List<String> getImplementationPredictions() {
		return ImplementationPredictions;
	}
	public void setImplementationPredictions(List<String> implementationPredictions) {
		ImplementationPredictions = implementationPredictions;
	}
	public List<String> getInterfacePredictions() {
		return InterfacePredictions;
	}
	public void setInterfacePredictions(List<String> interfacePredictions) {
		InterfacePredictions = interfacePredictions;
	}
	public List<String> getSuperclassPredictions() {
		return SuperclassPredictions;
	}
	public void setSuperclassPredictions(List<String> superclassPredictions) {
		SuperclassPredictions = superclassPredictions;
	}
	public List<String> getChildrenPredictions() {
		return ChildrenPredictions;
	}
	public void setChildrenPredictions(List<String> childrenPredictions) {
		ChildrenPredictions = childrenPredictions;
	}
	public List<String> getImplementationOwners() {
		return ImplementationOwners;
	}
	public void setImplementationOwners(List<String> implementationOwners) {
		ImplementationOwners = implementationOwners;
	}
	public List<String> getInterfaceOwners() {
		return InterfaceOwners;
	}
	public void setInterfaceOwners(List<String> interfaceOwners) {
		InterfaceOwners = interfaceOwners;
	}
	public List<String> getSuperclassOwners() {
		return SuperclassOwners;
	}
	public void setSuperclassOwners(List<String> superclassOwners) {
		SuperclassOwners = superclassOwners;
	}
	public List<String> getChildrenOwners() {
		return ChildrenOwners;
	}
	public void setChildrenOwners(List<String> childrenOwners) {
		ChildrenOwners = childrenOwners;
	}
	public List<String> getImplementationOwnersPredictions() {
		return ImplementationOwnersPredictions;
	}
	public void setImplementationOwnersPredictions(List<String> implementationOwnersPredictions) {
		ImplementationOwnersPredictions = implementationOwnersPredictions;
	}
	public List<String> getInterfaceOwnersPredictions() {
		return InterfaceOwnersPredictions;
	}
	public void setInterfaceOwnersPredictions(List<String> interfaceOwnersPredictions) {
		InterfaceOwnersPredictions = interfaceOwnersPredictions;
	}
	public List<String> getSuperclassOwnersPredictions() {
		return SuperclassOwnersPredictions;
	}
	public void setSuperclassOwnersPredictions(List<String> superclassOwnersPredictions) {
		SuperclassOwnersPredictions = superclassOwnersPredictions;
	}
	public List<String> getChildrenOwnersPredictions() {
		return ChildrenOwnersPredictions;
	}
	public void setChildrenOwnersPredictions(List<String> childrenOwnersPredictions) {
		ChildrenOwnersPredictions = childrenOwnersPredictions;
	}
	public List<String> getOuterOwnerCalleesPredictions() {
		return OuterOwnerCalleesPredictions;
	}
	public void setOuterOwnerCalleesPredictions(List<String> outerOwnerCalleesPredictions) {
		OuterOwnerCalleesPredictions = outerOwnerCalleesPredictions;
	}
	public List<String> getOuterOwnerCallersPredictions() {
		return OuterOwnerCallersPredictions;
	}
	public void setOuterOwnerCallersPredictions(List<String> outerOwnerCallersPredictions) {
		OuterOwnerCallersPredictions = outerOwnerCallersPredictions;
	}
	public List<String> getOuterOwnerCallees() {
		return OuterOwnerCallees;
	}
	public void setOuterOwnerCallees(List<String> outerOwnerCallees) {
		OuterOwnerCallees = outerOwnerCallees;
	}
	public List<String> getOuterOwnerCallers() {
		return OuterOwnerCallers;
	}
	public void setOuterOwnerCallers(List<String> outerOwnerCallers) {
		OuterOwnerCallers = outerOwnerCallers;
	}
	public List<String> getImplementationCallees() {
		return ImplementationCallees;
	}
	public void setImplementationCallees(List<String> implementationCallees) {
		ImplementationCallees = implementationCallees;
	}
	public List<String> getImplementationCalleePredictions() {
		return ImplementationCalleePredictions;
	}
	public void setImplementationCalleePredictions(List<String> implementationCalleePredictions) {
		ImplementationCalleePredictions = implementationCalleePredictions;
	}
	public List<String> getInterfaceCallers() {
		return InterfaceCallers;
	}
	public void setInterfaceCallers(List<String> interfaceCallers) {
		InterfaceCallers = interfaceCallers;
	}
	public List<String> getInterfaceCallerPredictions() {
		return InterfaceCallerPredictions;
	}
	public void setInterfaceCallerPredictions(List<String> interfaceCallerPredictions) {
		InterfaceCallerPredictions = interfaceCallerPredictions;
	}
	public List<String> getChildrenCallees() {
		return ChildrenCallees;
	}
	public void setChildrenCallees(List<String> childrenCallees) {
		ChildrenCallees = childrenCallees;
	}
	public List<String> getChildrenCalleePredictions() {
		return ChildrenCalleePredictions;
	}
	public void setChildrenCalleePredictions(List<String> childrenCalleePredictions) {
		ChildrenCalleePredictions = childrenCalleePredictions;
	}
	public List<String> getSuperclassCallers() {
		return SuperclassCallers;
	}
	public void setSuperclassCallers(List<String> superclassCallers) {
		SuperclassCallers = superclassCallers;
	}
	public List<String> getSuperclassCallerPredictions() {
		return SuperclassCallerPredictions;
	}
	public void setSuperclassCallerPredictions(List<String> superclassCallerPredictions) {
		SuperclassCallerPredictions = superclassCallerPredictions;
	}
	
	public List<String> getCallers() {
		return Callers;
	}
	public void setCallers(List<String> callers) {
		Callers = callers;
	}
	public List<String> getCallerPredictions() {
		return CallerPredictionsText;
	}
	public void setCallerPredictions(List<String> originalCallerPredictions) {
		CallerPredictionsText = originalCallerPredictions;
	}
	public List<String> getCallees() {
		return CalleesText;
	}
	
	public void setCallees(List<String> callees) {
		Callees = callees;
	}
	public void setCalleePredictions(List<String> originalCalleePredictions) {
		CalleePredictionsText = originalCalleePredictions;
	}
	public static BufferedWriter bwfile4 = null;
	public static BufferedWriter bwfile3 = null;
	public static BufferedWriter bwfile2 = null;
	public static BufferedWriter bwfileChess = null;

	
	public static BufferedWriter bwInterfacesImpChess = null;
	public static BufferedWriter bwSuperclassesChildrenChess = null;
	public static BufferedWriter bwInterfacesImpGantt = null;
	public static BufferedWriter bwSuperclassesChildrenGantt = null;
	public static BufferedWriter bwInterfacesImpiTrust = null;
	public static BufferedWriter bwSuperclassesChildreniTrust = null;	
	public static BufferedWriter bwInterfacesImpJHotDraw = null;
	public static BufferedWriter bwSuperclassesChildrenJHotDraw = null;
	
	
	
	public static BufferedWriter bwfile3Chess =null; 
	public static BufferedWriter bwfile3jHotDraw =null; 

	
	public List<String> getOuterCalleesPredictions() {
		return OuterCalleesPredictions;
	}
	public void setOuterCalleesPredictions(List<String> outerCalleesPredictions) {
		OuterCalleesPredictions = outerCalleesPredictions;
	}
	public List<String> getOuterCallersPredictions() {
		return OuterCallersPredictions;
	}
	public void setOuterCallersPredictions(List<String> outerCallersPredictions) {
		OuterCallersPredictions = outerCallersPredictions;
	}
	
	public static BufferedWriter bwchessMethodCallsWriter =null; 
	public static BufferedWriter bwGANTTMethodCallsWriter =null; 
	public static BufferedWriter bwiTrustMethodCallsWriter =null; 
	public static BufferedWriter bwJHotDrawMethodCallsWriter =null; 

	public static BufferedWriter bwfile1 = null;
	public static BufferedWriter bwTraceClass = null;
	public static BufferedWriter bwfileCumulative = null;
	public List<String> getExtendedCallers() {
		return ExtendedCallersText;
	}
	public void setExtendedCallers(List<String> callers) {
		ExtendedCallersText = callers;
	}
	public List<String> getExtendedCallerPredictions() {
		return ExtendedCallerPredictions;
	}
	public void setExtendedCallerPredictions(List<String> callerPredictions) {
		ExtendedCallerPredictions = callerPredictions;
	}
	public List<String> getExtendedCallees() {
		return ExtendedCalleesText;
	}
	public void setExtendedCallees(List<String> callees) {
		ExtendedCalleesText = callees;
	}
	public List<String> getExtendedCalleePredictions() {
		return ExtendedCalleePredictions;
	}
	public void setExtendedCalleePredictions(List<String> calleePredictions) {
		ExtendedCalleePredictions = calleePredictions;
	}
	public boolean isSubjectDeveloperEqual() {
		return SubjectDeveloperEqualityFlag;
	}
	public void setSubjectDeveloperEqualityFlag(boolean myFlag) {
		this.SubjectDeveloperEqualityFlag = myFlag;
	}
	public String getGoldFinal() {
		return GoldFinal;
	}
	public void setGoldFinal(String goldFinal) {
		GoldFinal = goldFinal;
	}
	public String getSubjectGold() {
		return SubjectGold;
	}
	public void setSubjectGold(String subjectGold) {
		SubjectGold = subjectGold;
	}
	public String getPrediction() {
		return Prediction;
	}
	public void setPrediction(String prediction) {
		Prediction = prediction;
	}
	public String getTraceClassOldValue() {
		return TraceClassOldValue;
	}
	public void setTraceClassOldValue(String traceClassOldValue) {
		TraceClassOldValue = traceClassOldValue;
	}
	public String getTraceClassNewValue() {
		return TraceClassNewValue;
	}
	public void setTraceClassNewValue(String traceClassNewValue) {
		TraceClassNewValue = traceClassNewValue;
	}
	public String getMethodID() {
		return MethodID;
	}
	public void setMethodID(String methodID) {
		MethodID = methodID;
	}
	public String getMethodName() {
		return MethodName;
	}
	public void setMethodName(String methodName) {
		MethodName = methodName;
	}
	public String getClassID() {
		return ClassID;
	}
	public void setClassID(String classID) {
		ClassID = classID;
	}
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	public String getTraceValue() {
		return TraceValue;
	}
	public void setTraceValue(String traceValue) {
		TraceValue = traceValue;
	}
	public List<String> getIterationValues() {
		return IterationValues;
	}
	public void setIterationValues(List<String> iterationValues) {
		IterationValues = iterationValues;
	}
	
	
	
	
	public String getPrecisionRecall() {
		return PrecisionRecall;
	}
	public void setPrecisionRecall(String precisionRecall) {
		PrecisionRecall = precisionRecall;
	}
	public LogInfo() {
		super();
	}
	
	
	
	
	@Override
	public String toString() {
//		System.out.println(MethodName);
		MethodName=MethodName.replaceAll(",", "/"); 
		RequirementName=RequirementName.replaceAll(",", "/"); 
		String CallersList=toString3(Callers); 
		String CallersOwnersList=toString3(CallersOwners); 
		String CallersPredictionsList=toString3(CallersPredictions); 
		String CalleesList=toString3(Callees); 
		String CalleesOwnersList=toString3(CalleesOwners); 
		String CalleesPredictionsList=toString3(CalleesPredictions); 
		
		
		String InterfaceCallerList=toString3(InterfaceCallers); 
		String InterfaceCallerOwnerList=toString3(InterfaceCallersOwners); 
		String InterfaceCallerPredictionList=toString3(InterfaceCallerPredictions); 
		
		String ImplementationCallerList=toString3(ImplementationCallers); 
		String ImplementationCallerOwnerList=toString3(ImplementationCallersOwners); 
		String ImplementationCallerPredictionList=toString3(ImplementationCallerPredictions); 
		
		
		String ChildrenCallerList=toString3(ChildrenCallers); 
		String ChildrenCallerOwnerList=toString3(ChildrenCallersOwners); 
		String ChildrenCallerPredictionList=toString3(ChildrenCallerPredictions); 
		
		
		String ImplementationCalleeList=toString3(ImplementationCallees); 
		String ImplementationCalleeOwnerList=toString3(ImplementationCalleesOwners); 
		String ImplementationCalleePredictionList=toString3(ImplementationCalleePredictions); 
		
		
		String SuperclassCallerList=toString3(SuperclassCallers); 
		String SuperclassCallerOwnerList=toString3(SuperclassCallersOwners); 
		String SuperclassCallerPredictionList=toString3(SuperclassCallerPredictions); 
		
		String ChildrenCalleesList=toString3(ChildrenCallees); 
		String ChildrenCalleeOwnerList=toString3(ChildrenCalleesOwners); 
		String ChildrenCalleePredictionList=toString3(ChildrenCalleePredictions); 
		
		String SuperclassCalleesList=toString3(SuperclassCallees); 
		String SuperclassCalleesOwnerList=toString3(SuperclassCalleesOwners); 
		String SuperclassCalleesPredictionList=toString3(SuperclassCalleePredictions); 
		
		
		String ExtendedCalleesList=toString3(ExtendedCalleesFinal); 
		String ExtendedCalleesPredictionsList=toString3(ExtendedCalleesPredictionsFinal); 
		String ExtendedCallersList=toString3(ExtendedCallersFinal); 
		String ExtendedCallersPredictionsList=toString3(ExtendedCallersPredictionsFinal); 
		String ExtendedOwnerCalleesList=toString3(ExtendedOwnerCalleesFinal); 
		String ExtendedOwnerCallersList=toString3(ExtendedOwnerCallersFinal); 
		
		String CalleesCalleesInterfaceInheritanceList=toString3(CalleesCalleesInterfaceInheritance); 
		String CalleesCalleesInterfaceInheritanceOwnersList		 =toString3(CalleesCalleesInterfaceInheritanceOwners); 
		String CalleesCalleesInterfaceInheritancePredictionsList       =toString3(CalleesCalleesInterfaceInheritancePredictions); 
		String ExecutedCalleesList=toString3(ExecutedCallees); 
		String ExecutedCalleesPredictionsList=toString3(ExecutedCalleesPredictions); 
		String ExecutedCallersList=toString3(ExecutedCallers); 
		String ExecutedCallersPredictionsList=toString3(ExecutedCallersPredictions); 
		String ExecutedOwnerCalleesList=toString3(ExecutedOwnerCallees); 
		String ExecutedOwnerCallersList=toString3(ExecutedOwnerCallers); 
		String reqClass= RequirementID+"-"+ClassID; 
		String iterfaces= toString3(Interfaces); 
		
		
		String parentsList = toString3(Parents); 
		String parentsPredictionList = toString3(ParentsPredictions); 
		String childrenList = toString3(Children); 
		String childrenPredictionList = toString3(ChildrenPredictions); 
		String interfaceList = toString3(Interfaces); 
		String interfacePredictionList = toString3(InterfacesPredictions); 
		String implementationList = toString3(Implementations); 
		String implementationPredictionList = toString3(ImplementationPredictions); 

		
		
		return MethodID+","+MethodName+","+RequirementID+","+RequirementName+","+ClassID+","+ClassName
				
				+","+TraceValue+","+DatabaseInput.OwnerTraceHashMap.get(reqClass)
				+","+interfaceList+","+interfacePredictionList+","+implementationList+","+implementationPredictionList+","+parentsList+","+parentsPredictionList+","+childrenList+","+childrenPredictionList
				+","+CallersList+","+CallersPredictionsList+","+CallersOwnersList
				+","+InterfaceCallerList+","+InterfaceCallerPredictionList+","+InterfaceCallerOwnerList
				+","+SuperclassCallerList+","+SuperclassCallerPredictionList+","+SuperclassCallerOwnerList
				+","+ImplementationCallerList+","+ImplementationCallerPredictionList+","+ImplementationCallerOwnerList
				+","+ChildrenCallerList+","+ChildrenCallerPredictionList+","+ChildrenCallerOwnerList
				
				+","+CalleesList+","+CalleesPredictionsList+","+CalleesOwnersList
				+","+ImplementationCalleeList+","+ImplementationCalleePredictionList+","+ImplementationCalleeOwnerList
				+","+ChildrenCalleesList+","+ChildrenCalleePredictionList+","+ChildrenCalleeOwnerList
				+","+SuperclassCalleesList+","+SuperclassCalleesPredictionList+","+SuperclassCalleesOwnerList
				+","+CalleesCalleesInterfaceInheritanceList+","+CalleesCalleesInterfaceInheritancePredictionsList+","+CalleesCalleesInterfaceInheritanceOwnersList

				
				+","+ExtendedCalleesList+","+ExtendedCalleesPredictionsList+","+ExtendedOwnerCalleesList+","+ExtendedCallersList+","+ExtendedCallersPredictionsList+","+ExtendedOwnerCallersList
				+","+ExecutedCalleesList+","+ExecutedCalleesPredictionsList+","+ExecutedOwnerCalleesList+","+ExecutedCallersList+","+ExecutedCallersPredictionsList+","+ExecutedOwnerCallersList

				+","+Prediction	
				+","+PrecisionRecall	
		+","+	toString2(IterationValues); 
//		return MethodID+","+MethodName+","+RequirementID+","+RequirementName+","+ClassID+","+ClassName+","+TraceValue+","+TraceClassOldValue+","+TraceClassNewValue+","+
//				PrecisionRecall	+","+toString2(IterationValues)+","+TraceValue+"-"+Reason+"-" +PrecisionRecall;
		
	}
	
	public String toString3(List<String> values) {
		// TODO Auto-generated method stub
		String s= ""; 
		int counter=0; 
//		if(values!=null) {
//			for(String value: values) {
//				
//				counter++; 
//				if(counter==values.size()) {
//					s=s+value; 
//				}
//				else {
//					s=s+value+"/"; 
//				}
//				
//			}
//			s=s.replaceAll(",", "_"); 
//
//			return s;
//		}
		 s= String.join("/", values );

		s=s.replaceAll(",","_");
		
		return s; 
	}
	public String getRequirementID() {
		return RequirementID;
	}
	public void setRequirementID(String requirementID) {
		RequirementID = requirementID;
	}
	public String getRequirementName() {
		return RequirementName;
	}
	public void setRequirementName(String requirementName) {
		RequirementName = requirementName;
	}
	public String toString2(List<String> IterationValues) {
		 String FinalString=""; 
		 int it=0; 
		 Reason=""; 
		for(String s: IterationValues) {
			if(it+1<IterationValues.size()) {
				FinalString=FinalString+s+","; 
				
				it++; 	
			}
			
			else if(it+1==IterationValues.size()) {
				FinalString=FinalString+s; 
				
			}
			if(!s.equals(" ")) {
				Reason=s; 
			}
		}
		return FinalString;
		
	}
	
	
	/************************************************************************************************************************************************/
	/**
	 * @param methodtraces2HashMap **********************************************************************************************************************************************/
	public static LinkedHashMap<String, LogInfo> InitializeLogInfoHashMap(LinkedHashMap<String, LogInfo> LogInfoHashMap,
			Collection<MethodTrace> methodTracesHashmapValues, HashMap<String, MethodTrace> methodtraces2HashMap) {
		// TODO Auto-generated method stub
		for(MethodTrace methodtrace: methodTracesHashmapValues) {
			String Req= methodtrace.getRequirement().ID; 
			String Method= methodtrace.getMethod().ID; 
			LogInfo loginfo= new LogInfo(); 
			String reqMethod= Req+"-"+Method; 
			if (LogInfoHashMap.get(reqMethod) != null) {
				loginfo = LogInfoHashMap.get(reqMethod);
			}

			loginfo.setRequirementID(methodtrace.getRequirement().ID);
			loginfo.setRequirementName(methodtrace.getRequirement().RequirementName);
			loginfo.setMethodID(methodtrace.getMethod().ID);
			loginfo.setMethodName(methodtrace.getMethod().methodname);
			loginfo.setClassID(methodtrace.Method.Owner.ID);
			loginfo.setClassName(methodtrace.Method.Owner.classname);
			loginfo.setTraceValue(methodtrace.getGold());
			loginfo.setGoldFinal(methodtrace.Method.Owner.DeveloperGold);
			loginfo.setSubjectGold(methodtrace.Method.Owner.SubjectGold);
			loginfo.setPrecisionRecall("E");

			
		
			LogInfoHashMap.put(Req+"-"+Method, loginfo); 
			methodtrace.setPrediction("E");

			String traceClassOldValue= methodtrace.Method.Owner.DeveloperGold; 

			
		
			loginfo.setTraceClassOldValue(traceClassOldValue);
			LogInfoHashMap.put(reqMethod, loginfo); 
		}
		return LogInfoHashMap; 
	}
	public static LinkedHashMap<String, LogInfo> InitializeLogInfoHashMapTraceClassNewValue(
			LinkedHashMap<String, LogInfo> LogInfoHashMap, Collection<MethodTrace> methodTracesHashmapValues,
			HashMap<String, MethodTrace> methodtraces2HashMap) {
		// TODO Auto-generated method stub
		for(MethodTrace methodtrace: methodTracesHashmapValues) {
			String Req= methodtrace.getRequirement().ID; 
			String Method= methodtrace.getMethod().ID; 
			
			String reqMethod= Req+"-"+Method; 
		
			
			

			
		
			
			if(LogInfoHashMap.get(reqMethod)!=null) {
				LogInfo	  LogInfo= LogInfoHashMap.get(reqMethod); 
				
				
				if(LogInfo.getTraceClassOldValue().equals("E") && !methodtrace.Method.Owner.DeveloperGold.equals("E")) {
					String traceClassNewValue= methodtrace.Method.Owner.DeveloperGold; 
					LogInfo.setTraceClassNewValue(traceClassNewValue);
					LogInfoHashMap.put(reqMethod, LogInfo); 
				}
				
				
			 }
			
		}
		return LogInfoHashMap;
	}
	public  static void CreateLogFiles(String ProgramName) throws IOException {
		// TODO Auto-generated method stub
		
	

		if (ProgramName.equals("chess") || ProgramName.equals("test") ) {
			File filelogChess = new File("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\TableLogChess.txt");
			FileOutputStream fosfilChess = new FileOutputStream(filelogChess);
			bwfileChess = new BufferedWriter(new OutputStreamWriter(fosfilChess));
			
		
			 File file1log = new File("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\PrecisionRecallChess.txt");
				FileOutputStream fosfila1 = new FileOutputStream(file1log);
				bwfile1 = new BufferedWriter(new OutputStreamWriter(fosfila1));
				
				File  file2log = new File("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\PrecisionRecallChessCumulative.txt");
				FileOutputStream	 fosfila2 = new FileOutputStream(file2log);
					bwfileCumulative = new BufferedWriter(new OutputStreamWriter(fosfila2));

				
				File mytraceClass = new File("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\TracesClassesChess.txt");
				FileOutputStream fosTraceClass = new FileOutputStream(mytraceClass);
				bwTraceClass = new BufferedWriter(new OutputStreamWriter(fosTraceClass));
				
				
				File myfile = new File("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\ComparisonInterfacesImplementationsChess.txt");
				FileOutputStream myFileOutputStream = new FileOutputStream(myfile);
				bwInterfacesImpChess = new BufferedWriter(new OutputStreamWriter(myFileOutputStream));
				
				
				File myfile2 = new File("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\ComparisonSuperclassesChildrenChess.txt");
				FileOutputStream myFileOutputStream2 = new FileOutputStream(myfile2);
				bwSuperclassesChildrenChess = new BufferedWriter(new OutputStreamWriter(myFileOutputStream2));
				
				
				File myfile3 = new File("C:\\Users\\mouna\\new_workspace\\TracePredictorFinal\\src\\ChessFiles\\MethodCalls.txt");
				FileOutputStream myFileOutputStream3 = new FileOutputStream(myfile3);
				 bwchessMethodCallsWriter = new BufferedWriter(new OutputStreamWriter(myFileOutputStream3));
				System.out.println("yes");
				
				 bwchessRunResultsWriter = new BufferedWriter(new FileWriter("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\RunResultsChess.txt", true));

		}

		if (ProgramName.equals("gantt")) {
			File filelog2 = new File("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\TableLogGantt.txt");
			FileOutputStream fosfila2 = new FileOutputStream(filelog2);
			bwfile2 = new BufferedWriter(new OutputStreamWriter(fosfila2));
			
		
			 File file1log = new File("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\PrecisionRecallGantt.txt");
				FileOutputStream fosfila1 = new FileOutputStream(file1log);
				bwfile1 = new BufferedWriter(new OutputStreamWriter(fosfila1));

				
				File mytraceClass = new File("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\TracesClassesGantt.txt");
				FileOutputStream fosTraceClass = new FileOutputStream(mytraceClass);
				bwTraceClass = new BufferedWriter(new OutputStreamWriter(fosTraceClass));
		
				File myfile = new File("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\ComparisonInterfacesImplementationsGantt.txt");
				FileOutputStream myFileOutputStream = new FileOutputStream(myfile);
				bwInterfacesImpGantt = new BufferedWriter(new OutputStreamWriter(myFileOutputStream));
				
				
				File myfile2 = new File("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\ComparisonSuperclassesChildrenGantt.txt");
				FileOutputStream myFileOutputStream2 = new FileOutputStream(myfile2);
				bwSuperclassesChildrenGantt = new BufferedWriter(new OutputStreamWriter(myFileOutputStream2));
		
				
				File myfile3 = new File("C:\\Users\\mouna\\new_workspace\\TracePredictorFinal\\src\\GanttFiles\\MethodCalls.txt");
				FileOutputStream myFileOutputStream3 = new FileOutputStream(myfile3);
				 bwGANTTMethodCallsWriter = new BufferedWriter(new OutputStreamWriter(myFileOutputStream3));
				 
				 bwGanttRunResultsWriter = new BufferedWriter(new FileWriter("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\RunResultsGantt.txt", true));

		}

		if (ProgramName.equals("itrust")) {
			File filelog3 = new File("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\TableLogiTrust.txt");
			FileOutputStream fosfila5 = new FileOutputStream(filelog3);
			bwfile3 = new BufferedWriter(new OutputStreamWriter(fosfila5));
			
			
			
			
			File file1log = new File("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\PrecisionRecalliTrust.txt");
			FileOutputStream fosfila1 = new FileOutputStream(file1log);
			bwfile1 = new BufferedWriter(new OutputStreamWriter(fosfila1));

			
			File mytraceClass = new File("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\TracesClassesiTrust.txt");
			FileOutputStream fosTraceClass = new FileOutputStream(mytraceClass);
			bwTraceClass = new BufferedWriter(new OutputStreamWriter(fosTraceClass));
			
			File myfile = new File("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\ComparisonInterfacesImplementationsiTrust.txt");
			FileOutputStream myFileOutputStream = new FileOutputStream(myfile);
			bwInterfacesImpiTrust = new BufferedWriter(new OutputStreamWriter(myFileOutputStream));
			
			
			File myfile2 = new File("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\ComparisonSuperclassesChildreniTrust.txt");
			FileOutputStream myFileOutputStream2 = new FileOutputStream(myfile2);
			bwSuperclassesChildreniTrust = new BufferedWriter(new OutputStreamWriter(myFileOutputStream2));
			
			File myfile3 = new File("C:\\Users\\mouna\\new_workspace\\TracePredictorFinal\\src\\iTrustFiles\\MethodCalls.txt");
			FileOutputStream myFileOutputStream3 = new FileOutputStream(myfile3);
			 bwiTrustMethodCallsWriter = new BufferedWriter(new OutputStreamWriter(myFileOutputStream3));
			 
			 bwiTrustRunResultsWriter = new BufferedWriter(new FileWriter("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\RunResultsiTrust.txt", true));

		}

		if (ProgramName.equals("jhotdraw")) {
			File filelog4 = new File("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\TableLogJHotDraw.txt");
			FileOutputStream fosfila4 = new FileOutputStream(filelog4);
			bwfile4 = new BufferedWriter(new OutputStreamWriter(fosfila4));
			
			
				
				
				File file1log = new File("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\PrecisionRecallJHotDraw.txt");
				FileOutputStream fosfila1 = new FileOutputStream(file1log);
				bwfile1 = new BufferedWriter(new OutputStreamWriter(fosfila1));

				
				File mytraceClass = new File("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\TracesClassesJHotDraw.txt");
				FileOutputStream fosTraceClass = new FileOutputStream(mytraceClass);
				bwTraceClass = new BufferedWriter(new OutputStreamWriter(fosTraceClass));
				
				
				File myfile = new File("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\ComparisonInterfacesImplementationsJHotDraw.txt");
				FileOutputStream myFileOutputStream = new FileOutputStream(myfile);
				bwInterfacesImpJHotDraw = new BufferedWriter(new OutputStreamWriter(myFileOutputStream));
				
				
				File myfile2 = new File("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\ComparisonSuperclassesChildrenJHotDraw.txt");
				FileOutputStream myFileOutputStream2 = new FileOutputStream(myfile2);
				bwSuperclassesChildrenJHotDraw = new BufferedWriter(new OutputStreamWriter(myFileOutputStream2));
			
				File myfile3 = new File("C:\\Users\\mouna\\new_workspace\\TracePredictorFinal\\src\\JHotDrawFiles\\MethodCalls.txt");
				FileOutputStream myFileOutputStream3 = new FileOutputStream(myfile3);
				 bwJHotDrawMethodCallsWriter = new BufferedWriter(new OutputStreamWriter(myFileOutputStream3));
				 
				 bwJHotDrawRunResultsWriter = new BufferedWriter(new FileWriter("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\RunResultsjhotdraw.txt", true));

				
		}
		// bwfile2.newLine();
		

	}
	
	
	
	
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/**
	 * @param ownerClassPredictionValues 
	 * @param logInfoHashMap 
	 * @param string2 
	 * @param string **********************************************************************************************************************************************/

	
	
	public static void ComputePrecisionAndRecallNONCUMULATIVE(
			HashMap<String, MethodTrace> methodTraceHashMap,
			PredictionEvaluation Pattern, String ProgramName,  PredictionValues ownerClassPredictionValues, LinkedHashMap<String, LogInfo> logInfoHashMap) throws SQLException {
		// TODO Auto-generated method stub
	Pattern.ResetCounters(Pattern);

		for (String mykey : AlgoFinal.methodtraces2HashMap.keySet()) {
			MethodTrace methodTrace = methodTraceHashMap.get(mykey);
			
			if(ProgramName.equals("gantt")|| ProgramName.equals("jhotdraw")){
				if(methodTrace.isTraceSet()) {
					String Result="E"; 
					Pattern.UpdateCounters(Result, Pattern);

				}
				if (methodTrace.getGold() != null && methodTrace.getPrediction() != null 
						&& methodTraceHashMap.get(mykey).isSubjectDeveloperEqualityFlag()
						&& !methodTrace.isTraceSet() ) {
					String Result = Pattern.ComparePredictionToGold(methodTrace.getGold().trim(),methodTrace.getPrediction().trim());
					logInfoHashMap.get(mykey).setPrecisionRecall(Result);
					Pattern.UpdateCounters(Result, Pattern);
					
					if(!Result.equals("E")) {
						methodTrace.setTraceSet(true);
					}

				}
				
				ownerClassPredictionValues.ComputePredictionValues(ownerClassPredictionValues, methodTrace.getPrediction().trim());

			}else if(ProgramName.equals("chess")|| ProgramName.equals("itrust") ) {
				if(methodTrace.isTraceSet()) {
					String Result="E"; 
					Pattern.UpdateCounters(Result, Pattern);

				}
				if (methodTrace.getGold() != null && methodTrace.getPrediction() != null 
						&& !methodTrace.isTraceSet()) {
					String Result = Pattern.ComparePredictionToGold(methodTrace.getGold().trim(),	methodTrace.getPrediction().trim());
					logInfoHashMap.get(mykey).setPrecisionRecall(Result);
					Pattern.UpdateCounters(Result, Pattern);
					if(!Result.equals("E")) {
						methodTrace.setTraceSet(true);

					}
				


				}
				ownerClassPredictionValues.ComputePredictionValues(ownerClassPredictionValues, methodTrace.getPrediction().trim());

			}

		

			


		}
		System.out.println(Pattern.toString());

	}
	
	
	
	
	
	public static void ComputePrecisionAndRecallCUMULATIVE(
			HashMap<String, MethodTrace> methodTraceHashMap,
			PredictionEvaluation Pattern, String ProgramName,  PredictionValues ownerClassPredictionValues, LinkedHashMap<String, LogInfo> logInfoHashMap) throws SQLException {
		// TODO Auto-generated method stub
	Pattern.ResetCounters(Pattern);

		for (String mykey : AlgoFinal.methodtraces2HashMap.keySet()) {
			MethodTrace methodTrace = methodTraceHashMap.get(mykey);
			
			if(ProgramName.equals("gantt")|| ProgramName.equals("jhotdraw")){
				if (methodTrace.getGold() != null && methodTrace.getPrediction() != null 
						&& methodTraceHashMap.get(mykey).isSubjectDeveloperEqualityFlag()
						) {
					String Result = Pattern.ComparePredictionToGold(methodTrace.getGold().trim(),methodTrace.getPrediction().trim());
					logInfoHashMap.get(mykey).setPrecisionRecall(Result);
					Pattern.UpdateCounters(Result, Pattern);
					


				}else {
					String Result = Pattern.ComparePredictionToGold(methodTrace.getGold().trim(),"E");
					logInfoHashMap.get(mykey).setPrecisionRecall(Result);
					Pattern.UpdateCounters(Result, Pattern);
				}
				
//				ownerClassPredictionValues.ComputePredictionValues(ownerClassPredictionValues, methodTrace.getPrediction().trim());

			}else if(ProgramName.equals("chess")|| ProgramName.equals("itrust") ) {
			
				if (methodTrace.getGold() != null && methodTrace.getPrediction() != null 
					) {
					String Result = Pattern.ComparePredictionToGold(methodTrace.getGold().trim(),
							methodTrace.getPrediction().trim());
					logInfoHashMap.get(mykey).setPrecisionRecall(Result);
					Pattern.UpdateCounters(Result, Pattern);
				
				


				}
//				ownerClassPredictionValues.ComputePredictionValues(ownerClassPredictionValues, methodTrace.getPrediction().trim());

			}

		

			


		}
		System.out.println(Pattern.toString());

	}
	public static void updateResultsLog(PredictionEvaluation TotalPattern,  PredictionValues ownerClassPredictionValues, String ProgramName, String precisionRecall, String PredictionValues, String Type) throws IOException {
		// TODO Auto-generated method stub
		
		//CODE  TO PASTE INTO EXCEL SPREADSHEET 
		if(Type.equals("INDIVIDUAL") || Type.equals("CUMULATIVE") ) {
			LogInfo.bwfile1.write(TotalPattern.TruePositive+","+TotalPattern.TrueNegative+","+TotalPattern.FalsePositive+","+TotalPattern.FalseNegative+","+TotalPattern.E);
			
			LogInfo.bwfile1.write(","+ownerClassPredictionValues.T+","+ownerClassPredictionValues.N+","+ownerClassPredictionValues.E+",");
	
//			LogInfo.bwfile1.newLine();

		
			if(Type.equals("CUMULATIVE")) {
				LogInfo.bwfile1.newLine();
			}
			
		
		}
		
		//END CODE  TO PASTE INTO EXCEL SPREADSHEET 
//		else if(Type.equals("CUMULATIVE")) {
//			LogInfo.bwfileCumulative.write(TotalPattern.TruePositive+","+TotalPattern.TrueNegative+","+TotalPattern.FalsePositive+","+TotalPattern.FalseNegative+","+TotalPattern.E);
//			
//			LogInfo.bwfileCumulative.write(","+ownerClassPredictionValues.T+","+ownerClassPredictionValues.N+","+ownerClassPredictionValues.E);
//	
//			LogInfo.bwfileCumulative.newLine();
//		}
		


		
		
		
//		LogInfo.bwfile1.write(" OUTPUT COMPLETENESS T: "+Type+"   "+(float)TotalPattern.TruePositive/(TotalPattern.TruePositive+TotalPattern.TrueNegative+TotalPattern.FalsePositive+TotalPattern.FalseNegative+TotalPattern.E)); //TP/(TP+TN+FP+FN+E)
//		LogInfo.bwfile1.newLine();
//		LogInfo.bwfile1.write(" OUTPUT COMPLETENESS N: "+Type+"   "+(float)TotalPattern.TrueNegative/(TotalPattern.TruePositive+TotalPattern.TrueNegative+TotalPattern.FalsePositive+TotalPattern.FalseNegative+TotalPattern.E)); //TN/(TP+TN+FP+FN+E)
//		LogInfo.bwfile1.newLine();
//		LogInfo.bwfile1.write(" OUTPUT COMPLETENESS E: "+Type+"   "+(float)TotalPattern.E/(TotalPattern.TruePositive+TotalPattern.TrueNegative+TotalPattern.FalsePositive+TotalPattern.FalseNegative+TotalPattern.E));//E/(TP+TN+FP+FN+E)
//		LogInfo.bwfile1.newLine();
//		if(TotalPattern.TruePositive+TotalPattern.FalsePositive!=0) {
//			LogInfo.bwfile1.write(" OUTPUT CORRECTNESS PRECISION T: "+Type+"   "+(float)TotalPattern.TruePositive/(TotalPattern.TruePositive+TotalPattern.FalsePositive)); //TP/(TP+FP)); 
//			LogInfo.bwfile1.newLine();
//		}else {
//			LogInfo.bwfile1.write(" OUTPUT CORRECTNESS PRECISION T: "+Type+"   "+0); 
//			LogInfo.bwfile1.newLine();
//		}
//		if(TotalPattern.TrueNegative+TotalPattern.FalseNegative!=0) {
//			LogInfo.bwfile1.write(" OUTPUT CORRECTNESS PRECISION N: "+Type+"   "+(float)TotalPattern.TrueNegative/(TotalPattern.TrueNegative+TotalPattern.FalseNegative)); //TN/(FN+TN)
//			LogInfo.bwfile1.newLine();
//		}else {
//			LogInfo.bwfile1.write(" OUTPUT CORRECTNESS PRECISION N: "+Type+"   "+0); 
//			LogInfo.bwfile1.newLine();
//		}
//		if(TotalPattern.TruePositive+TotalPattern.FalseNegative!=0) {
//			LogInfo.bwfile1.write(" OUTPUT CORRECTNESS RECALL T: "+Type+"   "+(float)TotalPattern.TruePositive/(TotalPattern.TruePositive+TotalPattern.FalseNegative)); //TP/(TP+FN)
//			LogInfo.bwfile1.newLine();
//		}else {
//			LogInfo.bwfile1.write(" OUTPUT CORRECTNESS RECALL T: "+Type+"   "+0); 
//			LogInfo.bwfile1.newLine();
//		}
//		if(TotalPattern.FalsePositive+TotalPattern.TrueNegative!=0) {
//			LogInfo.bwfile1.write(" OUTPUT CORRECTNESS RECALL N: "+Type+"   "+(float)TotalPattern.TrueNegative/(TotalPattern.FalsePositive+TotalPattern.TrueNegative)); //TN/(FP+TN)
//			LogInfo.bwfile1.newLine();
//		}else {
//			LogInfo.bwfile1.write(" OUTPUT CORRECTNESS RECALL N: "+Type+"   "+0); 
//			LogInfo.bwfile1.newLine();
//		}
//				
//		
//		LogInfo.bwfile1.newLine();
//
//		LogInfo.bwfile1.write("PREDICTION PERCENTAGE T: "+Type+"   "+ (float)ownerClassPredictionValues.T/(ownerClassPredictionValues.T+ownerClassPredictionValues.N+ownerClassPredictionValues.E));
//		LogInfo.bwfile1.newLine();
//		LogInfo.bwfile1.write(" PREDICTION PERCENTAGE N: "+Type+"   "+ (float)ownerClassPredictionValues.N/(ownerClassPredictionValues.T+ownerClassPredictionValues.N+ownerClassPredictionValues.E));
//		LogInfo.bwfile1.newLine();
//		LogInfo.bwfile1.write(" PREDICTION PERCENTAGE E: "+Type+"   "+ (float)ownerClassPredictionValues.E/(ownerClassPredictionValues.T+ownerClassPredictionValues.N+ownerClassPredictionValues.E));
//		LogInfo.bwfile1.newLine();
//		LogInfo.bwfile1.newLine();
		
		
		
		
		//ORIGINAL CODE FOR PRECISION RECALL 
//		LogInfo.bwfile1.write(precisionRecall+"                  "+ProgramName+"                     "+TotalPattern.toString());
//		LogInfo.bwfile1.newLine();
//		LogInfo.bwfile1.write(PredictionValues+"     "+ProgramName+"                     "+ownerClassPredictionValues.toString());
//		LogInfo.bwfile1.newLine();
//		LogInfo.bwfile1.write("-------------------------------------------------------------------");
		//END ORIGINAL CODE FOR PRECISION RECALL 
//		LogInfo.bwfile1.newLine();
	}
	public static void updateTableLog(String ProgramName, Collection<MethodTrace> MethodTracesHashmapValues, LinkedHashMap<String, LogInfo> LogInfoHashMap) throws IOException {
		// TODO Auto-generated method stub			
		 // Create a new file output stream.
       
		if (ProgramName.equals("chess")|| ProgramName.equals("test")) {
			
			LogInfo.bwfileChess.write(
					"MethodID, MethodName, RequirementID, RequirementName, ClassID, ClassName, "
					+ "Gold, TraceClassValue,"
					+" Interfaces, InterfacesPredictions, Implementations, ImplementationsPredictions, Parents, ParentPredictions, Children, ChildrenPredictions,"
					+" Callers, CallersPredictions, CallersOwnerValues,"
					+" InterfaceCallers, InterfaceCallersPredictions, InterfaceCallersOwnerValues,"
					+" SuperclassCallers, SuperclassCallersPredictions, SuperclassCallersOwnerValues,"
					+" ImplementationCallers, ImplementationCallersPredictions, ImplementationCallersOwnerValues,"
					+" ChildrenCallers, ChildrenCallersPredictions, ChildrenCallersOwnerValues,"	
					+" Callees, CalleesPredictions, CalleesOwnerValues,"
					+" ImplementationCallees, ImplementationCalleesPredictions, ImplementationCalleesOwnerValues,"
					+" ChildrenCallees, ChildrenCalleesPredictions, ChildrenCalleesOwnerValues,"
					+" SuperclassCallees, SuperclassCalleesPredictions, SuperclassCalleesOwnerValues,"
					+" CalleesCalleesInterfaceInheritance, CalleesCalleesInterfaceInheritancePredictions, CalleesCalleesInterfaceInheritanceOwners,"
					+"ExtendedCallees, ExtendedCalleesPredictions, ExtendedOwnerCallees, ExtendedCallers, ExtendedCallersPredictions,ExtendedOwnerCallers,"
					+"ExecutedCallees, ExecutedCalleesPredictions, ExecutedOwnerCallees, ExecutedCallers, ExecutedCallersPredictions,ExecutedOwnerCallers,"

					+ "Prediction,"
					+ "PrecisionRecall,IterationValues"
					);
			LogInfo.bwfileChess.newLine();
		}
		if (ProgramName.equals("gantt")) {
	
			LogInfo.bwfile2.write(
					"MethodID, MethodName, RequirementID, RequirementName, ClassID, ClassName, "
					+ "Gold, TraceClassValue,"
					+" Interfaces, InterfacesPredictions, Implementations, ImplementationsPredictions, Parents, ParentPredictions, Children, ChildrenPredictions,"
					+" Callers, CallersPredictions, CallersOwnerValues,"
					+" InterfaceCallers, InterfaceCallersPredictions, InterfaceCallersOwnerValues,"
					+" SuperclassCallers, SuperclassCallersPredictions, SuperclassCallersOwnerValues,"
					+" ImplementationCallers, ImplementationCallersPredictions, ImplementationCallersOwnerValues,"
					+" ChildrenCallers, ChildrenCallersPredictions, ChildrenCallersOwnerValues,"	
					+" Callees, CalleesPredictions, CalleesOwnerValues,"
					+" ImplementationCallees, ImplementationCalleesPredictions, ImplementationCalleesOwnerValues,"
					+" ChildrenCallees, ChildrenCalleesPredictions, ChildrenCalleesOwnerValues,"
					+" SuperclassCallees, SuperclassCalleesPredictions, SuperclassCalleesOwnerValues,"
					+" CalleesCalleesInterfaceInheritance, CalleesCalleesInterfaceInheritancePredictions, CalleesCalleesInterfaceInheritanceOwners,"
					+"ExtendedCallees, ExtendedCalleesPredictions, ExtendedOwnerCallees, ExtendedCallers, ExtendedCallersPredictions,ExtendedOwnerCallers,"
					+"ExecutedCallees, ExecutedCalleesPredictions, ExecutedOwnerCallees, ExecutedCallers, ExecutedCallersPredictions,ExecutedOwnerCallers,"

					+ "Prediction,"
					+ "PrecisionRecall,IterationValues"
					);
			LogInfo.bwfile2.newLine();
		}
		if (ProgramName.equals("itrust")) {
			

			 // Create a new file output stream.
            PrintStream fileOut = new PrintStream("C:\\Users\\mouna\\ownCloud\\Mouna Hammoudi\\dumps\\LatestLogFiles\\TableLogiTrust.txt");
            
            // Redirect standard out to file.
//            System.setOut(fileOut);
//			System.out.println(
//					"MethodID, MethodName, RequirementID, RequirementName, ClassID, ClassName, "
//					+ "Gold, TraceClassValue,"
//					+" Callers, CallersPredictions, CallersOwnerValues,"
//					+" InterfaceCallers, InterfaceCallersPredictions, InterfaceCallersOwnerValues,"
//					+" SuperclassCallers, SuperclassCallersPredictions, SuperclassCallersOwnerValues,"
//					+" CallersCallers, CallersCallersPredictions, CallersCallersOwnerValues,"
//					+" InterfaceCallersCallers, InterfaceCallersCallersPredictions, InterfaceCallersCallersOwnerValues,"
//					+" SuperclassCallersCallers, SuperclassCallersCallersPredictions, SuperclassCallersCallersOwnerValues,"
//					
//					+" Callees, CalleesPredictions, CalleesOwnerValues,"
//					+" ImplementationCallees, ImplementationCalleesPredictions, ImplementationCalleesOwnerValues,"
//					+" ChildrenCallees, ChildrenCalleesPredictions, ChildrenCalleesOwnerValues,"
//					+" CalleesCallees, CalleesCalleesPredictions, CalleesCalleesOwnerValues,"
//					+" ImplementationCalleesCallees, ImplementationCalleesCalleesPredictions, ImplementationCalleesCalleesOwnerValues,"
//					+" ChildrenCalleesCallees, ChildrenCalleesCalleesPredictions, ChildrenCalleesCalleesOwnerValues,"
//					+ "PrecisionRecall,IterationValues"
//					);
			LogInfo.bwfile3.write(
					"MethodID, MethodName, RequirementID, RequirementName, ClassID, ClassName, "
					+ "Gold, TraceClassValue,"
					+" Interfaces, InterfacesPredictions, Implementations, ImplementationsPredictions, Parents, ParentPredictions, Children, ChildrenPredictions,"
					+" Callers, CallersPredictions, CallersOwnerValues,"
					+" InterfaceCallers, InterfaceCallersPredictions, InterfaceCallersOwnerValues,"
					+" SuperclassCallers, SuperclassCallersPredictions, SuperclassCallersOwnerValues,"
					+" ImplementationCallers, ImplementationCallersPredictions, ImplementationCallersOwnerValues,"
					+" ChildrenCallers, ChildrenCallersPredictions, ChildrenCallersOwnerValues,"	
					+" Callees, CalleesPredictions, CalleesOwnerValues,"
					+" ImplementationCallees, ImplementationCalleesPredictions, ImplementationCalleesOwnerValues,"
					+" ChildrenCallees, ChildrenCalleesPredictions, ChildrenCalleesOwnerValues,"
					+" SuperclassCallees, SuperclassCalleesPredictions, SuperclassCalleesOwnerValues,"
					+" CalleesCalleesInterfaceInheritance, CalleesCalleesInterfaceInheritancePredictions, CalleesCalleesInterfaceInheritanceOwners,"
					+"ExtendedCallees, ExtendedCalleesPredictions, ExtendedOwnerCallees, ExtendedCallers, ExtendedCallersPredictions,ExtendedOwnerCallers,"
					+"ExecutedCallees, ExecutedCalleesPredictions, ExecutedOwnerCallees, ExecutedCallers, ExecutedCallersPredictions,ExecutedOwnerCallers,"

					+ "Prediction,"
					+ "PrecisionRecall,IterationValues"
					);
			LogInfo.bwfile3.newLine();
		}
		if (ProgramName.equals("jhotdraw")) {

			LogInfo.bwfile4.write(
					"MethodID, MethodName, RequirementID, RequirementName, ClassID, ClassName, "
					+ "Gold, TraceClassValue,"
					+" Interfaces, InterfacesPredictions, Implementations, ImplementationsPredictions, Parents, ParentPredictions, Children, ChildrenPredictions,"
					+" Callers, CallersPredictions, CallersOwnerValues,"
					+" InterfaceCallers, InterfaceCallersPredictions, InterfaceCallersOwnerValues,"
					+" SuperclassCallers, SuperclassCallersPredictions, SuperclassCallersOwnerValues,"
					+" ImplementationCallers, ImplementationCallersPredictions, ImplementationCallersOwnerValues,"
					+" ChildrenCallers, ChildrenCallersPredictions, ChildrenCallersOwnerValues,"	
					+" Callees, CalleesPredictions, CalleesOwnerValues,"
					+" ImplementationCallees, ImplementationCalleesPredictions, ImplementationCalleesOwnerValues,"
					+" ChildrenCallees, ChildrenCalleesPredictions, ChildrenCalleesOwnerValues,"
					+" SuperclassCallees, SuperclassCalleesPredictions, SuperclassCalleesOwnerValues,"
					+" CalleesCalleesInterfaceInheritance, CalleesCalleesInterfaceInheritancePredictions, CalleesCalleesInterfaceInheritanceOwners,"
					+"ExtendedCallees, ExtendedCalleesPredictions, ExtendedOwnerCallees, ExtendedCallers, ExtendedCallersPredictions,ExtendedOwnerCallers,"
					+"ExecutedCallees, ExecutedCalleesPredictions, ExecutedOwnerCallees, ExecutedCallers, ExecutedCallersPredictions,ExecutedOwnerCallers,"

					+ "Prediction,"
					+ "PrecisionRecall,IterationValues"
					);
			LogInfo.bwfile4.newLine();
		}
		int count=0; 
		
		HashMap<String, List<String>> InterfacesImplementationsHashMap= new HashMap<String, List<String>>(); 
		HashMap<String, List<String>> SuperclassChildrenHashMap= new HashMap<String, List<String>>(); 

		for (MethodTrace methodtrace : MethodTracesHashmapValues) {
			String reqmethod = methodtrace.Requirement.ID + "-" + methodtrace.Method.ID;
			
			LogInfoHashMap.get(reqmethod);
		

			if (ProgramName.equals("gantt")) {
				LogInfo.bwfile2.write(LogInfoHashMap.get(reqmethod).toString());
				LogInfo.bwfile2.newLine();
				
			
				
			}
			if (ProgramName.equals("chess") ||ProgramName.equals("test")  ) {
				LogInfo.bwfileChess.write(LogInfoHashMap.get(reqmethod).toString());
				LogInfo.bwfileChess.newLine();
				
				
				
				
			}
			if (ProgramName.equals("itrust")) {
//				System.out.println(LogInfoHashMap.get(reqmethod).toString());
				
				//UNCOMMENT THESE TWO LINES BELOW 
				
				LogInfo.bwfile3.write(LogInfoHashMap.get(reqmethod).toString());
				LogInfo.bwfile3.newLine();
				
//				System.out.println("=======>"+reqmethod+"------"+count+"---"+LogInfoHashMap.get(reqmethod).toString());
				count++; 
//			
			}
			if (ProgramName.equals("jhotdraw")) {
				LogInfo.bwfile4.write(LogInfoHashMap.get(reqmethod).toString());
				LogInfo.bwfile4.newLine();
				
				
				
				
				
				
			}
		}
		
		
		
		if (ProgramName.equals("chess")) {
			
			LogInfo.bwfileChess.close();
		} else if (ProgramName.equals("gantt")) {
			
			LogInfo.bwfile2.close();
			

		} else if (ProgramName.equals("itrust")) {
		
			LogInfo.bwfile3.close();
		} else if (ProgramName.equals("jhotdraw")) {
			
			LogInfo.bwfile4.close();

		}
	}
	private static void UpdateInheritanceLogFiles(HashMap<String, List<String>> interfacesImplementationsHashMap, HashMap<String, List<String>> superclassChildrenHashMap, BufferedWriter bwInterfacesImpJHotDraw2, BufferedWriter bwSuperclassesChildrenJHotDraw2) throws IOException {
		// TODO Auto-generated method stub

		for(String mykey: interfacesImplementationsHashMap.keySet()) {
			String methname = AlgoFinal.methodtraces2HashMap.get(mykey).Method.methodname.replaceAll("\\,", "/"); 
			bwInterfacesImpJHotDraw2.write("INTERFACE,"+AlgoFinal.methodtraces2HashMap.get(mykey).Method.ID
					+","+methname+","+
					AlgoFinal.methodtraces2HashMap.get(mykey).Method.Owner.ID
					+","+AlgoFinal.methodtraces2HashMap.get(mykey).Method.Owner.classname
					+","+AlgoFinal.methodtraces2HashMap.get(mykey).Requirement.ID
					+","+AlgoFinal.methodtraces2HashMap.get(mykey).gold
					+","+AlgoFinal.methodtraces2HashMap.get(mykey).prediction);

			bwInterfacesImpJHotDraw2.newLine();
			for(String entry: interfacesImplementationsHashMap.get(mykey)) {
				String methname2 = AlgoFinal.methodtraces2HashMap.get(entry).Method.methodname.replaceAll("\\,", "/"); 
				bwInterfacesImpJHotDraw2.write("IMPLEMENTATION,"+AlgoFinal.methodtraces2HashMap.get(entry).Method.ID
								+","+methname2
								+","+AlgoFinal.methodtraces2HashMap.get(entry).Method.Owner.ID
								+","+AlgoFinal.methodtraces2HashMap.get(entry).Method.Owner.classname
								+","+AlgoFinal.methodtraces2HashMap.get(entry).Requirement.ID
								+","+AlgoFinal.methodtraces2HashMap.get(entry).gold
								+","+AlgoFinal.methodtraces2HashMap.get(entry).prediction);
			
				bwInterfacesImpJHotDraw2.newLine();
			}
		}
		for(String mykey: superclassChildrenHashMap.keySet()) {
			String methname = AlgoFinal.methodtraces2HashMap.get(mykey).Method.methodname.replaceAll("\\,", "/"); 
			bwSuperclassesChildrenJHotDraw2.write("SUPERCLASS,"+AlgoFinal.methodtraces2HashMap.get(mykey).Method.ID
					+","+methname+","+
					AlgoFinal.methodtraces2HashMap.get(mykey).Method.Owner.ID+","+				
					AlgoFinal.methodtraces2HashMap.get(mykey).Method.Owner.classname
					+","+AlgoFinal.methodtraces2HashMap.get(mykey).Requirement.ID
					+","+AlgoFinal.methodtraces2HashMap.get(mykey).gold
					+","+AlgoFinal.methodtraces2HashMap.get(mykey).prediction);

			bwSuperclassesChildrenJHotDraw2.newLine();
			for(String entry: superclassChildrenHashMap.get(mykey)) {
				String methname2 = AlgoFinal.methodtraces2HashMap.get(entry).Method.methodname.replaceAll("\\,", "/"); 
				bwSuperclassesChildrenJHotDraw2.write("CHILDREN,"+AlgoFinal.methodtraces2HashMap.get(entry).Method.ID
								+","+methname2+","+						
								AlgoFinal.methodtraces2HashMap.get(entry).Method.Owner.ID+","+	
								AlgoFinal.methodtraces2HashMap.get(entry).Method.Owner.classname
								+","+AlgoFinal.methodtraces2HashMap.get(entry).Requirement.ID
								+","+AlgoFinal.methodtraces2HashMap.get(entry).gold
								+","+AlgoFinal.methodtraces2HashMap.get(entry).prediction);
			
				bwSuperclassesChildrenJHotDraw2.newLine();
			}
		}
	
	}
	public static void CloseFiles(String ProgramName) throws IOException {
		// TODO Auto-generated method stub
		if (ProgramName.equals("chess")) {
			LogInfo.bwfileChess.close();
		} else if (ProgramName.equals("gantt")) {
			LogInfo.bwfile2.close();
			

		} else if (ProgramName.equals("itrust")) {
			LogInfo.bwfile3.close();
		} else if (ProgramName.equals("jhotdraw")) {
			LogInfo.bwfile4.close();

		}
	}
	public static void closeLogFile() throws IOException {
		// TODO Auto-generated method stub
		LogInfo.bwfile1.newLine();
		LogInfo.bwfile1.close(); 
//		LogInfo.bwfileCumulative.close(); 
	}
	public static void updateInheritanceLogs(String ProgramName, Collection<MethodTrace> MethodTracesHashmapValues,
			LinkedHashMap<String, LogInfo> LogInfoHashMap) throws IOException {
		// TODO Auto-generated method stub			
		 // Create a new file output stream.
      
		if (ProgramName.equals("chess")) {
			LogInfo.bwInterfacesImpChess.write("Type,MethodID,MethodName,ClassID,ClassName,ReqID,gold,Prediction");
			LogInfo.bwInterfacesImpChess.newLine();
			LogInfo.bwSuperclassesChildrenChess.write("Type,MethodID,MethodName,ClassID,ClassName,ReqID,gold,Prediction");
			LogInfo.bwSuperclassesChildrenChess.newLine();
		
		}
		if (ProgramName.equals("gantt")) {
			LogInfo.bwInterfacesImpGantt.write("Type,MethodID,MethodName,ClassID,ClassName,ReqID,gold,Prediction");
			LogInfo.bwInterfacesImpGantt.newLine();
			LogInfo.bwSuperclassesChildrenGantt.write("Type,MethodID,MethodName,ClassID,ClassName,ReqID,gold,Prediction");
			LogInfo.bwSuperclassesChildrenGantt.newLine();
		
		}
		if (ProgramName.equals("itrust")) {
			
			LogInfo.bwInterfacesImpiTrust.write("Type,MethodID,MethodName,ClassID,ClassName,ReqID,gold,Prediction");
			LogInfo.bwInterfacesImpiTrust.newLine();
			LogInfo.bwSuperclassesChildreniTrust.write("Type,MethodID,MethodName,ClassID,ClassName,ReqID,gold,Prediction");
			LogInfo.bwSuperclassesChildreniTrust.newLine();

		}
		if (ProgramName.equals("jhotdraw")) {
			LogInfo.bwInterfacesImpJHotDraw.write("Type,MethodID,MethodName,ClassID,ClassName,ReqID,gold,Prediction");
			LogInfo.bwInterfacesImpJHotDraw.newLine();
			LogInfo.bwSuperclassesChildrenJHotDraw.write("Type,MethodID,MethodName,ClassID,ClassName,ReqID,gold,Prediction");
			LogInfo.bwSuperclassesChildrenJHotDraw.newLine();
			
		}
		int count=0; 
		
		HashMap<String, List<String>> InterfacesImplementationsHashMap= new HashMap<String, List<String>>(); 
		HashMap<String, List<String>> SuperclassChildrenHashMap= new HashMap<String, List<String>>(); 

		for (MethodTrace methodtrace : MethodTracesHashmapValues) {
			String reqmethod = methodtrace.Requirement.ID + "-" + methodtrace.Method.ID;
			
			LogInfoHashMap.get(reqmethod);
			/////////////////////////////////////////////////////////
			if(!methodtrace.Method.Implementations.isEmpty()) {
				ArrayList<String> ImpList = new ArrayList<String>(); 
				for(Method myimp: methodtrace.Method.Implementations) {
					ImpList.add(methodtrace.Requirement.ID+"-"+myimp.ID); 
				}
				InterfacesImplementationsHashMap.put(reqmethod,  ImpList); 
			}
			/////////////////////////////////////////////////////////

			if(!methodtrace.Method.Children.isEmpty()) {
				ArrayList<String> ChildrenList = new ArrayList<String>(); 
				for(Method mychild: methodtrace.Method.Children) {
					ChildrenList.add(methodtrace.Requirement.ID+"-"+mychild.ID); 
				}
				SuperclassChildrenHashMap.put(reqmethod,  ChildrenList); 
			}
			
		}
		if (ProgramName.equals("chess")) {
			
			
			UpdateInheritanceLogFiles(InterfacesImplementationsHashMap, SuperclassChildrenHashMap, bwInterfacesImpChess, bwSuperclassesChildrenChess); 

		}
		
		
		
		if (ProgramName.equals("gantt")) {
			
			
			UpdateInheritanceLogFiles(InterfacesImplementationsHashMap, SuperclassChildrenHashMap, bwInterfacesImpGantt, bwSuperclassesChildrenGantt); 

		}
		
		
		if (ProgramName.equals("itrust")) {			
			UpdateInheritanceLogFiles(InterfacesImplementationsHashMap, SuperclassChildrenHashMap, bwInterfacesImpiTrust, bwSuperclassesChildreniTrust); 
}
		
		
		if (ProgramName.equals("jhotdraw")) {
			
			UpdateInheritanceLogFiles(InterfacesImplementationsHashMap, SuperclassChildrenHashMap, bwInterfacesImpJHotDraw, bwSuperclassesChildrenJHotDraw); 
			
			
			
		}
		
		
		if (ProgramName.equals("chess")) {
			bwInterfacesImpChess.close();
			bwSuperclassesChildrenChess.close();
		} else if (ProgramName.equals("gantt")) {
			bwInterfacesImpGantt.close();
			bwSuperclassesChildrenGantt.close();
			

		} else if (ProgramName.equals("itrust")) {
			bwInterfacesImpiTrust.close();
			bwSuperclassesChildreniTrust.close();
		} else if (ProgramName.equals("jhotdraw")) {
			bwInterfacesImpJHotDraw.close();
			bwSuperclassesChildrenJHotDraw.close();
			

		}
	}
	public static void WriteMethodCalls(String programName) throws IOException, CloneNotSupportedException {
		if(programName.equals("chess")) {
			WriteMethodCallsProgram(bwchessMethodCallsWriter); 
		}
		if(programName.equals("gantt")) {
			WriteMethodCallsProgram(bwGANTTMethodCallsWriter); 
		}
		if(programName.equals("itrust")) {
			WriteMethodCallsProgram(bwiTrustMethodCallsWriter); 
		}
		if(programName.equals("jhotdraw")) {
			WriteMethodCallsProgram(bwJHotDrawMethodCallsWriter); 
		}
	}
	private static void WriteMethodCallsProgram(BufferedWriter bwchessMethodCallsWriter) throws IOException, CloneNotSupportedException {
		// TODO Auto-generated method stub
		for( String meth:DatabaseInput.MethodHashMap.keySet()) {
			for(Method callee: DatabaseInput.MethodHashMap.get(meth).getCalleesShell()) {
				bwchessMethodCallsWriter.write(""+DatabaseInput.MethodHashMap.get(meth).getClassrep().classname+"."+DatabaseInput.MethodHashMap.get(meth).methodname+"---");
				
				bwchessMethodCallsWriter.write(callee.getClassrep().classname+"."+callee.methodname);
				bwchessMethodCallsWriter.newLine();
			}
			

		}
		bwchessMethodCallsWriter.close();
	}
	
	
	private static LinkedHashMap<String, TraceValidator.ENTGoldValues> reinitializeMatrix(
			LinkedHashMap<String, TraceValidator.ENTGoldValues> matrix) {
		// TODO Auto-generated method stub
		return new LinkedHashMap<String, TraceValidator.ENTGoldValues>(){{
			

			put("IsolatedE/", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("NotApplicableE/", new TraceValidator.ENTGoldValues(0,0,0)) ; 

			put("PureTInner/T-T", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("BoundaryEInner/T-N", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableEInner/T-E", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTInner/T-ET", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableEInner/T-EN", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTInner/T-NT", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTInner/T-ENT",  new TraceValidator.ENTGoldValues(0,0,0)) ; 

			put("BoundaryEInner/N-T", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("PureNInner/N-N", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableEInner/N-E", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableEInner/N-ET", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedNInner/N-EN",new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedNInner/N-NT", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedNInner/N-ENT", new TraceValidator.ENTGoldValues(0,0,0)) ; 


			put("UndecidableEInner/E-T", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableEInner/E-N", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableEInner/E-E", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableEInner/E-ET", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableEInner/E-EN", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableEInner/E-NT", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableEInner/E-ENT", new TraceValidator.ENTGoldValues(0,0,0)) ; 

			
			put("MixedTInner/ET-T", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableEInner/ET-N", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableEInner/ET-E", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTInner/ET-NT", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTInner/ET-ET",  new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableEInner/ET-EN", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTInner/ET-ENT",  new TraceValidator.ENTGoldValues(0,0,0)) ; 


			put("UndecidableEInner/EN-T", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedNInner/EN-N", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableEInner/EN-E", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableEInner/EN-NT", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableEInner/EN-ET",new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableEInner/EN-EN", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableEInner/EN-ENT", new TraceValidator.ENTGoldValues(0,0,0)) ; 

			put("MixedTInner/NT-T", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedNInner/NT-N", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableEInner/NT-E", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTInner/NT-NT", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTInner/NT-ET",  new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableEInner/NT-EN", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTInner/NT-ENT",new TraceValidator.ENTGoldValues(0,0,0)) ; 


			


			put("MixedTInner/ENT-T", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedNInner/ENT-N", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableEInner/ENT-E", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTInner/ENT-NT",new TraceValidator.ENTGoldValues(0,0,0)) ; 	
			put("MixedTInner/ENT-ET", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableEInner/ENT-EN", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTInner/ENT-ENT",new TraceValidator.ENTGoldValues(0,0,0)); 
			
			
			/*******************************/

			put("PureTLeaf/T-T", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("BoundaryELeaf/T-N", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableELeaf/T-E", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTLeaf/T-ET", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableELeaf/T-EN", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTLeaf/T-NT", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTLeaf/T-ENT",  new TraceValidator.ENTGoldValues(0,0,0)) ; 

			put("BoundaryELeaf/N-T", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("PureNLeaf/N-N", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableELeaf/N-E", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableELeaf/N-ET", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedNLeaf/N-EN",new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedNLeaf/N-NT", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedNLeaf/N-ENT", new TraceValidator.ENTGoldValues(0,0,0)) ; 


			put("UndecidableELeaf/E-T", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableELeaf/E-N", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableELeaf/E-E", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableELeaf/E-ET", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableELeaf/E-EN", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableELeaf/E-NT", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableELeaf/E-ENT", new TraceValidator.ENTGoldValues(0,0,0)) ; 

			
			put("MixedTLeaf/ET-T", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableELeaf/ET-N", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableELeaf/ET-E", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTLeaf/ET-ET",  new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableELeaf/ET-EN", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTLeaf/ET-NT", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTLeaf/ET-ENT",  new TraceValidator.ENTGoldValues(0,0,0)) ; 


			put("UndecidableELeaf/EN-T", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedNLeaf/EN-N", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableELeaf/EN-E", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableELeaf/EN-ET",new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableELeaf/EN-EN", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableELeaf/EN-NT", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableELeaf/EN-ENT", new TraceValidator.ENTGoldValues(0,0,0)) ; 

			put("MixedTLeaf/NT-T", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedNLeaf/NT-N", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableELeaf/NT-E", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTLeaf/NT-ET",  new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableELeaf/NT-EN", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTLeaf/NT-NT", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTLeaf/NT-ENT",new TraceValidator.ENTGoldValues(0,0,0)) ; 


			


			put("MixedTLeaf/ENT-T", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedNLeaf/ENT-N", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableELeaf/ENT-E", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTLeaf/ENT-ET", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableELeaf/ENT-EN", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTLeaf/ENT-NT",new TraceValidator.ENTGoldValues(0,0,0)) ; 	
			put("MixedTLeaf/ENT-ENT",new TraceValidator.ENTGoldValues(0,0,0)); 
			
			/*******************************/
			
			put("PureTRoot/T-T", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("BoundaryERoot/T-N", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableERoot/T-E", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTRoot/T-ET", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableERoot/T-EN", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTRoot/T-NT", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTRoot/T-ENT",  new TraceValidator.ENTGoldValues(0,0,0)) ; 

			put("BoundaryERoot/N-T", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("PureNRoot/N-N", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableERoot/N-E", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableERoot/N-ET", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedNRoot/N-EN",new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedNRoot/N-NT", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedNRoot/N-ENT", new TraceValidator.ENTGoldValues(0,0,0)) ; 


			put("UndecidableERoot/E-T", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableERoot/E-N", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableERoot/E-E", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableERoot/E-ET", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableERoot/E-EN", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableERoot/E-NT", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableERoot/E-ENT", new TraceValidator.ENTGoldValues(0,0,0)) ; 

			
			put("MixedTRoot/ET-T", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableERoot/ET-N", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableERoot/ET-E", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTRoot/ET-ET",  new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableERoot/ET-EN", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTRoot/ET-NT", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTRoot/ET-ENT",  new TraceValidator.ENTGoldValues(0,0,0)) ; 


			put("UndecidableERoot/EN-T", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedNRoot/EN-N", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableERoot/EN-E", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableERoot/EN-ET",new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableERoot/EN-EN", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableERoot/EN-NT", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableERoot/EN-ENT", new TraceValidator.ENTGoldValues(0,0,0)) ; 

			put("MixedTRoot/NT-T", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedNRoot/NT-N", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableERoot/NT-E", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTRoot/NT-ET",  new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableERoot/NT-EN", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTRoot/NT-NT", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTRoot/NT-ENT",new TraceValidator.ENTGoldValues(0,0,0)) ; 


			


			put("MixedTRoot/ENT-T", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedNRoot/ENT-N", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableERoot/ENT-E", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTRoot/ENT-ET", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("UndecidableERoot/ENT-EN", new TraceValidator.ENTGoldValues(0,0,0)) ; 
			put("MixedTRoot/ENT-NT",new TraceValidator.ENTGoldValues(0,0,0)) ; 	
			put("MixedTRoot/ENT-ENT",new TraceValidator.ENTGoldValues(0,0,0)); 
		}}; 
	}
	public static void updateRunMethodResults(List<MethodTrace> methodtraces, int runNumber, int errorSeedingPercentage, String requirementID, BufferedWriter mybufferWriter) throws IOException {

		TraceValidator.Prediction.Matrix= reinitializeMatrix(TraceValidator.Prediction.Matrix); 

		for(MethodTrace methodTrace: methodtraces) {
			String reqMethod = methodTrace.Requirement.ID+"-"+methodTrace.Method.ID; 
//			System.out.println(methodTrace +"     "+methodTrace.getPatternAndType()+"   ");
			TraceValidator.ENTGoldValues GoldValues=TraceValidator.Prediction.Matrix.get(methodTrace.getPatternAndType());  
			
				
			
			if(methodTrace.getGold().equals("E")) {
				int E=GoldValues.getE(); 
				E=E+1; 
				GoldValues.setE(E);
				TraceValidator.Prediction.Matrix.put(methodTrace.getPatternAndType(),GoldValues);

			}else if(methodTrace.getGold().equals("N")) {
				int N=GoldValues.getN(); 
				N=N+1; 
				GoldValues.setN(N);
				TraceValidator.Prediction.Matrix.put(methodTrace.getPatternAndType(),GoldValues);

			}else if(methodTrace.getGold().equals("T")) {
				int T=GoldValues.getT(); 
				T=T+1; 
				GoldValues.setT(T);
				TraceValidator.Prediction.Matrix.put(methodTrace.getPatternAndType(),GoldValues);
			}
		}
		
//		String headers="Run#, %Seeding, Requirement, "; 
		String line= runNumber+","+AlgoFinal.ErrorSeedingPercentages.get(runNumber+"-"+requirementID)+","+requirementID+","; 
		
			
		
		for(String mykey: TraceValidator.Prediction.Matrix.keySet()) {
//			headers=headers+mykey+"/GoldE"+","+mykey+"/GoldN"+","+mykey+"/GoldT"+","; 
			line=line+TraceValidator.Prediction.Matrix.get(mykey).getE()+","+TraceValidator.Prediction.Matrix.get(mykey).getN()+","+TraceValidator.Prediction.Matrix.get(mykey).getT()+","; 
			

			}
//		mybufferWriter.write(headers);
//		mybufferWriter.newLine();
		mybufferWriter.write(line);


		mybufferWriter.newLine();

	
	
//	if(AlgoFinal.NoSeeding) {
		
			mybufferWriter.close();
		

//	}
}
	
	
	
	
	public static void CheckCallersCalleesSymmetry() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		HashMap<Method, List<Method>>	CallerHashMap= new HashMap<Method, List<Method>>(); 
		HashMap<Method, List<Method>>	CalleeHashMap= new HashMap<Method, List<Method>>(); 
		for (String methodKey : DatabaseInput.MethodHashMap.keySet()) {
			Method method = DatabaseInput.MethodHashMap.get(methodKey); 
			CallerHashMap.put(method, method.getCallersShell()); 
			CalleeHashMap.put(method, method.getCalleesShell()); 	
		}	
		for(Method calleekey: CallerHashMap.keySet()){
			List<Method> callermethods = CallerHashMap.get(calleekey); 
			for(Method caller: callermethods) {
				if(caller!=null && calleekey!=null && CalleeHashMap.get(caller)!=null && !CalleeHashMap.isEmpty()) {
					if(CalleeHashMap.get(caller).contains(calleekey)) {
						System.out.println("yes");
					}else {
						System.out.println("no");
					}
				}
				
			}
		}
	}
	public static void updateRunResultsHeaders(List<MethodTrace> methodtraces, int runNumber, int errorSeedingPercentage, String requirementID, BufferedWriter mybufferWriter) throws IOException {

		TraceValidator.Prediction.Matrix= reinitializeMatrix(TraceValidator.Prediction.Matrix); 
		String headers="Run#, %Seeding, Requirement, "; 

		
			
				
			
			
		
		
			
		
		for(String mykey: TraceValidator.Prediction.Matrix.keySet()) {
			headers=headers+mykey+"/GoldE"+","+mykey+"/GoldN"+","+mykey+"/GoldT"+","; 
			

			}
		mybufferWriter.write(headers);
		mybufferWriter.newLine();
	

	
	
	
	}



}