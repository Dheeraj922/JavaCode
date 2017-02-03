
import java.io.IOException;
import java.util.Scanner;


public class TheAmazingRace {
	public static void main(String args[]) throws NumberFormatException, IOException{
		int t, n,i,j,k;
		long heights[] = null;
		long count[]={0};
		Scanner s=new Scanner(System.in);
		t=s.nextInt();
		while(t>0){
			n=s.nextInt();
			heights=new long[n];
			count=new long[n];
			for( i=0;i<n;i++)
				count[i]=0;
			for( i=0;i<n;i++)
				heights[i]=s.nextLong();
			for( i=0;i<n;i++){
				for( j=i+1,k=i-1;j<n || k>=0;j++,k--){
					if(j<n && (heights[j]<heights[i]))
						++count[i];
					if(k>=0 && (heights[k]<heights[i]))
						++count[i];
				}
				
			}
			long max=count[0],pos=0;
			for(i=1;i<n;i++){
				if(max<(count[i]*i)){
					max=count[i]*i;
					pos=i;
				}
			}
			System.out.println(++pos);
			
			t--;
		}
		
		s.close();
	}

}
