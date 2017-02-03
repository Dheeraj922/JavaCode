import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SumitAndRohil2 {
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		ArrayList<String> names=new ArrayList<>();
		int n;
		n=s.nextInt();
		for(int i=0;i<n;i++)
			names.add(s.next());
		for(int i=0;i<names.size()-1;i++){
			for(int j=i+1;j<names.size();j++){
				if((names.get(i).charAt(0)==names.get(j).charAt(0)) && (names.get(i).charAt((names.get(i).length())-1)==names.get(j).charAt((names.get(j).length())-1))){
					if(isAnagram(names.get(i),names.get(j))){
						names.remove(j);
					}
				}
			}
		}

		System.out.println(names.size());
		s.close();
	}
	private static boolean isAnagram(String string1, String string2) {
		// TODO Auto-generated method stub
		char []s1=string1.toCharArray();
		int i;
		Arrays.sort(s1);
		string1=new String(s1);
		s1=string2.toCharArray();
		Arrays.sort(s1);
		string2=new String(s1);
		if(string1.equals(string2))
			return true;
		
		for( i=0; i<string1.length() && i<string2.length(); i++){
			if(string1.charAt(i)!=string2.charAt(i))
				return false;
		}
		if(i==string1.length() || i==string2.length())
			return true;
		return false;
	}

}
