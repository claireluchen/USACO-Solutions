import java.io.*;
import java.util.*;

public class Gold1{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokenizer = null;

    private static int n;
    private static long D;
    private static char[][] MAP = new char[1010][1010];

    private static int[][] dis = new int[1010][1010];
    private static int[][] dis2 = new int[1010][1010];
    private static int[][] mark = new int[1010][1010];
    private static boolean[][] vis = new boolean[1010][1010];

    public static void main(String[] args) {
        n = nextInt();
        D = nextInt();
        for(int i = 1;i <= n; i++) {
            String s = next();
            for(int j = 1;j <= n; j++) {
                MAP[i][j] = s.charAt(j-1);
            }
        }

        bfs1();
        bfs2();

        doMark();

        int ans = 0;
        for(int i = 1;i <= n; i++) for(int j = 1;j <= n; j++) if(mark[i][j] > 0) ans++;
        System.out.println(ans);
    }

    private static int[][] dir = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private static void bfs1() {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 1;i <= n;i++) for(int j = 1;j <= n; j++) if(MAP[i][j] == '#') q.add(new int[]{i,j});
        while(!q.isEmpty()) {
            int[] p = q.poll();
            int i = p[0];
            int j = p[1];
            for(int k = 0;k < 4; k++) {
                int ii = i + dir[k][0];
                int jj = j + dir[k][1];
                if(ii <= 0 || jj <= 0 || ii > n || jj > n) continue;
                if(MAP[ii][jj] == '#') continue;
                if(dis[ii][jj] > 0) continue;
                dis[ii][jj] = dis[i][j] + 1;
                q.add(new int[]{ii,jj});
            }
        }
    }

    private static void bfs2() {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 1;i <= n; i++) for(int j = 1; j <= n; j++) if(MAP[i][j] == 'S') {
            q.add(new int[]{i,j});
            dis2[i][j] = 1; mark[i][j] = 1; 
        }
        while(!q.isEmpty()) {
            int[] p = q.poll();
            int i = p[0];
            int j = p[1];
            for(int k = 0;k < 4; k++) {
                int ii = i + dir[k][0];
                int jj = j + dir[k][1];
                if(ii <= 0 || jj <= 0 || ii > n || jj > n) continue;
                if(MAP[ii][jj] == '#') continue;
                if(dis2[ii][jj] > 0) continue;
                if(dis2[i][j]/D+1 > dis[ii][jj]) {
                    mark[ii][jj] = dis[ii][jj];
                    continue;
                }
                dis2[ii][jj] = dis2[i][j] + 1;
                mark[ii][jj] = (int)(dis2[i][j]/D)+1;
                q.add(new int[]{ii,jj});
            }
        }
    }

    private static void doMark() {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 1;i <= n; i++) for(int j = 1;j <= n;j++) if(mark[i][j] > 0) {
            q.add(new int[]{i,j});
            vis[i][j] = true;
        }
        while(!q.isEmpty()) {
            int[] p = q.poll();
            int i = p[0], j = p[1];
            vis[i][j] = false;
            for(int k = 0; k < 4; k++) {
                int ii = i + dir[k][0];
                int jj = j + dir[k][1];
                if(ii <= 0 || jj <= 0 || ii > n || jj > n) continue;
                if(MAP[ii][jj] == '#') continue;
                if(mark[ii][jj] >= mark[i][j] - 1) continue;
                mark[ii][jj] = mark[i][j] - 1;
                if(vis[ii][jj]) continue;
                vis[ii][jj] = true;
                q.add(new int[]{ii,jj});
            }
        }
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
