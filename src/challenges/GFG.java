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
        
          
         long first= sc.nextLong(); 

         String FirstString =Long.toBinaryString(first);       
        

         if(8>FirstString.length()) {
        	
        	 String repeated = new String(new char[8-FirstString.length()]).replace("\0", "0");
        	 FirstString = repeated+FirstString; 
        	 
         }
         
//         System.out.println(FirstString);
//         System.out.println(SecondString);
         
      
         String[] firstarray = FirstString.split(""); 
      
         
         
        
         
         for(int k=0; k<4; k++) {
        	 String temp=firstarray[k]; 
        	 firstarray[k]=firstarray[k+4];
        	 firstarray[k+4]=temp; 
         }
         String binary=""; 
         for(int k=0; k<8; k++) {
        	binary=binary+firstarray[k]; 
        	
         }
         
         int decimal=Integer.parseInt(binary,2);
         System.out.println(decimal);
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