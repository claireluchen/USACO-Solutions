import java.util.*;

public class Main{

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int x = in.nextInt();
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < x; i++){
      set.add(in.nextInt());
    }
    System.out.println(set.size());
  }

}
