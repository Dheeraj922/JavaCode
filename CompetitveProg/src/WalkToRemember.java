import java.util.Scanner;


public class WalkToRemember {
	private static long nodes;
	private static long edges;
	private static long[][] matrix;
	public WalkToRemember(long nodes){
		this.nodes=nodes;
		matrix=new long[(int) (nodes+1)][(int) (nodes+1)];
	}
	public  void makeEdge(long a,long b){
		matrix[(int) a][(int) b]=1;
	}
	public static void main(String args[]){
		long a,b;
		
		Scanner scanner=new Scanner(System.in);
		nodes=scanner.nextLong();
		WalkToRemember wtr=new WalkToRemember(nodes);
		boolean visited[]=new boolean[(int) (nodes+1)];
		for(int i=1;i<=nodes;i++)
			visited[i]=false;
		edges=scanner.nextLong();
		for(int i=1;i<=nodes;i++){
			for(int j=1;j<=nodes;j++)
				matrix[i][j]=0;
		}
		for(int i=1;i<=edges;i++){
			a=scanner.nextLong();
			b=scanner.nextLong();
			wtr.makeEdge(a,b);
			}
		int i,j,k = 0,l;
		for ( i = 1; i <=nodes; i++) {
			if(visited[i]==true)
				continue;

			for(j=1;j<=nodes;j++){
				if(visited[j]==true)
					continue;
				if(matrix[i][j]==1){
					if(matrix[j][i]==1){
						System.out.print(1+" ");
						break;
					}
					else
						continue;
				}
				else if(matrix[j][i]==1){
					
					if(!visited[i]){
					for( k=i;k<=j;k++){
						
						System.out.print(1+" ");
						visited[k]=true;
				
					}
					}
					else if (visited[i]){
						for( l=k;l<=j;l++){
							System.out.print(1+" ");
							visited[l]=true;
						}
						k=l;
					}
				}
				else
					continue;
			}
//			if(matrix[j-1][i]==1){
//				for(int k=i;k<=j;k++){
//					System.out.print(1+" ");
//					visited[k]=true;
//				}
//			}
			 if(!visited[i])
				System.out.print(0+" ");
			
		}
		scanner.close();
	}

}
