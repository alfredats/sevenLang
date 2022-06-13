import java.util.LinkedList;

public class AvlTree<T extends Comparable<T>> {
  private AvlNode<T> root;
  
  public void setRoot(AvlNode<T> root) { this.root = root; }
  public AvlNode<T> getRoot() { return this.root; }

  public boolean isBalanced() {
    if (Math.abs(this.root.getBalanceFactor()) < 2) { return true; }
    return false;
  }

  public AvlNode<T> search(T value) {
    return this.rFind(value, this.getRoot());
  }

  private AvlNode<T> rFind(T value, AvlNode<T> node) {
    if (null == value) { return null; } 
    Integer dir = value.compareTo(node.getValue());
    if (dir < 0) { return rFind(value, node.getLeft()); }
    if (dir > 0) { return rFind(value, node.getRight()); }
    return node;
  }

  public AvlTree<T> add(T value) {
    this.rAdd(value, this.getRoot());
    return this;
  }

  /**
   * This tree doesn't handle duplicate values
   **/ 
  private AvlNode<T> rAdd(
    T value, 
    AvlNode<T> node 
  ) {
    if (null == node) { return new AvlNode<T>(value); }
    Integer dir = value.compareTo(node.getValue());
    if (dir < 0) { 
      node.setLeft(rAdd(value, node.getLeft())); 
    } else if (dir > 0) { 
      node.setRight(rAdd(value, node.getRight())); 
    }
    return node;
  }

  public AvlNode<T> delete(T value) {
    return null;
  }

  public String toString() {
    String outStr = "[ ";
    LinkedList<AvlNode<T>> q = new LinkedList<>();      
    q.add(this.getRoot());
    while (null != q.peek()) {
      AvlNode<T> n = q.remove();
      outStr += n.toString() + ", ";
      if (null != n.getLeft()) { q.add(n.getLeft()); }
      if (null != n.getRight()) { q.add(n.getRight()); }
    }
    return outStr + "]";
  }

  public AvlNode<T> remove(T value) {
    AvlNode<T> dummy = new AvlNode<>();
    this.rRemove(value, this.getRoot(), dummy);
    return dummy;
  }

  private AvlNode<T> rRemove(
    T value, 
    AvlNode<T> node,
    AvlNode<T> dummy
  ) {
    if (null == node) { return null; }
    Integer dir = value.compareTo(node.getValue());
    if (dir < 0) { 
      node.setLeft(this.rRemove(value, node.getLeft(), dummy)); 
    } else if (dir > 0) { 
      node.setRight(this.rRemove(value, node.getRight(), dummy));
    } else {
    // node found -> 3 cases
      dummy = node;

      AvlNode<T> lc = node.getLeft();
      AvlNode<T> rc = node.getRight();
      if (null == lc && null == rc) {
        node = null;
      } else {
        if (null != lc ^ null != rc) {
        node = (null == lc) ? rc : lc;
        } else {
          AvlNode<T> dummy2 = new AvlNode<>();
          node.setRight(this.removeSuccessor(node.getRight(), dummy2));
          node.setValue(dummy2.getValue());
          node.update();
        }
      }
    }
    return node;
  }

  private AvlNode<T> removeSuccessor(
    AvlNode<T> node, 
    AvlNode<T> dummy2
  ) {
    AvlNode<T> lc = node.getLeft();
    AvlNode<T> rc = node.getRight();

    if (null == lc) {
      dummy2.setValue(node.getValue());
      return node.getRight();
    } 
    node.setLeft(this.removeSuccessor(node.getLeft(), dummy2));
    return node;
  }
}

