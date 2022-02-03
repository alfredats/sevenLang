import java.util.List;
import java.util.Arrays;

public class TraversalsTest {
  public static void main(String[] args) {
    TreeNode<Integer> root = new TreeNode<>(5);
    
    TreeNode<Integer> leftSub = new TreeNode<>(4);
    TreeNode<Integer> rightSub = new TreeNode<>(7);

    TreeNode<Integer> leftleftSub = new TreeNode<>(1);
    TreeNode<Integer> rightrightSub = new TreeNode<>(9);

    TreeNode<Integer> leftleftleftSub = new TreeNode<>(0);
    TreeNode<Integer> leftleftrightSub = new TreeNode<>(2);
    TreeNode<Integer> rightrightleftSub = new TreeNode<>(8);


    leftleftSub.setLeft(leftleftleftSub);
    leftleftSub.setRight(leftleftrightSub);
    rightrightSub.setLeft(rightrightleftSub);

    leftSub.setLeft(leftleftSub);
    rightSub.setRight(rightrightSub);

    root.setLeft(leftSub);
    root.setRight(rightSub);

    Traversals<Integer> x = new Traversals<>();

    List<Integer> preord = x.preorder(root);
    System.out.println(Arrays.toString(preord.toArray()));

    List<Integer> preordnull = x.preorder(null);
    System.out.println(Arrays.toString(preordnull.toArray()));

    List<Integer> postord = x.postorder(root);
    System.out.println(Arrays.toString(postord.toArray()));

    List<Integer> postordnull = x.postorder(null);
    System.out.println(Arrays.toString(postordnull.toArray()));

    List<Integer> inord = x.inorder(root);
    System.out.println(Arrays.toString(inord.toArray()));

    List<Integer> inordnull = x.inorder(null);
    System.out.println(Arrays.toString(inordnull.toArray()));
  }
}
