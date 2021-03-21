import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1{
	static StringTokenizer tokenizer = null;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	private static int n;
	private static int ans;
	private static int[][] e = new int[200010][2];
	private static int[] p = new int[100010];

	public static void main(String[] args) throws IOException{
		n = nextInt();
		for (int i = 1; i < n; i++) {
			int sn = nextInt();
			int fn = nextInt();
			adde(sn, fn, i << 1);
			adde(fn, sn, i << 1|1);
		}		

		ans = 0;
		dfs(1, 0);
		System.out.println(ans);
	}
	
	private static void adde(int sn, int fn, int id) {
		e[id][0] = fn;
		e[id][1] = p[sn];
		p[sn] = id;	
	}
	
	private static void dfs(int sn, int fa) {
		if (sn != 1) {
			ans++;
		}
		int cnt = 1;
		for (int i = p[sn]; i != 0; i = e[i][1]) {
			int fn = e[i][0];
			if (fn == fa) {
				continue;
			}
			dfs(fn, sn);
			cnt++;
		}
		for (int i = 0; i <= 20; i++) {
			if ((1 << i) >= cnt) {
				ans += i;
				break;
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
