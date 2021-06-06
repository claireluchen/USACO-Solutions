//greeding with sorting
import java.util.*;
import java.io.*;

public class Main {
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
    int n = readInt();
    int[] A = new int[n];
    for (int i = 0; i < n; i++) A[i] = readInt();
    Arrays.sort(A);
    int inLine = 0;
    for (int i = n - 1; i >= 0; i--){
      if (A[i] >= inLine){
        inLine++;
      }else{
        break;
      }
    }
    System.out.println(inLine);
  }
}
