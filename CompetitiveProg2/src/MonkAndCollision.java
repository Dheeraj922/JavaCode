import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MonkAndCollision {
	private static int t,n,ans,x[],collision[],index;
	
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		
		String in[];
		t=Integer.parseInt(reader.readLine());
		while(t>0){
			ans=0;
			n=Integer.parseInt(reader.readLine());
			x=new int[n];
			collision=new int[10001];
			in=reader.readLine().split(" ");
			for(int i=0;i<n;i++)
				x[i]=Integer.parseInt(in[i]);
			for(int i=0;i<n;i++){
				index=hashfun(x[i]);
				collision[index]++;
			}
			for(int i=0;i<10001;i++){
				if(collision[i]>1)
					ans=(ans+collision[i])-1;
			}
			System.out.println(ans);
			t--;
		}
	}


	private static int hashfun(int i) {
		return (i%10);
	}

}
