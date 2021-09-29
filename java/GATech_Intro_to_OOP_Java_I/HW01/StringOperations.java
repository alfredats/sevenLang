public class StringOperations {
  public static void main(String[] args) {
    String myName = "Elfred";
    System.out.printf("%s\n", myName);

    String firstSwap = 'A' + myName.substring(1,myName.length() - 1) + 'Z';
    System.out.printf("%s\n", firstSwap);

    String webAdd = "www.happy.com";
    System.out.printf("%s\n", webAdd);

    String replaced = webAdd.replaceAll("(w{3}\\.)","").replaceAll("(\\.com)","1331");
    System.out.printf("%s\n", replaced);
  }
}
