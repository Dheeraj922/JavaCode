import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ChanduAndHisInterns {
	public static void main(String args[]) throws NumberFormatException, IOException{
		int n;
		long x,count,i;
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(reader.readLine());
		while(n>0){
			x=Integer.parseInt(reader.readLine());
			count=0;
			for(i=1;i*i<=x;i++){
				if(x%i==0){
					if(i*i==x)
						count++;
					else
						count+=2;
				}
				if(count>=6)
					break;
			}
			if(count>=4)
				System.out.println("YES");
			else
				System.out.println("NO");
			n--;
		}
	}

}
