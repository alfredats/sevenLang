public class AvlCompleteTests {

  public static void main(String[] args) {
    AVL<Integer> t0 = new AVL<Integer>();
    t0.add(2);
    t0.levelPrint();
    t0.add(1);
    t0.levelPrint();
    t0.add(0);
    t0.levelPrint();
  }

}
