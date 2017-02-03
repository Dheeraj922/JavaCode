import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MarutAndStrings {
	public static void main(String atgs[]) throws IOException{
		int t, ucount=0, lcount=0;
		String input;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String in = reader.readLine();
		char c = in.charAt(0);
		t = Integer.parseInt(reader.readLine());
		
		if(t >=1 && t <= 10){
			for(int i = 1; i <= t; i++){
				ucount = 0; lcount = 0;
				input = reader.readLine();
				for(int j = 0; j < input.length(); j++){
					if(input.charAt(j)>=65 && input.charAt(j)<91)
						ucount++;
					else if(input.charAt(j)>=97 && input.charAt(j)<=122)
						lcount++;
				}
				if(ucount==0 && lcount==0){
					System.out.println("Invalid Input");
					continue;
				}
				if(ucount > lcount){
					System.out.println(lcount);
				}
				else
					System.out.println(ucount);
			}
		}
	}

}
