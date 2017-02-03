import java.util.Scanner;


public class Speed {
	public static void main(String args[]){
		int t,n,count=0;
		long speed[];
		Scanner s=new Scanner(System.in);
		t=s.nextInt();
		while(t>0){
			count=1;
			n=s.nextInt();
			speed=new long[n];
			for(int i=0;i<n;i++)
				speed[i]=s.nextLong();
			for(int i=1;i<n;i++){
				if(speed[i]<speed[i-1])
					count++;
				else
					speed[i]=speed[i-1];
			}
			System.out.println(count);
			t--;
		}
		s.close();
	}

}
