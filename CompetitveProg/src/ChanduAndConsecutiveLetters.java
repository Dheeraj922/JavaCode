import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ChanduAndConsecutiveLetters {
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int t,i;
		String str,output;
		t=Integer.parseInt(reader.readLine());
		while(t>0){
			str=reader.readLine();
			output="";
			output+=str.charAt(0);
			for(i=1;i<str.length();i++){
				if(str.charAt(i)==str.charAt(i-1)){
					continue;
				}
				else
					output+=str.charAt(i);
			}
			System.out.println(output);
			t--;
		}
	}

}
