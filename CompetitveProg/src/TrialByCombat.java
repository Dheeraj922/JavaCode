/* created by dheeraj choudhary */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;



public class TrialByCombat {
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		Vector<Integer> v;
		int list[];
		int t,n,m;;
		t=s.nextInt();
		while(t>0)
		{
			v=new Vector<>();
			n=s.nextInt();
			m=s.nextInt();
			list=new int[n];
			for(int i=0;i<n;i++)
				list[i]=s.nextInt();
			for(int j=1;j<=m;j++){
				
				for(int i=0;i<n;i++){
					if(i==0){
						if(list[i]==0 && list[i+1]==1)
							v.add(1);
						else if(list[i]==1 && list[i+1]==1)
							v.add(1);
						else
							v.add(0);
					}
					else if(i==n-1){
						if(list[i]==0 && list[i-1]==1)
							v.add(1);
						else if(list[i]==1 &&  list[i-1]==1)
							v.add(1);
						else
							v.add(0);
						
					}
					else{
						if(list[i]==0 && list[i-1]==1 && list[i+1]==1)
							v.add(1);
						else if(list[i]==1 && list[i-1]==1 && list[i+1]==1)
							v.add(1);
						else
							v.add(0);
					}
					
				}
				for(int i=0;i<n;i++)
					list[i]=v.get(i);
				if(j!=m)
					v.clear();
			}
			
			for(int i=0;i<v.size();i++)
				System.out.print(v.get(i)+" ");
			System.out.println();
			t--;	
		}

		s.close();
	}

}
