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
  static char readChar() throws IOException{
    return next().charAt(0);
  }

  public static void main(String[] args) throws IOException{
    int n = readInt();
    int[] psaP = new int[n + 1], psaH = new int[n + 1], psaS = new int[n + 1];
    for (int i = 1; i <= n; i++){
      char c = readChar();
      if (c == 'P'){
        psaP[i] = psaP[i - 1] + 1;
        psaH[i] = psaH[i - 1];
        psaS[i] = psaS[i - 1];
      }else if (c == 'H'){
        psaH[i] = psaH[i - 1] + 1;
        psaP[i] = psaP[i - 1];
        psaS[i] = psaS[i - 1];
      }else{
        psaS[i] = psaS[i - 1] + 1;
        psaP[i] = psaP[i - 1];
        psaH[i] = psaH[i - 1];
      }
    }

    int max = Integer.MIN_VALUE;
    for (int i = 1; i < psaP.length; i++){ //let bessie change her choice at position i
      int firstHalf = findMax(psaP[i], psaH[i], psaS[i]);
      int lastHalf = findMax(psaP[n] - psaP[i], psaH[n] - psaH[i], psaS[n] - psaS[i]);
      max = Math.max(max, firstHalf + lastHalf);
    }
    System.out.println(max);
  }
  
  public static int findMax(int a, int b, int c){
    return Math.max(a, Math.max(b, c));
  }
}
