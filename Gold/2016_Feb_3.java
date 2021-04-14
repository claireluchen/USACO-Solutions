import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static String next () throws IOException {
	   	while (st == null || !st.hasMoreTokens())
	   		st = new StringTokenizer(br.readLine().trim());
	    return st.nextToken();
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	
	public static void main(String[] args) throws IOException{
		int A = readInt(), B = readInt(), n = readInt(), m = readInt();
		ArrayList<Pair>[] adj = new ArrayList[(n + 1) * (m + 1)];
		for (int i = 0; i < adj.length; i++) adj[i] = new ArrayList<>();
		
		ArrayList<Integer> verticalFences = new ArrayList<>();
		ArrayList<Integer> horizontalFences = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			verticalFences.add(readInt());
		}
		for (int i = 0; i < m; i++) {
			horizontalFences.add(readInt());
		}
		Collections.sort(verticalFences);
		verticalFences.add(0, 0);
		verticalFences.add(A);
		Collections.sort(horizontalFences, Collections.reverseOrder());
		horizontalFences.add(0, B);
		horizontalFences.add(0);
	
		int count = 0;
		for (int row = 1; row < horizontalFences.size(); row++) {
			int prevRow = horizontalFences.get(row - 1);
			int curRow = horizontalFences.get(row);
			for (int col = 1; col < verticalFences.size(); col++) {
				int prevCol = verticalFences.get(col - 1);
				int curCol = verticalFences.get(col);
				if (count + n + 1 < adj.length) {
					int weight = curCol - prevCol;
					adj[count].add(new Pair(weight, count + n + 1));
					adj[count + n + 1].add(new Pair(weight, count));
				}
				if (count + 1 < adj.length && count + 1 < row * (n + 1)) {
					int weight = prevRow - curRow;
					adj[count].add(new Pair(weight, count + 1));
					adj[count + 1].add(new Pair(weight, count));
				}
				count++;
			}
		}
				
		long totalWeight = 0;
		PriorityQueue<Pair> q = new PriorityQueue<>();
		boolean[] visited = new boolean[adj.length];
		q.add(new Pair(0, 0));
		ArrayList<Integer> list = new ArrayList<>();
		
		while (!q.isEmpty()) { //prim's algorithm
			Pair temp = q.poll(); 
			int curWeight = temp.x;
			int cur = temp.y; 
			if(visited[cur]) continue; 
			visited[cur] = true;
			totalWeight += curWeight;
			list.add(cur);
			for (Pair nxt : adj[cur]) {
				int b = nxt.y, w = nxt.x; 
				q.add(new Pair(w, b));
			}
		}
		System.out.println(totalWeight);
	}
	
	static class Pair implements Comparable<Pair>{
	    int x, y;
	    public Pair(int x, int y){
	    	this.x = x; this.y = y;
	    }
	   
	    @Override
	    public int compareTo(Pair obj) {
	    	if (x < ((Pair) obj).x) return -1;
	    	if (x > ((Pair) obj).x) return 1;
	    	return 0;
	    }
	    
	    @Override
	    public boolean equals(Object obj){
	    	if (obj instanceof Pair && x == ((Pair) obj).x && y == ((Pair) obj).y)
	    		return true;
	    	else return false;
	    }
	   
	    @Override
	    public int hashCode(){
	    	int result = x / 11 + y;
	    	return result;
	    }
		
	}

}
