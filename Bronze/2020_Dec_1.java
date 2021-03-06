import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static StringTokenizer tokenizer = null;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	private static int[] A = new int[7];
	
	public static void main(String[] args) throws IOException{
		for (int i = 0; i < 7; i++) {
			A[i] = nextInt();
		}
		Arrays.sort(A);
		System.out.println(A[0] + " " + A[1] + " " + (A[6] - A[0] - A[1]));
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
