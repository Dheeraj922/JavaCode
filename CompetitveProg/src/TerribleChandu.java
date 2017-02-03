import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TerribleChandu {
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int t;
		String input;
		StringBuilder output;
		t=Integer.parseInt(reader.readLine());
		while(t>0){
			input=reader.readLine();
			output=new StringBuilder(input);
			System.out.println(output.reverse());
			t--;
			
		}
	}

}
