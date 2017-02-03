import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class GraphGeneral {
	int V;
	public Map<Integer,HashMap<Integer,Integer>> list;
	public GraphGeneral(int V){
		this.V = V;
		list = new HashMap<>();
	}
	
	//method to add edges in the graph
	public void addEdge(int u, int v,int w){
		if(list.get(u)==null){
			HashMap<Integer,Integer> map = new HashMap<>();
			map.put(v, w);
			list.put(u, map);
		}
		else{
			HashMap<Integer,Integer> map = list.get(u);
			map.put(v, w);
			list.put(u, map);
		}
		
		if(list.get(v)==null){
			HashMap<Integer,Integer> map = new HashMap<>();
			map.put(u, w);
			list.put(v, map);
		}
		else{
			HashMap<Integer,Integer> map = list.get(v);
			map.put(u, w);
			list.put(v, map);
		}
	}
	

}
