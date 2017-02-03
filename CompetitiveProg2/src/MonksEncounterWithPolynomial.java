import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MonksEncounterWithPolynomial {
	private static long a,b,c,k;
	public static void main(String args[]) throws IOException{
		int t;
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		t=Integer.parseInt(reader.readLine());
		while(t>0){
			String arr[]=reader.readLine().split(" ");
			a=Long.parseLong(arr[0]);
			b=Long.parseLong(arr[1]);
			c=Long.parseLong(arr[2]);
			k=Long.parseLong(arr[3]);
			findMinimumValue(k);
			//System.out.println(ans);
			t--;
		}
	}
	private static void findMinimumValue(long k) {
		long low=0,high=100000;
		long mid=0;
		long ans=0;
		while(low<=high){
			mid=(low+high)/2;
			if((a*(mid*mid)+b*mid+c)>=k){
				ans=mid;
				high=mid-1;
			}
			else
				low=mid+1;
		}
		System.out.println(ans);
	}
}

