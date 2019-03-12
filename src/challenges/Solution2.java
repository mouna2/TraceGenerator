package challenges;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;


public class Solution2 {

	

	private static void PrintJobScheduling(int n, int[] array) {
		
		int Maxarea=0; 
		for(int i=0; i<array.length; i++) {
			int area=array[i]; 
			int j=i-1; 
			int k=i+1; 
			boolean flag1=true; 
			boolean flag2=true; 

			while( j>=0 && flag1==true) {
				if(array[j]>=array[i] ) {
					area=area+array[i]; 
					j--; 
				}else {
					flag1=false; 
				}
				
			}
			while( k<=array.length-1 && flag2==true) {
				if(array[k]>=array[i] ) {
					area=area+array[i]; 
					k++; 
				}
				else {
					flag2=false; 
				}
			}
//			System.out.println(i+"   "+area);
			if(area>Maxarea) {
				Maxarea=area; 
			}
			
		}
		
		System.out.println(Maxarea);
	}
	public static void main(String [] args) {
		Scanner sc= new Scanner(System.in); 
		int TestCases=sc.nextInt(); 
//		System.out.println(TestCases);
		
		int counter=0; 
		while(counter<TestCases) {
			int TestCaseSize=sc.nextInt(); 
//			System.out.println(TestCaseSize);

			String TestCase= sc.nextLine(); 
			 TestCase= sc.nextLine(); 

//			System.out.println(TestCase);
			String[] SplittedTestcase = TestCase.split(" "); 
			int [] arr= new int[SplittedTestcase.length]; 
			for(int i=0; i<TestCaseSize; i++) {
				arr[i]=Integer.parseInt(SplittedTestcase[i]); 
			}
			PrintJobScheduling(TestCaseSize, arr); 
//			System.out.println("yes");
			counter++; 
		}
		
	}	
}
