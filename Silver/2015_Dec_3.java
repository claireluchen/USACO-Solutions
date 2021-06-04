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
    int n = readInt(), q = readInt();
    int[] psa1 = new int[n + 1], psa2 = new int[n + 1], psa3 = new int[n + 1];
    for (int i = 1; i <= n; i++){
      int b = readInt();
      if (b == 1){
        psa1[i] = psa1[i - 1] + 1;
        psa2[i] = psa2[i - 1];
        psa3[i] = psa3[i - 1];
      }else if (b == 2){
        psa1[i] = psa1[i - 1];
        psa2[i] = psa2[i - 1] + 1;
        psa3[i] = psa3[i - 1];
      }else{
        psa1[i] = psa1[i - 1];
        psa2[i] = psa2[i - 1];
        psa3[i] = psa3[i - 1] + 1;
      }
    }

    for (int i = 0; i < q; i++){
      int a = readInt(), b = readInt();
      System.out.print(psa1[b] - psa1[a - 1] + " ");
      System.out.print(psa2[b] - psa2[a - 1] + " ");
      System.out.print(psa3[b] - psa3[a - 1] + " " );
      System.out.println();
    }
    
  }
}
