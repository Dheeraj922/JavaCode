import java.io.*;


public class MonkAndPalindrome {
	public static void main(String args[]) throws IOException{
		int t;
		String input;
		StringBuffer temp;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(reader.readLine());
		for(int i = 1; i <= t; i++){
			input = reader.readLine();
			temp = new StringBuffer(input);
			String res = new String(temp.reverse());
			if(input.equals(res)){
				if(input.length()%2==1){
					System.out.println("YES ODD");
				}
				else
					System.out.println("YES EVEN");
			}
			else
				System.out.println("NO");
			
		}
	}

}
