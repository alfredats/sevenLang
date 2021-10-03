public class IntroToArrays {
  public static void main(String[] args) {
    String[] concepts = {"abstraction", "polymorphism", "inheritance", "encapsulation"};

    String result = "not found";
    for (String concept : concepts) {
      if (concept.equals("polymorphism")) {
        result = "found";
        break;
      }
    }

    System.out.println(result);
    System.out.println(concepts[1]);
  }
}
