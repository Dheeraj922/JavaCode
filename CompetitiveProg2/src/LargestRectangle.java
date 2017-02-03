import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Stack;
import java.util.Vector;


public class LargestRectangle {
	
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		int n, h[];
		long area=0,max;
		Vector<Integer> v = new Vector<>();
		Stack<Integer> stack = new Stack<>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());
		h = new int[n];
		String in[] = reader.readLine().split(" ");
		for(int i=0; i<in.length; i++)
			stack.push(Integer.parseInt(in[i]));
		for(int i=0; i<in.length; i++)
			h[i] = Integer.parseInt(in[i]);
		int count = 2;
		//calculating the required area of the rectangle
		for(int i=h.length-1; i>=0; i--){
			v.add(h[i]);
			for(int j=i-1; j>=0; j--){
				v.add(h[j]);
				max = count * min(v);
				if(max > area)
					area = max;
				count++;
			}
			count = 2;
			v.clear();
		}
			
		System.out.println(area);
	}

	private static int min(Vector<Integer> v) {
		Collections.sort(v);
		return v.get(0);
	}

}
