import java.util.NoSuchElementException;
// IllegalArgumentException is part of java.lang

public class LinkedList<T> implements List<T> {
  private Node<T> head;
  private Node<T> tail;
  private int size;

  public LinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }
  
  public Node<T> getHead() {
    return this.head;
  }

  public Node<T> getTail() {
    return this.tail;
  }

  public void addAtIndex(T data, int index) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("Your index is out of list bounds");
    } else if (data == null) {
      throw new IllegalArgumentException("You cannot add null data to the list");
    }

    Node<T> current = head;
    
    if (index == 0) {
      current = new Node<T>(data, current);
      head = current;
    } else {
      for (int i = 1; i < index; i++) {
        current = current.getNext();
      }
      
      current.setNext(new Node<T>(data, current.getNext()));
    }

    if (index == size) {
      tail = current.getNext();
    }
    size++;

  }

  public T getAtIndex(int index) {
    if (index < 0 || index > (size - 1)) {
      throw new IllegalArgumentException("Your index is out of list bounds");
    } 
    Node<T> current = head;

    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }

    return current.getData();
  }

  public T removeAtIndex(int index) {
    if (index < 0 || index > (size - 1)) {
      throw new IllegalArgumentException("Your index is out of bounds");
    } 
    
    Node<T> current = head;
    Node<T> prev = null;

    if (index == 0) {
      head = current.getNext();
    } else {
      for (int i = 0; i < index; i++) {
        prev = current;
        current = current.getNext();
      }

      prev.setNext(current.getNext());
    }

    size--;
    if (index == size) {
      tail = prev;
    }

    return current.getData();
  }

  public T remove(T data) {
    if (data == null) {
      throw new IllegalArgumentException("You cannot remove null data from the list");
    } else if (isEmpty()) {
      throw new  NoSuchElementException("The data is not present in the list");
    }

    boolean found = false;
    Node<T> current = head;
    int ind = 0;

    while(!found) {
      T currData = current.getData();
      if(data.equals(currData)) {
        break;
      } else if (currData == null) {
        throw new NoSuchElementException("The data is not present in the list");
      }
      current = current.getNext();
      ind++;
    }

   return removeAtIndex(ind); 
  }

  public void clear() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public boolean isEmpty() {
    return (head == null && tail == null && size == 0);
  }

  public int size() {
    return size; 
  }
  
  public static void main(String[] args) {
    LinkedList<String> playlist = new LinkedList<>();
    playlist.addAtIndex("hello", 0);
    System.out.println(playlist.getAtIndex(0));
    System.out.println(playlist.getTail());
    playlist.addAtIndex("there", 1);
    System.out.println(playlist.getHead().getData());
    System.out.println(playlist.getTail().getData());
    playlist.addAtIndex("hey", 0);
    System.out.println(playlist.getAtIndex(0));
    System.out.println(playlist.getAtIndex(1));
    System.out.println(playlist.getAtIndex(2));
    System.out.println("removed: " + playlist.removeAtIndex(1));
    System.out.println(playlist.getHead().getData());
    System.out.println(playlist.getTail().getData());
    System.out.println(playlist.remove("there"));
    System.out.println(playlist.getHead().getData());
    System.out.println(playlist.getTail().getData());
    playlist.addAtIndex("tada", 1);
    playlist.addAtIndex("yada", 2);
    System.out.println(playlist.removeAtIndex(0));
    System.out.println(playlist.getHead().getData());
    System.out.println(playlist.getTail().getData());
  }

}
