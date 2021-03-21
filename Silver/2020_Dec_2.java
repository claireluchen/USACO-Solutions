import java.io.*;
import java.util.*;

public class Silver2{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokenizer = null;

    private static int n;
    private static long ans;
    private static int[][] A = new int[3000][2];

    private static int[] tree = new int[3000];

    public static void main(String[] args) {
        n = nextInt();
        for(int i=1;i<=n;i++) {
            A[i][0] = nextInt();
            A[i][1] = nextInt();
        }

        Arrays.sort(A, 1, n + 1, (a, b) -> Integer.compare(a[0], b[0]));
        for(int i=1;i<=n;i++) {
            A[i][0] = i;
        }
        Arrays.sort(A, 1, n + 1, (a, b) -> Integer.compare(a[1], b[1]));
        for(int i=1;i<=n;i++) {
            A[i][1] = i;
        }

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) tree[j] = 0;
            int a = 1, b = 1;
            for(int j=i+1;j<=n;j++) {
                add(A[j][0]);
                if(A[j][0] < A[i][0]) {
                    a++;
                    int x = query(A[j][0]);
                    ans += 1L * b * x;
                } else {
                    b++;
                    int x = query(n) - query(A[j][0]) + 1;
                    ans += 1L * a * x;
                }
            }
        }

        System.out.println(ans + n + 1);
    }

    private static void add(int pos) {
        for(;pos<=n;pos+=pos&(-pos)) tree[pos]++;
    }

    private static int query(int pos) {
        int ret = 0;
        for(;pos>0;pos-=pos&(-pos)) ret += tree[pos];
        return ret;
    }

    private static String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() {
        return Integer.parseInt(next());
    }
}
