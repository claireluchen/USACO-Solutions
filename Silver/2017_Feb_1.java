//greedy algorithm
import java.util.*;

public class Test {

  public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	int c = in.nextInt(), n = in.nextInt();
    int[] chick = new int[c];
    ArrayList<Pair> cow = new ArrayList<>();
    
    for (int i = 0; i < c; i++) chick[i] = in.nextInt();
    for (int i = 0; i < n; i++) {
    	int a = in.nextInt(), b = in.nextInt();
    	cow.add(new Pair(b, a));
    }
    Arrays.sort(chick); Collections.sort(cow);

    int count = 0;
    for (int i = 0; i < chick.length; i++) {
    	for (int j = 0; j < cow.size(); j++) {
    		if (cow.get(j).y <= chick[i] && cow.get(j).x >= chick[i]) {
    			count++;
    			cow.remove(new Pair(cow.get(j).x, cow.get(j).y));
    			break;
    		}
    	}
    }
    System.out.println(count);
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
        if (y < ((Pair) obj).y) return -1;
        if (y > ((Pair) obj).y) return 1;
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
