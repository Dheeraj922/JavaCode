import java.util.Scanner;


public class CaeserCipherAlgo {
	public static void main(String args[])
	{
		String text,result;
		int key;
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the text you want to encrypt");
		text = scan.next();
		System.out.println("Now enter the key please 1-26");
		key = scan.nextInt();
		result = cipherFunction(text, key);
		System.out.println("After encrypting, new encrypted message = "+result);
		result = decipherFunction(result, key);
		System.out.println("After decrypting, the original message =  "+result);
		
		
	}
	public static String cipherFunction(String text , int key)
	{
		char []res = text.toCharArray();
		for(int i=0; i<res.length; i++){
			res[i]= (char) ((res[i]+key)%123);
			if(res[i] < 97){
				res[i] = (char) (res[i]+97);
			}
		}
		return new String(res);
	}
	public static String decipherFunction(String text , int key)
	{
		char []res = text.toCharArray();
		for(int i=0; i<res.length; i++){
			res[i]= (char) ((res[i]-key)%123);
			if(res[i] < 97){
				res[i] = (char) (res[i]+26);
			}
		}
		return new String(res);
		
	}

}
