import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




public class ChanduAndHisGirlfriend {
	public static void main(String args[]) throws NumberFormatException, IOException{
		int t,n,i;
		long arr[];
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		t=Integer.parseInt(reader.readLine());
		while(t>0){
			n=Integer.parseInt(reader.readLine());
			arr=new long[n];
			String []nos=reader.readLine().split(" ");
			for(i=0;i<n;i++)
				arr[i]=Integer.parseInt(nos[i]);
			quicksortDescending(arr,0,n-1);
			//quicksort(arr, 0, n-1);
			for(i=0;i<n;i++)
				System.out.print(arr[i]+" ");
			System.out.println();
			t--;
		}
		
	}

	private static void quicksortDescending(long[] arr, int low, int high) {
		int i=low;
		int j=high;
		long mid=arr[(low+high)/2];
		long temp;
		while(i<j){
			while(arr[i]>mid){
				i++;
			}
			while(arr[j]<mid)
				j--;
			if(j>=i){
				temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				i++;
				j--;
			}
		}
		if(low<j)
			quicksortDescending(arr, low, j);
		if(i<high)
			quicksortDescending(arr, i, high);
	}

	private static void quicksort(long[] arr, int start, int end) {
		if(start<end){
			int piv_pos=rand_partition(arr,start,end);
			quicksort(arr,start,piv_pos-1);
			quicksort(arr,piv_pos+1,end);
		}
	}

	private static int rand_partition(long[] arr, int start, int end) {
		int random=(int) (start+Math.random()%(start+end-1));
		//swap(arr[start],arr[random]);
		long temp=arr[start];
		arr[start]=arr[random];
		arr[random]=temp;
		
		return partition(arr,start,end);
	}

	private static int partition(long[] arr, int start, int end) {
		int i=start+1;
		long piv=arr[start];
		for(int j=start+1;j<=end;j++){
			if(arr[j]<piv){
				long temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				i++;
			}
		}
		swap(arr[start],arr[i-1]);
		return i-1;
	}

	private static void swap(long l, long m) {
		long temp;
		temp=l;
		l=m;
		m=temp;
		
	}
	

}
