import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Vector;


public class UnionAndIntersection {
	public static void main(String args[]) throws NumberFormatException, IOException{
		Vector<Integer> v=new Vector<>();
		int arr1[],arr2[],m,n,i,j;
		System.out.println("Enter the values for both of the m and n");
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		m=Integer.parseInt(reader.readLine());
		n=Integer.parseInt(reader.readLine());
		arr1=new int[m];
		arr2=new int[n];
		System.out.println("Enter the elements of the first array");
		String in[]=reader.readLine().split(" ");
		for( i=0;i<in.length;i++){
			arr1[i]=Integer.parseInt(in[i]);
			v.add(arr1[i]);
		}
		System.out.println("Enter the elements of the second array");
		in=reader.readLine().split(" ");
		for( i=0;i<in.length;i++)
			arr2[i]=Integer.parseInt(in[i]);
		
	/*	Arrays.sort(arr1);
		Arrays.sort(arr2);*/
		for( i=0;i<n;i++){
			if(!isPresent(arr1,0,m-1,arr2[i])){
				v.add(arr2[i]);
			}
				
		}
		System.out.println("Union of the two arrays is: "+v);
		/*if(i==m)
			System.out.println("Array 1 is indeed subset of array 2");*/
		v.clear();
		//Now we have to find the intersection of the two arrays
		for(i=0;i<m;i++){
			if(isPresent(arr2,0,n-1,arr1[i]))
				v.add(arr1[i]);
		}
		System.out.println("Intersection of both the arrays is:"+v);
		System.out.println("Happy Coding");
	}

	private static boolean isPresent(int[] arr2, int i, int j, int k) {
		int mid;
		if(i<=j){
			mid=(i+j)/2;
			if(arr2[mid]==k)
				return true;
			else if(k<arr2[mid])
				return isPresent(arr2,i,mid-1,k);
			else
				return isPresent(arr2,mid+1,j,k);		}
		return false;
	}

}
