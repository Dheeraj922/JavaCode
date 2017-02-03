import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class CompilerVersion {
	public static void main(String args[]) throws FileNotFoundException{
		//File file=new File("C:\\Users\\DHEERAJ\\Desktop\\New folder\\myfile.txt");
		String input;
		boolean flag;
		StringBuilder builder;
		char []res;
		Scanner s=new Scanner(System.in);
		while(s.hasNext()){
			flag=false;
			input=new String();
			builder=new StringBuilder();
			input=s.nextLine();
			res=input.toCharArray();
			for(int i=0;i<res.length;i++){
				if(flag){
					if(res[i]==' ')
						builder.append(' ');
					else
						builder.append(res[i]);
					continue;
				}
				if(i<res.length-1 && res[i]=='/' && res[i+1]=='/'){
					flag=true;
					builder.append("//");
					i++;
				}
				else if(i<res.length-1 && res[i]=='-' && res[i+1]=='>'){
					builder.append('.');
					i++;
				}
				else if(res[i]==' ')
					builder.append(' ');
				else
					builder.append(res[i]);
			}
			 
			System.out.println(builder);
			
		}
		s.close();
		
	}

}
