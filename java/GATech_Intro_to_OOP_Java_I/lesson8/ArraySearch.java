public class ArraySearch {
  public static void main(String[] args) {
    String[] concepts = {"abstraction", "polymorphism", "inheritance", "encapsulation"};
    
    boolean result = searchArray("polymorphism", concepts);
    System.out.println(result);

    int[] numbers = {1,2,3,4,5};
    System.out.println(searchArray(1, numbers));

  }

  // We can overload methods by specifying the argument types
  public static boolean searchArray(String target,
                                    String[] array) {
    boolean result = false;
    for (String element : array) {
      if (element.equals(target)) {
        result = true;
        break;
      }
    }
    return result;
  }

  public static boolean searchArray(int target,
                                    int[] array) {
    boolean result = false;
    for (int element : array) {
      if (element == target) {
        result = true;
        break;
      }
    }
    return result;
  }
}
