import java.math.BigInteger;
import java.util.Scanner;
import java.util.Vector;


public class BennyAndSubsets {
	public static void main(String args[]){
		int n,x,i;
		BigInteger size;
		long a[];
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		x=s.nextInt();
		a=new long[n];
		for(i=0;i<n;i++)
			a[i]=s.nextLong();
		size=calculate(a,n,x);
		long res=size.longValue();
		System.out.println(res %(10000007));
		s.close();
	}

	private static BigInteger calculate(long[] a, int n, int x) {
		// TODO Auto-generated method stub
		int j=1;
		Vector<Long> v=new Vector<>();
		BigInteger c=new BigInteger("1");
		BigInteger d=new BigInteger("1");
		 for (int i = 0; i < (1<<n); i++)
	        {
	 
	            // Print current subset
	            for (int k = 0; k < a.length; k++){
	 
	             
	                if ((i & (1 << k)) > 0){
	                    //System.out.print(a[k] + " ");
	                	v.add(a[k]);
	                }
	            }
	 
	            //System.out.println("}");
	            long current=calculateXOR(v);
	            if(current==x){
	            	c=c.add(d);
	            }
	        }
		
		return c;
	}

	private static long calculateXOR(Vector<Long> v) {
		// TODO Auto-generated method stub
		long current=0;
		for(int i=0;i<v.size();i++){
			current=current^v.get(i);
		}
		return current;
		
		
	}

}
