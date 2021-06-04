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
    int n = readInt(), k = readInt(), b = readInt();
    boolean[] brokenLights = new boolean[n + 1];
    for (int i = 0; i < b; i++){
      brokenLights[readInt()] = true;
    }

    int[] psa = new int[n + 1];
    for (int i = 1; i < psa.length; i++){
      if (!brokenLights[i]){
        psa[i] = psa[i - 1] + 1;
      }else{
        psa[i] = psa[i - 1];
      }
    }

    int min = Integer.MAX_VALUE;
    for (int i = 1; i + k - 1 < psa.length; i++){
      int work = psa[i + k - 1] - psa[i - 1];
      min = Math.min(min, k - work);
    }
    System.out.println(min);
  }

}
