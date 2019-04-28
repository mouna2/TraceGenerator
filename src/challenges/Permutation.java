package challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

// Java program to print all permutations of a 
// given string. 
public class Permutation 
{ 
    public static void main(String[] args) 
    { 
        Scanner sc= new Scanner(System.in); 
        int TestCases=sc.nextInt();
        int count=0; 
        while(count<TestCases) {
        	int amount= sc.nextInt();  
        	int myindex=0; 
        	String s =""; 
        	while(myindex<amount) {
        		s=s+" "+sc.nextInt(); 
        		myindex++; 
        	}
        	func(s);      	
        	count++; 
        }
    }

	private static void func(String s) {
		
			String[] myarr = s.trim().split(" "); 
			int [] arr2=new int[myarr.length]; 
			int i=0; 
			for(String s2: myarr) {
				arr2[i]=Integer.parseInt(s2); 
				i++; 
			}
			Arrays.sort(arr2);
			boolean flag=false; 
			for(int j=0; j<arr2.length-1; j+=2) {
				if(arr2[j]==arr2[j+1]) {
					
				}
				else {
					System.out.println(arr2[j]);
					flag=true; 
					break; 
				}
			}
		if(flag==false) {
			System.out.println(arr2[arr2.length-1]);
		}
	}


}
   