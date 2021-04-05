import java.util.*;

public class Main{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int x = in.nextInt();
    in.nextLine();
    String[] constraints = new String[x * 2];
    for (int i = 0; i < x; i++){
      String[] line = in.nextLine().split(" ");
      constraints[2 * i] = line[0];
      constraints[2 * i + 1] = line[line.length - 1];
    }
    String[] names = {"Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"};

    doPermutation(constraints, names, names.length, new ArrayList<String>(), new boolean[names.length]);
  }

  public static void doPermutation(String[] constraints, String[] names, int n, ArrayList<String> takenName, boolean[] chosen){
    if (takenName.size() == n){
      for (int i = 0; i < constraints.length; i += 2){
        String n1 = constraints[i], n2 = constraints[i + 1]; //n1 must be beside n2
        int indexOfN1 = takenName.indexOf(n1);
        int indexOfN2 = takenName.indexOf(n2);
        if (indexOfN1 != indexOfN2 - 1 && indexOfN1 != indexOfN2 + 1)
          return;
      }
      for (String i : takenName) System.out.println(i);
      System.exit(0);
    }else{
      for (int i = 0; i < names.length; i++){
        if (chosen[i]) continue;
        chosen[i] = true;
        takenName.add(names[i]);
        doPermutation(constraints, names, n, takenName, chosen);
        chosen[i] = false;
        takenName.remove(takenName.size() - 1);
      }
    }
  }
}
