//uses complete search, part of the USACO guide
import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    int[] x = new int[N], y = new int[N];
    for (int i = 0; i < x.length; i++){
      x[i] = in.nextInt();
    }
    for (int i = 0; i < y.length; i++){
      y[i] = in.nextInt();
    }
    int maxDistance = 0;
    for (int i = 0; i < x.length; i++){
      for (int j = i + 1; j < x.length; j++){
        int x1 = x[i], y1 = y[i];
        int x2 = x[j], y2 = y[j];
        int diffX = x2 - x1, diffY = y2 - y1;
        int distance = diffX * diffX + diffY * diffY;
        maxDistance = Math.max(maxDistance, distance);
      }
    }
    System.out.println(maxDistance);
  }
}
