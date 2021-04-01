import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    String[] spotArray = new String[n];
    String[] plainArray = new String[n];
    for (int i = 0; i < n; i++){
      spotArray[i] = in.next();
    }
    for (int i = 0; i < n; i++){
      plainArray[i] = in.next();
    }
    int count = 0;
    Loop:
    for (int i = 0; i < m; i++){
      HashSet<String> spotSet = new HashSet<>();
      for (int j = 0; j < n; j++){
        spotSet.add(spotArray[j].substring(i, i + 1));
      }
      for (int j = 0; j < n; j++){
        if (spotSet.contains(plainArray[j].substring(i, i + 1))) continue Loop;
      }
      count++;
    }
    System.out.println(count);
  }
}
