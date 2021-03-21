import java.io.*;
import java.util.*;

public class Silver3{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokenizer = null;

    private static int n;
    private static int[] ans = new int[1010];
    private static List<Point> east = new ArrayList<>();
    private static List<Point> north = new ArrayList<>();
    
    private static int ecnt;
    private static int[][] e = new int[1000010][2];
    private static int[] p = new int[1010];
    
    public static void main(String[] args) {
        n = nextInt();
        for (int i = 1; i <= n; i++) {
        	ans[i] = -1;
        }
        for (int i = 1; i <= n; i++) {
        	String d = next();
        	long x = nextLong();
        	long y = nextLong();
        	if (d.equals("E")) {
        		east.add(new Point(i, x, y));
        	}else {
        		north.add(new Point(i, x, y));
        	}
        }
        Collections.sort(east, (a, b) -> Long.compare(a.y, b.y));
        Collections.sort(north, (a, b) -> Long.compare(a.x, b.x));
        
        for (Point u : north) {
        	for (Point v : east) {
        		if (!v.stopped && v.y >= u.y && v.x <= u.x) {
        			long dx = Math.abs(v.x - u.x);
        			long dy = Math.abs(v.y - u.y);
        			if (dy < dx) {
        				v.stopped = true;
        				adde(u.id, v.id);
        			}else if (dy > dx) {
        				u.stopped = true;
        				adde(v.id, u.id);
        				break;
        			}
        		}
        	}
        }
        
        for (int i = 1; i <= n; i++) {
        	System.out.println(dfs(i));
        }
        
    }
    
    private static int dfs(int sn) {
    	if (ans[sn] >= 0) {
    		return ans[sn];
    	}
    	ans[sn] = 0;
    	for (int i = p[sn]; i != 0; i = e[i][1]) {
    		int fn = e[i][0];
    		ans[sn] += dfs(fn) + 1;
    	}
    	return ans[sn];
    }
    
    private static void adde(int sn, int fn) {
    	ecnt++;
    	e[ecnt][0] = fn;
    	e[ecnt][1] = p[sn];
    	p[sn] = ecnt;
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
   
    private static long nextLong() {
        return Long.parseLong(next());
    }
    
    private static class Point{
    	int id;
    	long x;
    	long y;
    	boolean stopped;
    	private Point(int id, long x, long y) {
    		this.id = id;
    		this.x = x;
    		this.y = y;
    		this.stopped = false;
    	}
    }
}
