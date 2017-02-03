import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class BalancedBrackets {
	
	public static void main(String args[]) throws IOException, NumberFormatException{
		
		int n,j;
		Stack<Character> stack;
		char []arr;
		String string;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());
		for(int i=0; i<n; i++){
			string = reader.readLine();
			stack = new Stack<>();
			arr = string.toCharArray();
			for( j=0; j<arr.length; j++){
				if(arr[j]=='(' || arr[j]=='{' || arr[j]=='[')
					stack.push(arr[j]);
				else if(arr[j]==')'){
					if(!stack.empty() && stack.peek()=='(')
						stack.pop();
					else if(stack.empty()){
						System.out.println("NO");
						break;
					}
				}
				else if(arr[j]=='}'){
					if(!stack.empty() && stack.peek()=='{')
						stack.pop();
					else if(stack.empty()){
						System.out.println("NO");
						break;
					}
				}
				else if(arr[j]==']'){
					if(!stack.empty() && stack.peek()=='[')
						stack.pop();
					else if(stack.empty()){
						System.out.println("NO");
						break;
					}
				}
			}
			if(stack.empty() && j==arr.length)
				System.out.println("YES");
			if(!stack.empty())
				System.out.println("NO");
			
		}
	}

}
