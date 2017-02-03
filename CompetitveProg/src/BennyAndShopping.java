import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class BennyAndShopping {
	public static void main(String args[]) throws IOException{
		int n,i,j,k;
		String order,result;
		boolean flag = false;
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(reader.readLine());
		k=1;
		while(k<=n){
			order=reader.readLine();
			result="$";
			flag=true;
			i=order.indexOf('$');
			for(j=i+1;j<order.length();j++){
				if(order.charAt(j)=='0' && flag==true)
					continue;
				else if(order.charAt(j)==' ')
					continue;
				else if(order.charAt(j)>=48 && order.charAt(j)<=57){
					result=result+order.charAt(j);
					flag=false;
				}
				else
					break;
			}
			if(flag==true)
				result+='0';
			System.out.println(result);
			k++;
		}
		reader.close();
	}

}
