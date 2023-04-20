public class AvlTreeTests {
  public static void main(String[] args) {
    pln("----- AVL NODE -----");

    pln("-- init N1 --");
    AvlNode<Integer> n1 = new AvlNode<Integer>(3);
    System.out.printf("Expect n1 height 0, actual: %s\n", n1.getHeight());
    System.out.printf("Expect n1 BF 0, actual: %s\n", n1.getBalanceFactor());

    pln("");
    pln("-- init N2, add as left child --");
    AvlNode<Integer> n2 = new AvlNode<>(1);
    n1.setLeft(n2);
    System.out.printf("Expect n1 height 1, actual: %s\n", n1.getHeight());
    System.out.printf("Expect n1 BF 1, actual: %s\n", n1.getBalanceFactor());

    pln("");
    pln("-- init N3, add as right child --");
    AvlNode<Integer> n3 = new AvlNode<>(5);
    n1.setRight(n3);
    System.out.printf("Expect n1 height 1, actual: %s\n", n1.getHeight());
    System.out.printf("Expect n1 BF 0, actual: %s\n", n1.getBalanceFactor());

    pln("");
    pln("");
    pln("----- AVL TREE -----");

    pln("-> set N1 as root");
    AvlTree<Integer> t = new AvlTree<>();
    t.setRoot(n1);

    pln("-- search --");
    System.out.printf("Expect find 2, actual: %s\n", t.search(3).getValue());
    System.out.printf("Expect find 1, actual: %s\n", t.search(1).getValue());
    System.out.printf("Expect find 3, actual: %s\n", t.search(5).getValue());
    try {
      t.search(0);
      System.out.println("Error: Expect fail find 0, instead passed");
    } catch (NullPointerException ex) {
      System.out.printf("Fail find 0 as expected\n");
    }

    pln("");
    pln("-- add --");
    System.out.println("Current tree: " + t.toString());
    t.add(4);
    System.out.printf(">>> After add 3, tree: %s\n", t.toString());
    t.add(6);
    System.out.printf(">>> After add 5, tree: %s\n", t.toString());
    t.add(2);
    System.out.printf(">>> After add 2, tree: %s\n", t.toString());
    t.add(0);
    System.out.printf(">>> After add 0, tree: %s\n", t.toString());

    pln("");
    pln("-- remove --");
    pln(">>> no child case");

    pln("Remove " + t.remove(0).getValue());
    System.out.printf(">>> After remove 0, tree: %s\n", t.toString());
    pln(">>> XOR case");
    pln("Remove " + t.remove(1).getValue());
    System.out.printf(">>> After remove 1, tree: %s\n", t.toString());
    pln(">>> successor case");
    pln("Remove " + t.remove(3).getValue());
    System.out.printf(">>> After remove 3, tree: %s\n", t.toString());

    pln("");
    pln("-- balance --");
    System.out.println("Current Tree: " + t.toString());
    pln("Add 10 to make 5 to trigger left rotation");
    t.add(10);
    pln(">>> After add 10, tree: " + t.toString());
    pln("Add 1, 0 to 2 to trigger right rotation");
    t.add(1);
    t.add(0);
    pln(">>> After add 1, 0, tree: " + t.toString());
    pln("Add 7, 9 to trigger left-right rotation");
    t.add(7);
    pln(">>> After add 7, tree: " + t.toString());
    t.add(9);
    pln(">>> After add 9, tree: " + t.toString());
    pln(">>> Add 13, 11 to trigger right left rotation");
    t.add(13);
    pln(">>> After add 13, tree: " + t.toString());
    t.add(11);
    pln(">>> After add 11, tree: " + t.toString());
  }

  public static void pln(String str) {
    System.out.println(str);
  }

}
