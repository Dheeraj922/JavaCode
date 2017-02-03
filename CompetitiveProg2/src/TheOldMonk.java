import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheOldMonk {
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int t,n;
		long a[],b[],ans;
		t=Integer.parseInt(reader.readLine());
		while(t>0){
			n=Integer.parseInt(reader.readLine());
			a=new long[n];
			b=new long[n];
			ans=0;
			String str_a[]=reader.readLine().split(" ");
			String str_b[]=reader.readLine().split(" ");
			for(int i=0;i<n;i++){
				a[i]=Integer.parseInt(str_a[i]);
				b[i]=Integer.parseInt(str_b[i]);
			}
			for(int i=0;i<n-1;i++){
				int l=0,r=b.length,m,p = -1;
				while(l<=r){
					m=(l+r)/2;
					if(b[m]>=a[i]){
						m=l+1;
						p=m;
					}
					else
						r=m-1;
				}
				ans=max(ans,p-i);
			}
			System.out.println(ans);
			t--;
		}
		
	}

	private static long max(long ans, int i) {
		if(ans>=i)
			return ans;
		else
			return i;
	}


}
