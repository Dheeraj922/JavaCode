import java.util.Scanner;

public class CircularArrayRotation {
	public static void main(String args[]) {
		int n,k,q;
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		k = input.nextInt();
		q = input.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i<n; i++){
			arr[i] = input.nextInt();
		}
		int res[] = new int[n];
		int j,l;
		l=0;
		j=0;
		for(int i = 0;i<n; i++){
			l=(i+k)%n;
			res[l] = arr[i];
			j++;
		}
		
		/*int j=0;
		for(int i=0; i<k; i++){
			for(int l=0; l<n; l++){
				j = (l+1)%n;
				res[j] = arr[l];
			}
		}*/
		for(int i=0 ; i<q; i++){
			System.out.println(res[input.nextInt()]);
		}
		input.close();
	}

}
