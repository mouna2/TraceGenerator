package challenges;


//Initial Template for Java
import java.util.*;
class GFG
{
  public static void main(String args[])
  {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      
      while(t-- > 0)
      {
        
          
          String s = sc.next(); 
//          System.out.println(s);
          String[] arr=s.split(""); 
          int j=0; 
          String str1=arr[j]; 
          int count=0; 
          int sum=0; 
          boolean flag=false; 
          while(j<arr.length) {     
              if(arr[j].equals(str1)) {
            	  count++; 
            	  flag=false; 
            	  if(count==3) {
            		  sum++; 
            		  count=1; 
            	  }
              }else {
            	  
            	  count=1; 
            	  str1=arr[j]; 
              }
             
        	  j++; 
          }
         
          System.out.println(sum);
          
         
      }
  }

private static void Function(int[] arr, int windowSize) {
	// TODO Auto-generated method stub
	for(int i=0; i<arr.length; i++) {
		int j=0; 
		boolean flag=false; 
		while( arr.length-i>=windowSize && j<windowSize) {
//			System.out.println(i+" "+j);
			if(arr[i+j]<0) {
				 flag=true; 
				System.out.print(arr[i+j]+" ");
				break; 
			}
			j++; 
		}
		if(flag==false && arr.length-i>=windowSize ) {
			System.out.print("0 ");

		}
		
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