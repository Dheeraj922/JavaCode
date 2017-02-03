import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MonkAtGraphFactory {
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int n,d[];
		long sum=0;
		n=Integer.parseInt(reader.readLine());
		d=new int[n];
		String in[];
		in=reader.readLine().split(" ");
		for(int i=0;i<in.length;i++){
			d[i]=Integer.parseInt(in[i]);
			sum+=d[i];
		}
		if(sum==2*(n-1))
			System.out.println("Yes");
		else
			System.out.println("No");
	}

}
