import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TheStrongestString {
	public static void main(String args[]){
		int l;
		Scanner s=new Scanner(System.in);
		l=s.nextInt();
		String input=new String();
		input=s.next();
		ArrayList<String> sub=new ArrayList<>();
		for(int i=0;i<l;i++){
			for (int j = i+1; j <= l; j++) {
				sub.add(input.substring(i, j));
				
			}
		}
		//Arrays.sort(sub);
		Collections.sort(sub);
		//Collections.sort(sub, String.CASE_INSENSITIVE_ORDER);
		String res=checkUnique(sub.get((sub.size())-1));
		//System.out.println(sub.get((sub.size())-1));
		//for checking out if it finds all the substrings or not 
	/*	for(int i=0;i<sub.size();i++)
			System.out.println(sub.get(i));*/
		System.out.println(res);
		s.close();
	}

	private static String checkUnique(String string) {
		// TODO Auto-generated method stub
		String res="";
		for(int i=0;i<string.length();i++){
			int count=1;
			for(int j=i+1;j<string.length();j++){
				if(string.charAt(i)==string.charAt(j))
					count++;
			}
			if(count==1)
				res+=string.charAt(i);
			}
		return res;
		}
	}

