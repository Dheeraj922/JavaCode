import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;


public class ShortestReach {
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		int q,n,src;
		long m;
		String in[];
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Graph g;
		q = Integer.parseInt(reader.readLine());
		for(int i=1;i<=q;i++){
			in = reader.readLine().split(" ");
			n = Integer.parseInt(in[0]);
			m = Long.parseLong(in[1]);
			g = new Graph(n);
			for(int j=1;j<=m;j++){
				in = reader.readLine().split(" ");
				g.addEdge(Integer.parseInt(in[0]), Integer.parseInt(in[1]));
			}
			in = reader.readLine().split(" ");
			src = Integer.parseInt(in[0]);
			//g.dijkstra(src);
			//g.print(src);
			//System.out.println();
			g.bfs(src);
		}
		
	}

}

class Graph
{
	LinkedList<Integer>[] list;
	int v;
	int dist[];
	//constructor
	Graph(int v){
		this.v=v;
		list = new LinkedList[v+1];
		for(int i=1;i<=v;i++)
			list[i] = new LinkedList<>();
	}
	//adding edges
	
	public void print(int src) {
		printDistances(dist, v, src);
		
	}

	void addEdge(int u, int v){
		list[u].add(v);
		list[v].add(u);
	}
	
	//our main procedure to calculate the shortest distance
	void dijkstra(int src){
		dist = new int[v+1];
		Boolean sptSet[] = new Boolean[v+1];
		for(int i=1; i<=v; i++){
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		dist[src] = 0;
		for(int count =1; count<=v-1; count++){
			int u = minDistance(dist , sptSet);
			sptSet[u] = true;
			//updating distance values of the adjacent vertices of the picked vertice
			Iterator<Integer> iterator = list[u].listIterator();
			while(iterator.hasNext()){
				int n = iterator.next();
				if(!sptSet[n] && dist[u]!= Integer.MAX_VALUE && dist[u]+ 6< dist[n])
					dist[n]=dist[u]+6;
				
			}
			
			/*for(int i=1;i<=v;i++){
				
				if(!sptSet[i] && dist[u]!=Integer.MAX_VALUE && dist[u]+6<dist[i])
					dist[i]=dist[u]+6;
				
			}*/
		}
		
	}

	private int minDistance(int[] dist, Boolean[] sptSet) {
		int min = Integer.MAX_VALUE, index = -1;
		for(int i=1;i<=v;i++){
			if(sptSet[i] == false && dist[i]<=min){
				min=dist[i];
				index=i;
			}
		}
		return index;
	}
	
	public void printDistances(int dist[],int n,int src){
		for(int i=1;i<=n;i++){
			if(i==src)
				continue;
			else if(dist[i]==Integer.MAX_VALUE)
				System.out.print(-1 +" ");
			else
				System.out.print(dist[i]+" ");
			
		}
	}
	
	public void bfs(int src){
		Boolean visited[] = new Boolean[v+1];
		for(int i=1;i<=v;i++)
			visited[i] = false;
		int pre[] = new int[v+1];
		for(int i=1;i<=v;i++)
			pre[i] = -1;
		LinkedList<Integer> q = new LinkedList<>();
		visited[src] = true;
		pre[src] = -1;
		q.add(src);
		while(q.size() != 0){
			int source = q.poll();
			Iterator<Integer> i = list[source].listIterator();
			while(i.hasNext()){
				int n = i.next();
				if(!visited[n]){
					visited[n]=true;
					pre[n]=source;
					q.add(n);
				}
			}
		}
		printResult(pre,src);
		System.out.println();
	}

	private void printResult(int[] pre, int src) {
		for(int i=1;i<=v;i++){
			if(i==src)
				continue;
			else if(pre[i]== -1)
				System.out.print(-1+" ");
			else{
				int j=i,n,k=0;
				while(j!=src){
					n = pre[j];
					j = n;
					k++;
				}
				System.out.print(k*6+" ");
			}
				
		}
		
	}
}
