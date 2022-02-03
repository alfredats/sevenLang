import java.util.Iterator;

public class LinkedList<T extends Comparable<T>> implements Iterable<T> {
  private Node<T> head;

  public LinkedList() {}
  public LinkedList(Node<T> node) {
      this.head = node;
  }
  public LinkedList(Node<T> node, LinkedList<T> ll) {
    if (ll.head != null) { node.next = ll.head; }
    this.head=node;
  }


  public void addToFront(T data) {
    Node<T> newNode = new Node<>(data);
    newNode.next = head;
    head = newNode;
  }

  public Node<T> get(int ind) {
    if (ind < 0) {
      return null;
    } else {
      Node<T> curr = head;
      int cnt = 0;
      while (cnt < ind) {
        if (curr.next == null) { return null; }
        curr = curr.next;
        cnt++;
      }
      return curr;
    }
  }

  public void addToBack(T data) {
    if (head == null) {
      head = new Node<T>(data);
    } else {
      Node current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = new Node<T>(data);
    }
  }
  
  public void removeFromFront() {
    if (head == null) { ; }
    head = head.next;
  }

  public void removeFromBack() {
    if (head == null) { ; }
    else if (head.next == null) { head = null; }
    else {
      Node<T> curr = head;
      while(curr.next.next != null) {
        curr = curr.next;
      }
      curr.next = null;
    }
  }

  public String toString() {
    String answer = "";
    Node current = head;

    while (current != null) {
      answer += current.toString() + " ";
      current = current.next;
    }
    return answer;
  }

  public void removeDuplicates() {
    head = rRemove(head);
  }

  private Node<T> rRemove(Node<T> curr) {
    if (curr == null) {
      return null;
    }
    curr.next = rRemove(curr.next);
    if (curr.next != null && curr.data.equals(curr.next.data)) {
      return curr.next;
    }
    return curr;
  }

  public Iterator<T> iterator() {
    return new LLIterator();
  }


  // Private classes for internal use
  private class Node<T> {
    private Node<T> next;
    private T data;

    public Node(T data, Node<T> next) {
      this.data = data;
      this.next = next;
    }

    public Node(T data) {
      this(data, null); 
    }

    public String toString() { return data.toString(); }
  }

  private class LLIterator implements Iterator<T> {
    private Node<T> curr;
    
    public LLIterator() { curr = head;}

    public boolean hasNext() { return curr != null; }
    
    public T next() {
      if (hasNext()) {
        T temp = curr.data;
        curr = curr.next;
        return temp;
      }
      return null;
    }
  }
}
