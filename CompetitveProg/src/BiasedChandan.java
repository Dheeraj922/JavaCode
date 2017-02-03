import java.util.Scanner;
import java.util.Vector;


public class BiasedChandan {
	public static void main(String args[]){
		int n;
		long sum=0;
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		Vector<Integer> v=new Vector<Integer>();
		for(int i=0;i<n;i++)
			v.add(s.nextInt());
		int k=0;
		int l=v.size();
		while(k<l){
			if(v.get(0)==0)
				continue;
			if(v.get(k)==0){
				v.remove(k);
				v.remove(k-1);
				k=0;
				l=v.size();
			}
			k++;
		}
		if(v.size()==0)
			System.out.println(0);
		else{
			for(int i=0;i<v.size();i++)
				sum+=v.get(i);
			System.out.println(sum);
		}
	
		s.close();
	}

}
