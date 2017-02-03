import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class ConsecutiveOnes {
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		long n;
		long count=1,max=0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Long.parseLong(reader.readLine());
		String binary = Long.toBinaryString(n);
		String []groupings = binary.split("0");
		Arrays.sort(groupings);
		System.out.println(groupings[groupings.length-1].length());
		//System.out.println(max);
	}

}
