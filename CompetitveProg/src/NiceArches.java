
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class NiceArches {
	public static void main(String args[]){
		int m,count1,count2,count=0;
		boolean flag = true;
		Scanner s=new Scanner(System.in);
		m=s.nextInt();
		ArrayList<String> words=new ArrayList<>();
		for(int i=0;i<m;i++)
			words.add(s.next());
		for(int i=0;i<m;i++){
			count1=0;
			count2=0;
			String str=words.get(i);
			System.out.println(str);
			if(str.length()%2!=0)
				continue;
			Stack<Character> stack=new Stack<>();
			for(int j=0;j<str.length();j++){
				stack.push(str.charAt(j));
			}
			
			int ind=stack.indexOf(stack.peek());
			char ch=stack.pop();
			int k=stack.size()-1;
			while(k>=0 && !stack.empty()){
				if(stack.elementAt(k)==ch)
				{
					int ind1=stack.indexOf(stack.elementAt(k));
					if(((ind-ind1))%2==0){
						flag=false;
						break;
					}
					else{
						stack.removeElementAt(k);
						if(stack.empty()){
							flag=true;
							break;
						}
						ind=stack.indexOf(stack.peek());
						ch=stack.pop();
						k=stack.size()-1;
						
					}
				}
				else
					k--;
			}
			if(flag==false)
				continue;
			else
				count++;
		}
		System.out.println(count);
		s.close();
	}

}
