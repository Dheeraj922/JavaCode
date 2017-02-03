import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TheConfusedMonk {
	public static void main(String args[]) throws NumberFormatException, IOException{
		int n;
		long arr[],gcd;
		long c=1000000007,solution=0;
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(reader.readLine());
		arr=new long[n];
		String a[]=reader.readLine().split(" ");
		for(int i=0;i<n;i++)
			arr[i]=Integer.parseInt(a[i]);
		gcd=arr[0];
		for(int i=1;i<n;i++)
			gcd=calculateGcd(gcd,arr[i]);
		//System.out.println(gcd);
		solution=calculateSolution(arr,gcd,c);
		System.out.println(solution);
		
		
	}

	private static long calculateSolution(long[] arr, long gcd, long c) {
		long ans=1,b;
		for(int i=0;i<arr.length;i++){
			b=gcd;
		while(b!=0){
			if(b%2==1){
				ans=(ans*arr[i])%c;
			}
			arr[i]=(arr[i]*arr[i])%c;
			b/=2;
		}
		}
		
		return ans;
	}

	private static long calculateGcd(long gcd, long b) {
		if(b==0)
			return gcd;
		else
			return calculateGcd(b,gcd%b);
	}

}
