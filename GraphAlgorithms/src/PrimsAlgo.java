
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class PrimsAlgo {
	
	public static void main(String args[]){
		int v,e,src,dest, weight;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		v = scanner.nextInt();
		e = scanner.nextInt();
		GraphDemo graph = new GraphDemo(v);
		for(int i=1; i<=e; i++){
			src = scanner.nextInt();
			dest = scanner.nextInt();
			weight = scanner.nextInt();
			graph.addEdge(src, dest, weight);
		}
		boolean visited[] = new boolean[v+1];
		int key[] = new int[v+1];
		for(int i = 1; i<=v; i++){
			key[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
		graph.prim(key , visited);
		
	}
	

}
class GraphDemo {
	int V;
	//we are using priority queue to make the process of retrieving minimum element from the list easier
	public LinkedList<AdjList> list[];
	@SuppressWarnings("unchecked")
	public GraphDemo(int V){
		this.V = V;
		list = new LinkedList[V+1];
		for(int i=1;i<=V; i++)
			list[i] = new LinkedList<>();
	}
	
	//method to add edges in the graph,can both be directed or undirected
	public void addEdge(int u, int v, int w){
		list[u].add(new AdjList(v,w));
		list[v].add(new AdjList(u,w));
	}
	
	//the actual meat is here!!
	public void prim(int []key, boolean []visited){
		int parent[] = new int[V+1];
		key[1] = 0;
		parent[1] = -1;
		for(int i =0; i<V-1; i++){
			
			int u = min(key, visited);
			visited[u] = true;
			
			Iterator<AdjList> it = list[u].iterator();
			while(it.hasNext()){
				AdjList adj = it.next();
				int n = adj.getDest();
				int w = adj.getWeight();
				if(visited[n]==false && w < key[n]){
					parent[n] = u;
					key[n] = w;
				}
			}
			
		}
		//This variable sum is going to store the sum of all the edges in the minimum spanning tree
		long sum = 0;
		for(int i = 1;i <= V; i++){
			sum = sum+key[i];
		}
		System.out.println(sum);
		
	}

	private int min(int[] key, boolean[] visited) {
		int m= Integer.MAX_VALUE,index=-1;
		for(int i =1; i<=V; i++){
			if(visited[i]==false && key[i] < m){
				m = key[i];
				index = i;
			}
		}
		return index;
	}
}
	

class AdjList{
	int dest;
	int weight;
	//constructor to add destination and weight
	AdjList(int dest, int weight){
		this.dest = dest;
		this.weight = weight;
	}
	public int getDest() {
		return dest;
	}
	
	public int getWeight() {
		return weight;
	}	
	
}

