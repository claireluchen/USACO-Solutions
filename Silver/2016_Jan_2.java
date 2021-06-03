//prefix sum array
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
    long[] psa = new long[n + 1];
    for (int i = 1; i < psa.length; i++){
      psa[i] = psa[i - 1] + readInt();
    }

    for (int len = n; len > 0; len--){
      for (int a = 1; a + len - 1 < psa.length; a++){
        int b = a + len - 1;
        if ((psa[b] - psa[a - 1]) % 7 == 0){
          System.out.println(len); return;
        }
      }
    }
    System.out.println(0);
  }
}
