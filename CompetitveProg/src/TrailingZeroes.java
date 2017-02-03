import java.math.BigInteger;
import java.util.Scanner;


public class TrailingZeroes {
	public static void main(String args[])
	{
		int n;
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		BigInteger result=BigInteger.ONE;
		for(int i=1;i<=n;i++)
			result=result.multiply(BigInteger.valueOf(i));
		System.out.println(result);
		long count=0;
		String temp=result.toString();
		char[] res=temp.toCharArray();
		for(long i=res.length-1;;i--){
			if(res[(int)i]=='0')
				count++;
			else
				break;
			}
		System.out.println(count);
		in.close();
	}

}
