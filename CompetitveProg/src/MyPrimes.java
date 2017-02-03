import java.util.Scanner;


public class MyPrimes {
	public static void main(String args[])
	{
		int n,count;
		long set[];
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		set=new long[n];
		for (int i = 0; i < n; i++) {
			set[i]=in.nextLong();
		}
		for (int i = 0; i < set.length; i++) {
			count=0;
			for (int j = 0; j < set.length; j++) {
				if (set[i]==set[j]) {
					continue;
					}
				else{
					if(set[i]%set[j]==0){
						count=1;
						break;
						}
				}
			}
			if(count==0)
				System.out.print(set[i]+" ");
		}
		in.close();
		
		
	}

}
