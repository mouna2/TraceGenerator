package challenges;


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/
//A Binary Tree node
class Fibonacci
{
	public static void main (String [] args) {
		int i=5; 
		int counter=5; 
		int j=5; 
		int k=0; 
		
		
		while(j<=counter && j>=i && counter<=10) {
			 
			while(k<i && j==i) {
				System.out.print(" ");
				
				k++; 
			}
			if(k==i) {
				k=0; 
			}
			System.out.print("*");
			
			if(j==counter) {
				System.out.println();
				counter++; 
				i--; 
				j=i; 
			}else {
				j++; 
			}
			
		}
		int counter2=1; 
		int counter3=9; 
		j=1; 
		k=0; 
		while(j>=counter2 && j<=counter3 && counter2!=6) {
			while(k<counter2 && j==counter2) {
				System.out.print(" ");
				
				k++; 
			}
			if(k==counter2) {
				k=0; 
			}
			System.out.print("*");

			if(j==counter3) {
				System.out.println();
				counter2++; 
				counter3--; 
				j=counter2; 
			}else {
				j++; 
			}
			
			
		}
		}
	
	
} 

