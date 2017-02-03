import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class DiscoverTheMonk {
	public static void main(String args[]) throws IOException{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int n,q,i;
		long x;
		long []arr;
		String a[]=reader.readLine().split(" ");
		n=Integer.parseInt(a[0]);
		q=Integer.parseInt(a[1]);
		arr=new long[n];
		String b[]=reader.readLine().split(" ");
		for(i=0;i<n;i++)
			arr[i]=Long.parseLong(b[i]);
		Arrays.sort(arr);
		for(i=1;i<=q;i++){
			x=Long.parseLong(reader.readLine());
			boolean res=binarySearch(arr,n,x);
			System.out.println(res?"YES":"NO");
		}
	}

	private static boolean binarySearch(long[] arr, int n, long x) {
		int left=0,right=n-1,mid;
		while(left<=right){
			mid=left+(right-left)/2;
			if(arr[mid]==x)
				return true;
			else if(x<arr[mid])
				right=mid-1;
			else
				left=mid+1;
		}
		return false;
	}

}
