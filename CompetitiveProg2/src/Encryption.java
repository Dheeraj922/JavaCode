import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Encryption {
	public static void main(String args[]) throws NumberFormatException, IOException{
		int n,k,diff=0;
		String input;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(reader.readLine());
		input=reader.readLine();
		char[] output = input.toCharArray();
		k=Integer.parseInt(reader.readLine());
		for(int i=0;i<input.length();i++){
			if((input.charAt(i)>=65 && input.charAt(i)<91)){
				output[i]=(char) (output[i]+k);
				if(output[i]>90){
					diff=output[i]-90;
					while(diff>26){
						output[i]=(char) (64+diff);
						diff=output[i]-90;
					}
					output[i]=(char) (64+diff);
				}
			}
			else if((input.charAt(i)>=97 && input.charAt(i)<=122)){
				output[i]=(char) (output[i]+k);
				if(output[i]>122){
					diff=output[i]-122;
					while(diff>26){
						output[i]=(char) (96+diff);
						diff=output[i]-122;
					}
					output[i]=(char) (96+diff);
				}
			}
				
			}
		System.out.println(output);
		}
}
