import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BitwiseAND {
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		int t,n,k,arr[];
		long max;
		String in[];
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(reader.readLine());
		for(int a =1;a<=t; a++){
			max=0;
			in = reader.readLine().split(" ");
			n = Integer.parseInt(in[0]);
			k = Integer.parseInt(in[1]);
			arr = new int[n];
			for(int i=0;i<n;i++)
				arr[i]=i+1;
			for(int i=0;i<n;i++){
				for(int j=i+1;j<n;j++){
					if((arr[i] & arr[j])>max && (arr[i] & arr[j]) < k)
						max=arr[i]&arr[j];
				}
			}
			System.out.println(max);
		}
	}

}
