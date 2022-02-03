import java.util.NoSuchElementException;
import java.util.ArrayList;
/*
 * Your implementation of a BST.
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the data to the tree.
     *
     * This must be done recursively.
     *
     * The new data should become a leaf in the tree.
     *
     * Traverse the tree to find the appropriate location. If the data is
     * already in the tree, then nothing should be done (the duplicate
     * shouldn't get added, and size should not be incremented).
     *
     * Should be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to add to the tree.
     * @throws java.lang.IllegalArgumentException If data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
      if (data == null) {
        throw new IllegalArgumentException();
      }
      root = rAdd(root, data);
    }

    private BSTNode<T> rAdd(BSTNode<T> curr, T data) {
      if (curr == null) { // if leaf, add node
        size++;
        return new BSTNode(data);
      }
      else if (data.compareTo(curr.getData()) < 0) { // if curr < data, check left
        curr.setLeft(rAdd(curr.getLeft(), data));
      } else if (data.compareTo(curr.getData()) > 0) { // if curr > data, check right
        curr.setRight(rAdd(curr.getRight(), data));
      } else if (curr.getData() == data) { ; } // if curr == data, do nothing

      return curr;
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the SUCCESSOR to
     * replace the data. You should use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove.
     * @return The data that was removed.
     * @throws java.lang.IllegalArgumentException If data is null.
     * @throws java.util.NoSuchElementException   If the data is not in the tree.
     */
    public T remove(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
      if (data == null) {
        throw new IllegalArgumentException();
      }

      BSTNode<T> dummy = new BSTNode<>(null);
      this.root = rRemove(root, data, dummy);
      return dummy.getData();
    }

    private BSTNode rRemove(BSTNode<T> curr, T data, BSTNode<T> dum) {
      if (curr == null) {
        throw new NoSuchElementException();
      }

      T cData = curr.getData();

      if (data.compareTo(cData) > 0) {
        curr.setRight(rRemove(curr.getRight(), data, dum));
      } else if (data.compareTo(cData) < 0) {
        curr.setLeft(rRemove(curr.getLeft(), data, dum));
      } else {
        dum.setData(curr.getData());

        BSTNode<T> dum2 = new BSTNode<>(null);
        if (curr.getRight() == null) {
          curr.setLeft(removePredecessor(curr.getLeft(), dum2));
        } else {
          curr.setRight(removeSuccessor(curr.getRight(), dum2));
        }

        if (dum2.getData() == null) {
          curr = null;
        } else {
          curr.setData(dum2.getData());
        }
        size--;
      }

      return curr;
    }

    private BSTNode removeSuccessor(BSTNode<T> right, BSTNode<T> dum) {
      if (right == null) {
        return right;
      } else if (right.getLeft() == null) {
        dum.setData(right.getData());
        return right.getRight();
      }
      right.setLeft(removeSuccessor(right.getLeft(), dum));
      return right;
    }

  private BSTNode removePredecessor(BSTNode<T> left, BSTNode<T> dum) {
    if (left == null) {
      return left;
    } else if (left.getRight() == null) {
      dum.setData(left.getData());
      return left.getLeft();
    }
    left.setRight(removeSuccessor(left.getRight(), dum));
    return left;
  }

  
    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    //public String toString() {
      //String outStr = "[ ";
      
      //ArrayList<BSTNode> q = new ArrayList<>();
      //q.add(this.root);
      //while (!q.isEmpty()) {
        //BSTNode<T> curr = q.remove(0);
        //if (curr != null) {
          //outStr += (curr.getData() + " ");
          //q.add(curr.getLeft());
          //q.add(curr.getRight());
        //}
      //}

      //outStr += "]";
      //outStr += " size: " + size;

      //return outStr;
    //}

}
