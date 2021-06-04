//keep track of the difference between each consecutive elements; when a new range is given, only update the difference values at the ends (a and b + 1)
import java.util.*;
import java.io.*;

public class Test {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}

  public static void main(String[] args) throws IOException{
	    int n = readInt(), k = readInt();
	    int[] diff = new int[n + 1];
	    for (int i = 0; i < k; i++){
	      diff[readInt()]++; 
	      int b = readInt();
	      if (b + 1 < diff.length) diff[b + 1]--;
	    }
	    int[] array = new int[n + 1];
	    for (int i = 1; i < array.length; i++){
	      array[i] = array[i - 1] + diff[i];
	    }
	    Arrays.sort(array);
	    System.out.println(array[(array.length - 1) / 2 + 1]);
  }
}
