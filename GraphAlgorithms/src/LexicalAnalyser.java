import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class LexicalAnalyser {
	static int id=100;
	static ArrayList<SymbolTable> list =new ArrayList<>();
	public static void main(String args[]) throws IOException{
		String input;
		SymbolTable table;
		String var="";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		input = reader.readLine();
		char [ ] in = input.toCharArray();
		for(int i = 0; i < in.length; i++){
			if(in[i] =='{' || in[i]=='}' || in[i]== '(' || in[i]== ')' || in[i]=='[' || in[i]==']'){
				table= new SymbolTable(id++ , "specialSymbol" , in[i]+"");
				list.add(table);
			}
			else if(in[i]== '+' || in[i]=='-' ||in[i]=='*'  || in[i]=='/' ||  in[i]=='%'){
				table= new SymbolTable(id++ , "operator" , in[i]+"");
				list.add(table);
			}
			else if(in[i]>=97 && in[i] <=122 ||in[i]=='_'){
				if((in[i+1] >=97 && in[i+1] <=122 ) || (in[i+1] >=48 && in[i+1] <=57 )){
					var=var+in[i];
					continue;
				}
				else {
					var = var+in[i];
					table = new SymbolTable(id+4, "variable" ,var);
				}
				
			}
			
			
		}
	}

}
class SymbolTable{
	int id;
	String opType;
	String name;
	
	SymbolTable(int id, String opType , String name){
		this.id = id;
		this.opType = opType;
		this.name = name;
	}
}
