//uses standard input and output
import java.util.*;

public class Main{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] freq = new int[26];
    for (int i = 0; i < n; i++){
      String s1 = in.next(); String s2 = in.next();
      int[] tempFreq = new int[26];
      for (int j = 0; j < s1.length(); j++){
        char c = s1.charAt(j);
        tempFreq[(int) c - 97]++;
      }
      int[] tempFreq2 = new int[26];
      for (int j = 0; j < s2.length(); j++){
        char c = s2.charAt(j);
        tempFreq2[(int) c - 97]++;
      }
      for (int j = 0; j < 26; j++){
        freq[j] += Math.max(tempFreq[j], tempFreq2[j]);
      }
    }
    for (int i : freq) System.out.println(i);
  } 
}
