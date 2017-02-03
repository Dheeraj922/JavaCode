import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ChanduAndGirlFriendReturns {
	public static void main(String args[]) throws IOException{
		int t,n,m,i;
		long arr1[],arr2[];
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		t=Integer.parseInt(reader.readLine());
		while(t>0){
			String []nos=reader.readLine().split(" ");
			n=Integer.parseInt(nos[0]);
			m=Integer.parseInt(nos[1]);
			arr1=new long[n];
			arr2=new long[m];
			String []a1=reader.readLine().split(" ");
			for(i=0;i<n;i++)
				arr1[i]=Integer.parseInt(a1[i]);
			a1=reader.readLine().split(" ");
			for(i=0;i<m;i++)
				arr2[i]=Integer.parseInt(a1[i]);
			mergeSortDescending(arr1,arr2,0,n-1,n+m-1);
			System.out.println();
			t--;
			
		}
	}

	private static void mergeSortDescending(long[] arr1, long[] arr2, int start, int mid, int end) {
		long aux[]=new long[end-start+1];
		int p=start,q=0,k=0;
		for(int i=start;i<=end;i++){
			if(p==arr1.length)
				aux[k++]=arr2[q++];
			else if(q==arr2.length)
				aux[k++]=arr1[p++];
			else if(p>mid)
				aux[k++]=arr2[q++];
			else if(q>end)
				aux[k++]=arr1[p++];
			else if(arr1[p]>arr2[q])
				aux[k++]=arr1[p++];
			else
				aux[k++]=arr2[q++];
		}
		for(int i=0;i<aux.length;i++)
			System.out.print(aux[i]+" ");
		
	}

}
