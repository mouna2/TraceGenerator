package challenges;


//Initial Template for Java
import java.util.*;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;
class GFG
{
  public static void main(String args[])
  {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      
      while(t-- > 0)
      {
    	  int size1=sc.nextInt(); 
    	  int size2=sc.nextInt(); 
    	  
    	  int arr1[]= new int [size1]; 
    	  int arr2[]= new int [size2]; 

    	  Function(arr1, arr2, size1, size2); 
    	  
    	  
      }
  }

private static void Function(int[] arr1, int[] arr2, int size1, int size2) {
	int [] newarr= new int[size1+size2]; 
	
    int [] combined = ArrayUtils.addAll(arr1, arr2);
    Integer[] combinedInteger = Arrays.stream( combined ).boxed().toArray( Integer[]::new );

    Arrays.sort(combinedInteger, Collections.reverseOrder());
    
    
    for(int num: combinedInteger) {
    	System.out.print(num+" ");
    }
    System.out.println();
}



}





/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

//User function Template for Java
//Helper class to find largest number with minimum frequency
class Geeks
{
  // function to check if any pair having specified sum
  // and return 1 if so, else 0
  public static void sumExists(int arr[], int n)
  {
  	
	 HashMap <Integer,Integer> myhashmap= new HashMap <Integer,Integer> (); 
	 int count=0; 
  	int sum=0; 
	  for( int element: arr) {
		  
		 sum=sum+element; 
		 if(sum==0) {
			 count++; 
		 }
		 if(myhashmap.containsKey(sum)) {
			 count=count+myhashmap.get(sum); 
			 myhashmap.put(sum, myhashmap.get(sum)+1); 
		 }else {
			 myhashmap.put(sum, 1); 
		 }
		
	  }
	  System.out.println(count);
  	
  }
  
}