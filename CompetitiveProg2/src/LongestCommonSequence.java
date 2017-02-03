import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LongestCommonSequence {
	public static void main(String args[]) throws IOException{
		
		int n,m,a[],b[];
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String in[] = reader.readLine().split(" ");
		n = Integer.parseInt(in[0]);
		m = Integer.parseInt(in[1]);
		a = new int[n];
		b = new int[m];
		in = reader.readLine().split(" ");
		for(int i=0;i<in.length;i++)
			a[i] = Integer.parseInt(in[i]);
		in = reader.readLine().split(" ");
		for(int i=0;i<in.length;i++)
			b[i] = Integer.parseInt(in[i]);
		
		longestCommonSequence(a,b,n,m);
	}

	private static void longestCommonSequence(int[] a, int[] b, int n, int m) {
		int L[][];
		L = new int[n+1][m+1];
		for(int i=0;i<=n;i++){
			for(int j=0;j<=m;j++){
				if(i==0 || j==0)
					L[i][j] = 0;
				else if(a[i-1]==b[j-1])
					L[i][j] = L[i-1][j-1] + 1;
				else
					L[i][j] = max(L[i-1][j],L[i][j-1]);
			}
		}
		
		int index = L[n][m];
		int [] solution = new int[index];
		int i=n, j=m;
		//code to print the longest common subsequence
		
		while(i>0 && j>0){
			if(a[i-1]== b[j-1]){
				solution[index-1] = a[i-1];
				i--;
				j--;
				index--;
			}
			else if(L[i-1][j] > L[i][j-1])
				i--;
			else
				j--;
			
		}
		for(int k=0;k<solution.length;k++)
			System.out.print(solution[k]+" ");
		
	}
	
	//and we are good to go in the rest of 

	private static int max(int a, int b) {
		
		return (a>b) ? a : b;
	}

}
