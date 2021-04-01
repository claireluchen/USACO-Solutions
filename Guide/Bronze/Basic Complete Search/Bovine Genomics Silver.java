import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt(), m = in.nextInt();
    char[][] spot = new char[n][m], plain = new char[n][m];
    for (int i = 0; i < n; i++){
      spot[i] = in.next().toCharArray();
    }
    for (int i = 0; i < n; i++){
      plain[i] = in.next().toCharArray();
    }
    int count = 0;
    for (int a = 0; a < m; a++){
      for (int b = a + 1; b < m; b++){
        for (int c = b + 1; c < m; c++){
          if (works(spot, plain, a, b, c)) count++;
        }
      }
    }
    System.out.println(count);
  }
  public static boolean works(char[][] spot, char[][] plain, int a, int b, int c){
    HashSet<ArrayList<Character>> spotSet = new HashSet<>();
    for (int i = 0; i < spot.length; i++){
      ArrayList<Character> temp = new ArrayList<>();
      temp.add(spot[i][a]); temp.add(spot[i][b]); temp.add(spot[i][c]);
      spotSet.add(temp);
    }
    for (int i = 0; i < plain.length; i++){
      ArrayList<Character> temp = new ArrayList<>();
      temp.add(plain[i][a]); temp.add(plain[i][b]); temp.add(plain[i][c]);
      if (spotSet.contains(temp)) return false;
    }
    return true;
  }
}
