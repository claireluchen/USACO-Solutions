import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    String text = in.next();
    String remove = in.next();
    while (text.contains(remove)){
      text = text.replaceAll(remove, "");
    }
    System.out.println(text);
  }
}
