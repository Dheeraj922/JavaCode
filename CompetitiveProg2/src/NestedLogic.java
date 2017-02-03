import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class NestedLogic {
	public static void main(String args[]) throws IOException
	{
		int da,ma,ya,de,me,ye;
		long fine =0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String in[] = reader.readLine().split(" ");
		da = Integer.parseInt(in[0]);
		ma = Integer.parseInt(in[1]);
		ya = Integer.parseInt(in[2]);
		in = reader.readLine().split(" ");
		de = Integer.parseInt(in[0]);
		me = Integer.parseInt(in[1]);
		ye = Integer.parseInt(in[2]);
		if(da<=de && ma==me && ya==ye)
			fine=0;
		else if(ya>ye)
			fine = 10000;
		else if(ya==ye){
			if(ma==me && da>de)
				fine=15*(da-de);
			else if(ma>me)
				fine=500*(ma-me);		
		}
		System.out.println(fine);
		
	}

}
