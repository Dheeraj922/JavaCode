import java.util.ArrayDeque;
import java.util.Scanner;


public class MonkAndPowerOfTime {
	public static void main(String args[]){
		int n,no,count=0,c;
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		int ideal[]=new int[n];
		ArrayDeque<Integer> q=new ArrayDeque<>();
		for(int i=0;i<n;i++)
			q.add(s.nextInt());
		for(int i=0;i<n;i++)
			ideal[i]=s.nextInt();
		c=0;
		while(q.peek()!=null){
			if(q.peekFirst()==ideal[c]){
				q.pollFirst();
				count++;
				c++;
			}
			else if(q.peekFirst()!=ideal[c]){
				no=q.pollFirst();
				q.addLast(no);
				count++;
			}
			else
				continue;
		}
		System.out.println(count);
		s.close();
	}

}
