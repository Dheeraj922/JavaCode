import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class MonksBirthdayParty {
	private static boolean[] visited;
	private static LinkedList<Integer> nodes[];
	private static int count=0;
	private static int ans=99999;
	
	public static void main(String args[]) throws IOException{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int n,d,u,v;
		String in[]=reader.readLine().split(" ");
		n=Integer.parseInt(in[0]);
		d=Integer.parseInt(in[1]);
		nodes=new LinkedList[n];
		for(int i=0;i<n;i++)
			nodes[i]=new LinkedList();
		visited=new boolean[1001];
		for(int i=0;i<d;i++){
			in=reader.readLine().split(" ");
			u=Integer.parseInt(in[0]);
			v=Integer.parseInt(in[1]);
			nodes[u-1].add(v-1);
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<1001;j++)
				visited[j]=false;
			count=1;
			dfs(i);
			ans=min(ans,count);
			
		}
		System.out.println(ans);
		
	}

	private static int min(int ans, int count) {
		
		return (ans<=count?ans:count);
	}

	private static void dfs(int s) {
		visited[s]=true;
		for(int i=0;i<nodes[s].size();i++){
			if(visited[nodes[s].get(i)]==false){
				count++;
				dfs(nodes[s].get(i));
			}
		}
		
		
	}

}
