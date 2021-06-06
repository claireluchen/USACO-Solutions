//greedy with sorting (card problem)
import java.util.*;
import java.io.*;

public class Test {
  	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}

  	public static void main(String[] args) throws IOException{
	    int n = readInt();
	    HashSet<Integer> set = new HashSet<>();
	    for (int i = 0; i < n; i++) set.add(readInt());
	    ArrayList<Integer> b = new ArrayList<>();
	    ArrayList<Integer> e = new ArrayList<>();
	    for (int i = 1; i <= 2 * n; i++) {
	    	if (set.contains(i)) {
	    		e.add(i);
	    	}else {
	    		b.add(i);
	    	}
	    }
	    
	    int points = 0;
	    int bIndex = 0, eIndex = 0;
	    while (bIndex < n && eIndex < n) {
	    	if (b.get(bIndex) < e.get(eIndex)) {
	    		bIndex++;
	    	}else {
	    		bIndex++;
	    		eIndex++;
	    		points++;
	    	}
	    }
	    System.out.println(points);
  	}
}
