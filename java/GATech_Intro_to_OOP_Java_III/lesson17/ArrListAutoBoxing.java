import java.util.ArrayList;

public class ArrListAutoBoxing {
  public static void main(String[] args) {
    ArrayList<Integer> scores = new ArrayList<>();

    scores.add(90); // autoboxing occurs 
    scores.add(95); // java creates an Object version of the int literal
    scores.add(100);// using the matching wrapper of the literal's type
    scores.add(99); // in this case, the wrapper is Integer
    scores.add(106);
    System.out.println(scores.toString());

    int sum = 0;
    for (Integer score: scores) {
        sum += score;
    }

    System.out.println("Total points: " + sum);

  }
}
