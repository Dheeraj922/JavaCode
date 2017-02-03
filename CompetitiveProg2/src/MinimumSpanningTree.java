import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class MinimumSpanningTree {
	
	static long sum = 0;
	public static void main(String args[]) throws IOException
	{
		int n,m;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String in[] = reader.readLine().split(" ");
		n = Integer.parseInt(in[0]);
		m = Integer.parseInt(in[1]);
		GraphGeneral graph = new GraphGeneral(n);
		for(int i=1; i<=m; i++){
			in = reader.readLine().split(" ");
			graph.addEdge(Integer.parseInt(in[0]), Integer.parseInt(in[1]), Integer.parseInt(in[2]));
		}
		int parent [] = new int[n];
		int key[] = new int[n];
		for(int i=1;i<=n;i++){
			key[i] = Integer.MAX_VALUE;
			
		}
		boolean visited[] = new boolean[n];
		Arrays.fill(visited, false);
		mstPrim(key,parent,visited,n,graph);
		
	}

	private static void mstPrim(int[] key, int[] parent, boolean[] visited,int n, GraphGeneral graph) {
		key[1] = 0;
		parent[1] = -1;
		for(int count=1; count<n ;count++){
			
			int u = minKey(key,visited);
			visited[u] = true;
			sum += key[u];
			
			//Iterator<Integer> iterator = graph.list[u].listIterator();
			HashMap<Integer,Integer> map = graph.list.get(u);
			Iterator it = map.entrySet().iterator();
			while(it.hasNext()){
				Map.Entry pair = (Entry) it.next(); 
				int v = (int) pair.getKey();
				int w = (int) pair.getValue();
				if(visited[v]==false && w < key[v]){
					parent[v] = u;
					key[v] = w;
				}
			}
			/*while(iterator.hasNext()){
				int v = iterator.next();
				if(visited[v]==false && graph.list[u].get(v) < key[v]){
					parent[v] = u;
					key[v] = graph.list[u].get(v);
				}*/
		}
		System.out.println(sum);
		
	}

	private static int minKey(int[] key, boolean[] visited) {
		int min = Integer.MAX_VALUE,index=-1;
		for(int i=1;i<=key.length;i++){
			if(visited[i]==false && key[i]<min){
				min = key[i];
				index=i;
			}
		}
		return index;
	}

}
