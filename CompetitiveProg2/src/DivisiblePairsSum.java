import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class DivisiblePairsSum {
	public static void main(String args[]) throws IOException{
		int n,k,arr[],count=0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String in[]=reader.readLine().split(" ");
		n=Integer.parseInt(in[0]);
		k=Integer.parseInt(in[1]);
		arr=new int[n];
		in=reader.readLine().split(" ");
		for(int i=0;i<in.length;i++)
			arr[i]=Integer.parseInt(in[i]);
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(((arr[i]+arr[j])%k==0))
						count++;
			}
		}
		System.out.println(count);
	}

}
