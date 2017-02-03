import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LeftRotateTheArray {
	public static void main(String args[]) throws IOException
	{
		long arr[];
		int n,d;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String in[] = reader.readLine().split(" ");
		n = Integer.parseInt(in[0]);
		d = Integer.parseInt(in[1]);
		arr = new long[n];
		in = reader.readLine().split(" ");
		for(int i=0;i<in.length;i++)
			arr[i] = Long.parseLong(in[i]);
		for(int i=d;i<n;i++)
			System.out.print(arr[i]+" ");
		for(int i=0;i<d;i++)
			System.out.print(arr[i]+" ");
			
	}

}
