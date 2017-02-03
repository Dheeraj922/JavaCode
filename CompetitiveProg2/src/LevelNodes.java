import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class GraphSample{
	int V;
	LinkedList<Integer> list[];
	public GraphSample(int V){
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
	
	//method to calculate the no of nodes at a specific level in the graph
	@SuppressWarnings("unchecked")
	public void calculateNodes(int n, int level, int src){
		LinkedList<Integer> q = new LinkedList<>();
		LinkedList<Integer> auxillary = new LinkedList<>();
		boolean flag = true;
		int l=0;
		q.add(src);
		auxillary.add(src);

		if(level==1){
			System.out.println(q.size());
			return;
		}
		while(!q.isEmpty()){
			int cur = q.peek();
			if(auxillary.contains(cur) && flag){
				flag=false;
				auxillary.poll();
				l++;
			}
			if(l==level){
				System.out.println(q.size());
				break;
			}
			if(auxillary.size()==0){
				flag=true;
			}
			cur = q.poll();
			auxillary.poll();
			Iterator<Integer> iterator = list[cur].listIterator();
			while(iterator.hasNext()){
				int child = iterator.next();
				q.add(child);
					
			}
			if(auxillary.size()==0){
				auxillary = (LinkedList<Integer>) q.clone();
				flag=true;
				
			}
				
		}
		
	}
}
public class LevelNodes {
	
	public static void main(String arsgs[]) throws NumberFormatException, IOException{
		int nodes,level;
		String in[];
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		nodes = Integer.parseInt(reader.readLine());
		GraphSample g = new GraphSample(nodes);
		for(int i=1; i<=nodes-1; i++){
			in = reader.readLine().split(" ");
			g.addEdge(Integer.parseInt(in[0]), Integer.parseInt(in[1]));
			
		}
		level = Integer.parseInt(reader.readLine());
		g.calculateNodes(nodes, level ,1);
	}

}
