import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Vector;


public class PuchiAndLuggage {
	static long count=0;
	public static void main(String args[]) throws NumberFormatException, IOException{
		int t,n,i;
		long weights[],count,newArray[];
		Vector<Long> v=new Vector<>();
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		t=Integer.parseInt(reader.readLine());
		while(t>0){
			n=Integer.parseInt(reader.readLine());
			weights=new long[n];
			count=0;
			for(i=0;i<n;i++)
				weights[i]=Long.parseLong(reader.readLine());
			for(i=0;i<n-1;i++){
					count=0;
					newArray=new long[n-1-i];
					System.arraycopy(weights, i+1, newArray, 0, n-1-i);
					Arrays.sort(newArray);
					int j=0;
					while(j<(n-1-i)){
						if(newArray[j]>weights[i])
							break;
						else
							count++;
						j++;
					}
					//System.out.println(count);
					v.add(count);
				}
			v.add((long) 0);
			for( i=0;i<v.size();i++)
				System.out.print(v.get(i)+" ");
			System.out.println();
			t--;
			}
		}

}
