import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2{
	static StringTokenizer tokenizer = null;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	private static int n;
	private static int[] A = new int[110];
	
	public static void main(String[] args) throws IOException{
		n = nextInt();
		for (int i = 1; i <= n; i++) {
			A[i] = nextInt();
		}
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int tot = 0;
				for (int k = i; k <= j; k++) {
					tot += A[k];
				}
				for (int k = i; k <= j; k++) {
					if (A[k] * (j - i + 1) == tot) {
						ans++;
						break;
					}
				}
			}
		}
		System.out.println(ans);
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
}
