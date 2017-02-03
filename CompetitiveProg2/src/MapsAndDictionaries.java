import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class MapsAndDictionaries {
	public static void main(String args[]) throws NumberFormatException, IOException{
		HashMap<String,Long> map = new HashMap<>();
		int n;
		String in[];
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(reader.readLine());
		for(int i=1; i<=n; i++){
			in = reader.readLine().split(" ");
			map.put(in[0], Long.parseLong(in[1]));
		}
		String query;
		Long result;
		while((query=reader.readLine()) != null){
			result = map.get(query);
			if(result == null)
				System.out.println("Not found");
			else
				System.out.println(query+"="+result);
		}
	}

}
