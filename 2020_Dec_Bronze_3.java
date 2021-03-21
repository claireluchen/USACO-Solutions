import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3{
	static StringTokenizer tokenizer = null;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	private static int n;
	private static String[] D = new String[55];
	private static long[] X = new long[55];
	private static long[] Y = new long[55];
	
	private static boolean[] stopped = new boolean[55];
	private static long[] ans = new long[55];
	
	private static final int INF = 2000000000;

	public static void main(String[] args) throws IOException{
		n = nextInt();
		for (int i = 1; i <= n; i++) {
			D[i] = next();
			X[i] = nextLong();
			Y[i] = nextLong();
			ans[i] = INF;
		}
		
		while(true) {
			long mn = INF;
			for (int i = 1; i <= n; i++) if (!stopped[i]) {
				ans[i] = INF;
				for (int j = 1; j <= n; j++) if (i != j) {
					if(D[i].equals("E")) {
						if (D[j].equals("N") && X[j] > X[i] && Y[j] <= Y[i] && Y[j] + ans[j] >= Y[i] && 
							Math.abs(Y[j] - Y[i]) < Math.abs(X[j] - X[i]) || D[j].equals("E") && Y[i] == Y[j] && X[j] > X[i]) {
							ans[i] = Math.min(ans[i], Math.abs(X[j] - X[i]));
						}
					}else {
						if(D[j].equals("E") && Y[j] > Y[i] && X[j] <= X[i] && X[j] + ans[j] >= X[i] && 
							Math.abs(X[j] - X[i]) < Math.abs(Y[j] - Y[i]) || D[j].equals("N") && X[i] == X[j] && Y[j] > Y[i]) {
							ans[i] = Math.min(ans[i], Math.abs(Y[j] - Y[i]));
						}
					}
				}
				mn = Math.min(mn, ans[i]);
			}
			
			for (int i = 1; i <= n; i++) if (!stopped[i] && ans[i] == mn) {
				stopped[i] = true;
			}
			if (mn == INF) {
				break;
			}
		}
		
		for (int i = 1; i <= n; i++) {
			if (ans[i] == INF) {
				System.out.println("Infinity");
			}else {
				System.out.println(ans[i]);
			}
		}
		
	}

	static String next() {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			}catch(IOException e) {}
		}
		return tokenizer.nextToken();
	}
		  
	static int nextInt () throws IOException {
	    return Integer.parseInt(next());
	}
	
	static long nextLong () throws IOException {
	    return Long.parseLong(next());
	}
}
