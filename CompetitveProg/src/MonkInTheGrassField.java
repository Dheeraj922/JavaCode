import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Vector;


public class MonkInTheGrassField {
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int t,n = 0,k;
		int index1=0,index2=0,row=0,column = 0;
		long sum = 0,sum1=0,sum2=0,total;
		int mat[][] = null;
		Vector<Long> v=new Vector<>();
		Vector<Long> v1=new Vector<>();
		t=Integer.parseInt(reader.readLine());
		while(t>0){
			String []input=reader.readLine().split(" ");
			n=Integer.parseInt(input[0]);
			k=Integer.parseInt(input[1]);
			mat=new int[n][n];
			total=0;
			
			for(int i=0;i<n;i++){
				String []line=reader.readLine().split(" ");
				for(int j=0;j<n;j++)
					mat[i][j]=Integer.parseInt(line[j]);
			}
			for(int i=1;i<=k;i++){
				
				for(int j=0;j<n;j++){
					for(int l=0;l<n;l++)
						sum+=mat[j][l];
					v.add(j, sum);
					v1.add(j,sum);
					sum=0;
				}
				Collections.sort(v);
				sum1=v.get(0);
				index1=v1.indexOf(v.get(0));
				sum=0;
				v.clear();
				v1.clear();
				for(int j=0;j<n;j++){
					for(int l=0;l<n;l++)
						sum+=mat[l][j];
					v.add(j, sum);
					v1.add(j,sum);
					sum=0;
				}
				Collections.sort(v);
				sum2=v.get(0);
				index2=v1.indexOf(v.get(0));
				sum=0;
				v.clear();
				v1.clear();
				if(sum1<sum2){
					total+=sum1;
					for(int j=0;i<n;i++)
						mat[index1][j]+=1;
					row=1;
					column=0;
				}
				else if(sum2<sum1){
					total+=sum2;
					for(int j=0;j<n;j++)
						mat[j][index2]+=1;
					row=0;
					column=1;
				}
				else if(sum1==sum2){
					total+=sum1;
					if(column==1){
						for(int j=0;j<n;j++)
							mat[index1][j]+=1;
					}
					else if(row==1){
						for(int j=0;j<n;j++)
							mat[j][index2]+=1;
					}
					
				}
			}
			System.out.println(total);
			
			t--;
		}
	
		}
		
	}

