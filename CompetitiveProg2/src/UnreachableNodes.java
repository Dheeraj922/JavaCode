import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;


public class UnreachableNodes {
	
	public static void main(String args[]) throws IOException{
		
		int n,m,x;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String in[] = reader.readLine().split(" ");
		n = Integer.parseInt(in[0]);
		m = Integer.parseInt(in[1]);
		GraphDemo graph = new GraphDemo(n);
		for(int i=1;i<=m;i++){
			in = reader.readLine().split(" ");
			graph.addEdge(Integer.parseInt(in[0]), Integer.parseInt(in[1]));
		}
		x = Integer.parseInt(reader.readLine());
		boolean visited[] = new boolean[n+1];
		for(int i=1; i<=n;i++)
			visited[i] = false;
		graph.dfs(x,visited);
		int count=0;
		for(int i=1; i<=n; i++){
			if(!visited[i])
				count++;
		}
		System.out.println(count);
	}

}

class GraphDemo {
	int V;
	public LinkedList<Integer> list[];
	public GraphDemo(int V){
		this.V = V;
		list = new LinkedList[V+1];
		for(int i=1;i<=V; i++)
			list[i] = new LinkedList<>();
	}
	
	//method to add edges in the graph
	public void addEdge(int u, int v){
		list[u].add(v);
		list[v].add(u);
	}
	
	//main dfs function to calcualte no unreachable nodes
	
	public void dfs(int x, boolean[] visited) {
		visited[x] = true;
		Iterator<Integer> i = list[x].listIterator();
		while(i.hasNext()){
			int n = i.next();
			if(!visited[n]){
				dfs(n,visited);
			}
		}
		
	}

}

