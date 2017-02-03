import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;


public class UniqueStrings {
	public static void main(String args[]){
		int t,l=0;
		Scanner s=new Scanner(System.in);
		t=s.nextInt();
		//char c=s.next().charAt(0);
		String input,output;
		StringBuilder builder;
		while(t>0){
			input=s.next();
			char[] s1=input.toCharArray();
			output=new String();
			builder=new StringBuilder();
			for(int i=0;i<input.length();i++){
				l=calculate(i,s1);
				if(l>1 && (output.indexOf(s1[i])<0)){					
					builder.append(s1[i]);
					output+=Character.toString(s1[i]);
				}
				else if(l==1){
					builder.append(s1[i]);
				}
					
				}
			System.out.println(builder.toString());
			//System.out.println(output);
			t--;
			}
		s.close();
	}

	private static Integer calculate(int index, char[] s1) {
		// TODO Auto-generated method stub
		int l=0;
		for(int i=0;i<s1.length;i++){
			if(s1[index]==s1[i])
				l++;
		}
		return l;
	}

}
