import java.io.*;
import java.util.*;

public class Gold3{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokenizer = null;

    private static int n;
    private static int ans;
    private static int[][] A = new int[201][2];

    public static void main(String[] args) {
        n = nextInt();
        for(int i = 1; i <= n; i++) {
            A[i][0] = nextInt();
            A[i][1] = nextInt();
        }

        Set<Integer> vis = new HashSet<>();

        Arrays.sort(A, 1, n + 1, (a,b) -> Integer.compare(a[1],b[1]));
        for(int i = 1; i <= n; i++) for(int j = i + 1; j <= n; j++) {
            int d = A[j][1] - A[i][1] + 1;
            int mn = Math.min(A[i][0], A[j][0]);
            int mx = Math.max(A[i][0], A[j][0]);
            vis.clear();
            for(int k = i; k <= j; k++) vis.add(A[k][0]);
            for(int k = i; k <= j; k++) if(A[k][0] <= mn && A[k][0]+d > mx && !vis.contains(A[k][0]+d-1) && !vis.contains(A[k][0]+d)) ans++;
            for(int k = i; k <= j; k++) if(A[k][0]-d <= mn && A[k][0] > mx && (!vis.contains(A[k][0]-1) || !vis.contains(A[k][0]-d))) ans++;
        }

        Arrays.sort(A, 1, n + 1, (a,b) -> Integer.compare(a[0],b[0]));
        for(int i = 1;i <= n; i++) for(int j = i + 1; j <= n; j++) {
            int d = A[j][0] - A[i][0] + 1;
            int mn = Math.min(A[i][1], A[j][1]);
            int mx = Math.max(A[i][1], A[j][1]);
            vis.clear();
            for(int k = i; k <= j; k++) vis.add(A[k][1]);
            for(int k = i; k <= j; k++) if(A[k][1] <= mn && A[k][1]+d > mx && !vis.contains(A[k][1]+d)) ans++;
            for(int k = i; k <= j; k++) if(A[k][1] > mx && A[k][1]-d <= mn) ans++;
        }

        System.out.println(ans+n+1);
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
