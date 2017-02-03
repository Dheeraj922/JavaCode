import java.util.Scanner;


public class PalindrominStrings {
	public static void main(String args[]){
		int t;
		boolean result;
		Scanner s=new Scanner(System.in);
		t=s.nextInt();
		String s1,s2;
		while(t>0){
			/*s1=new String();
			s2=new String();*/
			s1=s.next();
			s2=s.next();
			result=calculateResult(s1,s2);
			if(result==true)
				System.out.println("YES");
			else{
				result=calculateResult(s2,s1);
				if(result==true)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
			t--;
			
		}
		
		s.close();
	}

	private static boolean calculateResult(String s1, String s2) {
		int l,mid,end,beg=0;
		StringBuilder output=new StringBuilder(s1);
		output.append(s2);
		l=output.length();
		char[] string=output.toString().toCharArray();
		end=l-1;
		mid=(beg+end)/2;
		while(beg<end){
			if(string[beg]!=string[end])
				return false;
			beg++;
			end--;
		}
		if(beg>=end)
			return true;
		return false;
	}

}
