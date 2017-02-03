import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class MonkAndTasks {
	private static long no_of_ones[];
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int t,n;
		long tasks[];
		String in[],binary;
		t=Integer.parseInt(reader.readLine());
		while(t>0){
			n=Integer.parseInt(reader.readLine());
			tasks=new long[n];
			no_of_ones=new long[n];
			in=reader.readLine().split(" ");
			for(int i=0;i<n;i++)
				tasks[i]=Long.parseLong(in[i]);
			for(int i=0;i<n;i++){
				binary=Long.toBinaryString(tasks[i]);
				for(int j=0;j<binary.length();j++){
					if(binary.charAt(j)=='1'){
						no_of_ones[(int) tasks[i]]++;
					}
				}
			}
			Arrays.sort(no_of_ones);
			for(int i=0;i<no_of_ones.length;i++)
				System.out.print(no_of_ones[i]);
			System.out.println();
			t--;
		}
	}

}
