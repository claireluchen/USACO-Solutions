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
    double maxDistance = 0;
    for (int i = 0; i < x.length; i++){
      for (int j = i + 1; j < x.length; j++){
        int x1 = x[i], y1 = y[i];
        int x2 = x[j], y2 = y[j];
        double distance = Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2);
        maxDistance = Math.max(maxDistance, distance);
      }
    }
    System.out.println((int) maxDistance);
  }

}
