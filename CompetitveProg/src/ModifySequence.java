import java.util.Scanner;


public class ModifySequence {
	public static void main(String args[]){
		int n;
		boolean flag=true;
		long input[];
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		input=new long[n];
		for(int k=0;k<n;k++)
			input[k]=s.nextLong();
		for(int i=0;i<n-1;i++){
			if(input[i]>input[i+1]){
				flag=false;
				break;
			}
			else{
				input[i+1]=input[i+1]-input[i];
				input[i]=0;
			}
			
		}
		if(flag==false)
			System.out.println("NO");
		else if(input[n-1]!=0)
			System.out.println("NO");
		else
			System.out.println("YES");
		s.close();
			
	}

}
