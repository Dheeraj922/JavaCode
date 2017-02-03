
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 */

/**
 * @author DHEERAJ created on 26/03/2016
 *
 */
public class ShortestDistanceDijsktra {
	int no_of_nodes;
	private int[] distances;
	private Set<Integer> unSettled;
	private Set<Integer> settled;
	private int adjacencyMatrix[][];
	
	public ShortestDistanceDijsktra(int no_of_nodes){
		this.no_of_nodes=no_of_nodes;
		distances=new int[no_of_nodes];
		settled=new HashSet<Integer>();
		unSettled=new HashSet<Integer>();
		adjacencyMatrix=new int[no_of_nodes][no_of_nodes];
	}
	public void shortestDistance(int adjacency_matrix[][],int source){
		int evaluationNode;
		for(int i=0;i<no_of_nodes;i++)
			for(int j=0;j<no_of_nodes;j++)
				adjacencyMatrix[i][j]=adjacency_matrix[i][j];
		for(int i=0;i<no_of_nodes;i++){
			distances[i]=Integer.MAX_VALUE;
		}
		unSettled.add(source);
		distances[source]=0;
		while(!unSettled.isEmpty()){
			evaluationNode=getNodeWithMinimumDistanceFromUnsettled();
			unSettled.remove(evaluationNode);
			settled.add(evaluationNode);
			evaluateNeighbours(evaluationNode);
		}
	}
	private int getNodeWithMinimumDistanceFromUnsettled(){
		int min;
		int node=0;
		Iterator<Integer> iterator=unSettled.iterator();
		node=iterator.next();
		min=distances[node];
		for (int i = 0; i < distances.length; i++) {
			if(unSettled.contains(i)){
				if(distances[i]<=min){
					min=distances[i];
					node=i;
					}
				}
		}
		return node;
	}
	private void evaluateNeighbours(int evaluationNode){
		int edgeDistance=-1;
		int newDistance=-1;
		for(int destinationNode=0;destinationNode<no_of_nodes;destinationNode++){
			if(!settled.contains(destinationNode)){
				if (adjacencyMatrix[evaluationNode][destinationNode]!=Integer.MAX_VALUE) {
					edgeDistance=adjacencyMatrix[evaluationNode][destinationNode];
					newDistance=distances[evaluationNode]+edgeDistance;
					if(newDistance<distances[destinationNode]){
						distances[destinationNode]=newDistance;
					}
					unSettled.add(destinationNode);
					
				}
			}
		}
	}
	public static void main(String[] args)
	{
		int adjacency_matrix[][];
		int no_of_vertices;
		int source=0;
		Scanner scanner=new Scanner(System.in);
		try{
			System.out.println("enter no of vertices");
			no_of_vertices=scanner.nextInt();
			adjacency_matrix=new int[no_of_vertices][no_of_vertices];
			System.out.println("Enter the weighted Matrix for the graph");
			for(int i=0;i<no_of_vertices;i++){
				for(int j=0;j<no_of_vertices;j++){
					adjacency_matrix[i][j]=scanner.nextInt();
					if(i==j){
						adjacency_matrix[i][j]=0;
						continue;
					}
					if(adjacency_matrix[i][j]==0){
						adjacency_matrix[i][j]=Integer.MAX_VALUE;
					}
				}
			}
			System.out.println("Enter the source");
			source=scanner.nextInt();
			ShortestDistanceDijsktra sp=new ShortestDistanceDijsktra(no_of_vertices);
			sp.shortestDistance(adjacency_matrix, source);
			System.out.println("The shortest path from "+source+" to all other vertices are: ");
			for(int i=0;i<sp.distances.length;i++)
			{
				System.out.println(source+" to "+i+" is "+sp.distances[i]);
			}
			
		}catch(InputMismatchException e){
			System.out.println("Wrong format");
		}
		scanner.close();
		
	}
}
