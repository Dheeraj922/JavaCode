import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class BennyAndHerSchool {
	public static void main(String args[]) throws NumberFormatException, IOException{
		int t,n,i;
		long j,k;
		long m,x,sum,marks[];
		//BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
		//t=Integer.parseInt(r.readLine());
		Scanner s=new Scanner(System.in);
		t=s.nextInt();
		k=1;
		while(k<=t){
		/*	String []a=r.readLine().split(" ");
			n=Integer.parseInt(a[0]);
			m=Integer.parseInt(a[1]);
			x=Integer.parseInt(a[2]);*/
			
			n=s.nextInt();
			m=s.nextLong();
			x=s.nextLong();
			marks=new long[n];
			sum=0;
			for(i=0;i<n;i++){
				//marks[i]=Integer.parseInt(r.readLine());
				marks[i]=s.nextLong();
			}
			for(i=0;i<n;i++)
				sum+=marks[i];
			for(j=1;j<=m;j++){
				if(((sum+m)/(n+1))<x){
					System.out.println("Impossible");
					break;
				}
				else if((sum+j)/(n+1)>=x){
					System.out.println(j);
					break;
				}
			}
			k++;
		}
		s.close();
	}

}
