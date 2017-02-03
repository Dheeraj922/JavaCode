
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BfsExample {
	public static int nodes;
	private static Map<Integer,List<Integer>> adjList;
	
	public static int edges;
	public static Boolean visited[] ;
	@SuppressWarnings("unchecked")
	public BfsExample(int nodes){
		this.nodes=nodes;
		adjList=new HashMap<Integer,List<Integer>>();
		visited=new Boolean[nodes+1];
		for(int i=1;i<=nodes;i++)
			adjList.put(i, new LinkedList<Integer>());	
	}
	
	
	public  void dfs(int s){
		visited[s]=true;
		for(int i=0;i<adjList.get(s).size();++i){
			if (visited[adjList.get(s).get(i)]==false) {
				dfs((adjList.get(s)).get(i));
			}
		}
	}
	public  void initialise(){
		for (int i = 0; i <=nodes; ++i) {
			visited[i]=false;
			}
	}
	public  void addEdge(int source,int destination){
		if (source>adjList.size() || destination>adjList.size()) {
			
			System.out.println("the vertex entered is not present");
		}
		try
		{
	    List<Integer> slist=adjList.get(source);
	    slist.add(destination);
	    List<Integer> dlist=adjList.get(destination);
	    dlist.add(source);
		}catch(NullPointerException e){
			System.out.println("Exception caught:"+e);
		}
	}
	public static void main(String args[]) throws IOException{
		int x,y,connectedComponents=0;
		Scanner reader=new Scanner(System.in);
		nodes=(int)reader.nextInt();
		edges=(int)reader.nextInt();
		BfsExample ex=new BfsExample(nodes);
		
		for(int i=0;i<edges;i++){
			x=(int)reader.nextInt();
			y=(int)reader.nextInt();
			ex.addEdge(x,y);
			}
		ex.initialise();
		for (int i = 1; i <=nodes; i++) {
			if(visited[i]==false){
				ex.dfs(i);
				connectedComponents++;
				}
			}
		
		System.out.println("No of connected components="+connectedComponents);
		reader.close();
		
	}

}
