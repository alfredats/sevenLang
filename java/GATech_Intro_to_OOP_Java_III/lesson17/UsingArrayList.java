import java.util.ArrayList;

public class UsingArrayList {
  public static void main(String[] args) {
    // unsafe constructors
    ArrayList defaultArrayList = new ArrayList();
    ArrayList numberedArrayList = new ArrayList(5); // can be mutated unlike normal arrays

    // type-safe 
    ArrayList<String> parameterizedTypeArrList = new ArrayList<String>(); // restricts the arraylist to a single type 
    ArrayList<String> alsoParameterized = new ArrayList<> (); // short form in initialization

    alsoParameterized.add("goodbye");
    alsoParameterized.add("hello");

    System.out.println(alsoParameterized.get(1)); // indexing
    System.out.println(alsoParameterized.get(0));
    System.out.println(alsoParameterized.toString());
  }
}
