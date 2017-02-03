import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

class Graph{
	private int vertices;
	private LinkedList<Integer> adj[];
	//constructor
	public Graph(int v){
		this.vertices=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++)
			adj[i]=new LinkedList();
	}
	//method to add edge in the graph
	void addEdge(int to,int from){
		adj[to].add(from);
	}
	//recursive function to print DFS from the starting point 
	void DFSUtil(int v,boolean visited[]){
		//mark the current node as visited and print it
		visited[v]=true;
		System.out.print(v+" ");
		int n;
		//recur for all the vertices adjacent to this vertex
		Iterator<Integer> i=adj[v].iterator();
		while(i.hasNext()){
			n=i.next();
			if(!visited[n])
				DFSUtil(n,visited);
		}
	}
	// method to return the reverse of the graph
	Graph getTranspose(){
		Graph g=new Graph(vertices);
		for(int v=0;v<vertices;v++){
			//recur for all the vertices adjacent to this vertex
			Iterator<Integer> i=adj[v].iterator();
			while(i.hasNext()){
				g.adj[i.next()].add(v);
			}
		}
		return g;
	}
	
	void fillOrder(int v,boolean visited[],Stack stack){
		//mark the current node as visited and print it
		visited[v]=true;
		//recur for all the adjacent verices to the current vertex
		Iterator<Integer> i=adj[v].iterator();
		while (i.hasNext()){
			int n=i.next();
			if (!visited[n]) {
				fillOrder(n, visited, stack);
			}
		}
		//all vertices reachable from v are processed by now
		//push v to stack
		stack.push(new Integer(v));
	}
	//main function to find and print all strongly connected components
	void printSCC(){
		Stack stack=new Stack();
		//mark all the vertices as not visited (for the first dfs)
		boolean visited[]=new boolean[vertices];
		for(int i=0;i<vertices;i++)
			visited[i]=false;
		
		//fill vertices in stack according to their finish times
		for(int i=0;i<vertices;i++)
			if(visited[i]==false)
				fillOrder(i,visited,stack);
		
		//create a reversed graph
		Graph gr=getTranspose();
		//mark all the vertices as not visited(for second dfs)
		for(int i=0;i<vertices;i++)
			visited[i]=false;
		
		//Now process all vertices in order defined by the Stack
		while(stack.empty()==false){
			//pop a vertex from the Stack
			int v=(int) stack.pop();
			
			//print strongly connnected component of the popped vertex
			if(visited[v]==false){
				gr.DFSUtil(v, visited);
				System.out.println();
			}
		}
	}
	
}
public class SCC {
	public static void main(String args[]){
		//creating a graph
		Graph g=new Graph(5);
		g.addEdge(1,0);
		g.addEdge(0,2);
		g.addEdge(2,1);
		g.addEdge(0,3);
		g.addEdge(3,4);
		
		System.out.println("Following are the Strongly Connected Components in given graph");
		g.printSCC();
	}

}
