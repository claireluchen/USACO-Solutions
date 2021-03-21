import java.io.*;
import java.util.*;

public class Gold2{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokenizer = null;

    private static final int MOD = 1000000007;

    private static int n;
    private static String s;

    private static int[] A = new int[100010];
    private static int[][][][] f = new int[100010][5][5][5];

    public static void main(String[] args) {
        s = next();
        n = s.length();
        for(int i=1;i<=n;i++) {
            char c = s.charAt(i-1);
            if(c == 'A') A[i] = 1;
            else if(c == 'C') A[i] = 2;
            else if(c == 'G') A[i] = 3;
            else if(c == 'T') A[i] = 4;
            else A[i] = 0;
        }

        for(int i=1;i<=4;i++) if(A[1] == 0 || A[1] == i) f[1][i][i][0] = 1;
        for(int i=1;i<n;i++) for(int j=1;j<=4;j++) if(A[i] == 0 || A[i] == j)
            for(int k=1;k<=4;k++) if(A[i+1] == 0 || A[i+1] == k)
            {
                for(int l=1;l<=4;l++)
                {
                    f[i+1][k][k][l] = (f[i+1][k][k][l] + f[i][j][l][0]) % MOD;
                    f[i+1][k][k][l] = (f[i+1][k][k][l] + f[i][j][l][j]) % MOD;
                }
                if(j != k) for(int a=1;a<=4;a++) for(int b=0;b<=4;b++) f[i+1][k][a][b] = (f[i+1][k][a][b] + f[i][j][a][b]) % MOD;
            }

        long ans = 0;
        for(int i=1;i<=4;i++) for(int j=1;j<=4;j++) {
            ans = (ans + f[n][i][j][0]) % MOD;
            ans = (ans + f[n][i][j][i]) % MOD;
        }
        System.out.println(ans);
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
}
