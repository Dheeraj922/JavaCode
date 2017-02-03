import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class SortSubstring {
	public static void main(String args[]) throws IOException{
		
		int t,n,m;
		String input;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(reader.readLine());
		for(int i = 1; i <= t; i++){
			String in[] = reader.readLine().split(" ");
			input = in[0];
			n = Integer.parseInt(in[1]);
			m = Integer.parseInt(in[2]);
			char arr[] = input.substring(n,m+1).toCharArray();
			ArrayList<Character> list = new ArrayList<>();
			for(int j=0; j<arr.length; j++){
				list.add(new Character(arr[j]));
			}
			Collections.sort(list, Collections.reverseOrder());
			//System.out.println(list);
			arr = input.toCharArray();
			for(int j=n,k=0; j<=m; j++,k++){
				arr[j] = list.get(k);
			}
			System.out.println(new String(arr));
		}
		
	}

}
