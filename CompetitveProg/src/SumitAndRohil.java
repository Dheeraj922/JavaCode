import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SumitAndRohil {
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		//@SuppressWarnings("unchecked")
		//ArrayList<String> groups[]=(ArrayList<String>[])new ArrayList[100];
		int n,count=0;
		n=s.nextInt();
		String []names = new String[n];
		for(int i=0;i<n;i++)
			names[i]=s.next();
	/*	for(int i=0;i<names.length-1;i++){
			//groups[i].add(names[i]);
			if(names[i]!=null){
			for(int j=i+1;j<names.length;j++){
				if(names[i].charAt(0)==names[j].charAt(0) && names[i].charAt(names[i].length()-1)==names[j].charAt(names[j].length()-1)){
					if(isAnagram(names[i],names[j])){
							//groups[i].add(names[j]);
							names[j]=null;
					}
				}
			}
			}

		}*/
	/*	for(int i=0;i<n;i++){
			if(names[i]==null)
				continue;
			else
				count++;
		}*/
		boolean res=isAnagram("vinay","naviy");
		System.out.println(res);
		//System.out.println(count);
			
		s.close();
	}

	private static boolean isAnagram(String string1, String string2) {
		// TODO Auto-generated method stub
		char []s1=string1.toCharArray();
		Arrays.sort(s1);
		string1=new String(s1);
		s1=string2.toCharArray();
		Arrays.sort(s1);
		string2=new String(s1);
		if(string1.equals(string2))
			return true;
		else
			return false;
	}

}
