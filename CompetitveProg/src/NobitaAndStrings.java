
import java.util.Scanner;

public class NobitaAndStrings {
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		int t;
		t=s.nextInt();
		String input;
		StringBuilder output;
		
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		//test=Integer.parseInt(reader.readLine());
		for(int j=0;j<t;j++)
		{
			//input=new String();
			input=s.nextLine();
			output=new StringBuilder(input);
			output.reverse();
			String []out=input.split(" ");
			for(int i=0;i<out.length;i++){
				output=new StringBuilder(out[i]);
				System.out.print(output.reverse()+" ");
			}
		}
		s.close();
	}

}
