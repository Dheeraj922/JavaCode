import java.util.Scanner;


public class PlayFair {
	public static void main(String args[]){
		
		String key="amanverma";
		String plainText="";
		int l = key.length();
		int k=0;
		Scanner scanner = new Scanner(System.in);
		plainText= scanner.nextLine();
		char [][]mat = new char[5][5];
		for(int i=0; i<5; i++){
			for(int j =0; j<5; j++){
				
				if(k<l  && contains(key.charAt(k), mat)){
					mat[i][j] = key.charAt(k);
				}
				
			}
			
		}
		
	}

	private static boolean contains(char x , char[][] mat) {
		for(int i =0; i<mat.length;  i++){
			for(int j=0; j<mat.length; j++){
				if(x==mat[i][j])
					return false;
			}
		}
		
		return false;
	}

}
