import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class MonkAndPokemons2 {
	private static int hashTable[];
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int t,n,count = 0,a,b;
		String in[];
		hashTable=new int[1000001];
		t=Integer.parseInt(reader.readLine());
		while(t>0){
			Arrays.fill(hashTable, 0);
			count=0;
			n=Integer.parseInt(reader.readLine());
			for(int i=0;i<n;i++){
				in=reader.readLine().split(" ");
				a=Integer.parseInt(in[0]);
				b=Integer.parseInt(in[1]);
				insert(a);
				if(hashTable[b]!=0)
					hashTable[b]--;
				else
					count++;
				
			}
			System.out.println(count);
			t--;
		}
	}

	private static void insert(int b) {
		hashTable[b]++;
		
		}

}
