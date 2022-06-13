class AvlNode<T extends Comparable> {
  private T value;
  private Integer height;
  private Integer balanceFactor;
  private AvlNode<T> left;
  private AvlNode<T> right;

  private static Integer NULL_CHILD_HEIGHT = -1;

  public AvlNode() {}
  public AvlNode(T value) { this.value = value; this.update(); }
  public AvlNode(T value, AvlNode<T> left, AvlNode<T> right) {
    this.value = value;
    this.update();
  }

  public final AvlNode<T> update() {
    Integer leftHeight = 
      ( null == this.getLeft() ) ? NULL_CHILD_HEIGHT : this.getLeft().getHeight();
    Integer rightHeight = 
      ( null == this.getRight() ) ? NULL_CHILD_HEIGHT : this.getRight().getHeight();
    this.setHeight(Math.max(leftHeight,rightHeight) + 1);
    this.setBalanceFactor(leftHeight - rightHeight);
    return this;
  }

  public void setValue(T value) { this.value = value; }
  public T getValue() { return this.value; }

  public void setHeight(Integer height) { this.height=height; }
  public Integer getHeight() { return this.height; }

  public void setBalanceFactor(Integer balanceFactor) { this.balanceFactor = balanceFactor; }
  public Integer getBalanceFactor() { return this.balanceFactor; }

  public void setLeft(AvlNode<T> left) { this.left = left; this.update(); }
  public AvlNode<T> getLeft() { return this.left; }

  public void setRight(AvlNode<T> right) { this.right = right; this.update(); }
  public AvlNode<T> getRight() { return this.right; }

  public String toString() { return "" + this.getValue() + 
      "(" + this.getHeight() + 
      ", " + this.getBalanceFactor() + 
      ")"; 
  }
}
