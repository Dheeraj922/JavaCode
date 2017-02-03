import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;



public class MonkAndLandOfPokemons {
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int t,n,a,b,count;
		String in[];
		boolean flag;
		HashMap<Integer, Integer> hm=new HashMap<>();
		t=Integer.parseInt(reader.readLine());
		while(t>0){
			count=0;
			n=Integer.parseInt(reader.readLine());
			for(int i=0;i<n;i++){
				flag=false;
				in=reader.readLine().split(" ");
				a=Integer.parseInt(in[0]);
				b=Integer.parseInt(in[1]);
				if(a==b)
					continue;
				//v.add(a,a);
				hm.put(a, a);
				/*if(v.contains(b)){
					v.remove(b);
					continue;
				}*/
				for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
				    //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
					if(entry.getKey()==b){
						hm.remove(entry.getKey());
						flag=true;
						break;
					}
				}
				if(flag)
					continue;
				else
					count++;
			}
			System.out.println(count);
			hm.clear();
			t--;
		}
	}
}
