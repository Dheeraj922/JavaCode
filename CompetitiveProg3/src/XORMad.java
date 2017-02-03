import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XORMad {
	public static void main(String args[]) throws IOException{
		int t,x;
		long ops;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(reader.readLine());
		for(int c = 1; c <= t; c++)
		{
			x = Integer.parseInt(reader.readLine());
			ops = 0;
			for(int i = 1; i < x; i++){
					if((i^x) == (i+x)){
						ops++;
					}
			}
			System.out.println(ops);
		}
		 
	}

}
