public class GenericLinkedList<E> {
  private class Node<E> { // Inner class 
    E data;
    Node<E> next;

    Node(E data, Node<E> next) {
      this.data = data;
      this.next = next;
    }
  }

  private Node<E> head; 

  public GenericLinkedList() {
    head = null; // starts off empty
  }

  public boolean isEmpty() {
    return (head == null);
  }

  public void addToFront(E newData) {
    head = new Node<E>(newData, head);
  }

  public void addToRear(E newData) {
    Node<E> node = new Node<>(newData, null);
    Node<E> current = head;
    if (isEmpty()) {
      head = node;
    } else {
      while(current.next != null) {
        current = current.next;
      }
      current.next = node;
    }
  }

  public String toString() {
    Node<E> current = head;
    String result = "";

    while (current != null) {
      result = result + current.data.toString() + "\n";
      current = current.next;
    }
    return result;
  }

  public boolean contains(E target) {
    if (isEmpty()) {
      return false;
    }

    boolean found = false;
    Node<E> current = head;

    while (current != null && !found) {
      if (target.equals(current.data)) {
        return true;
      } else {
        current = current.next;
      }
    }
    return found;
  }

  public E get(int ind) {
    if (isEmpty()) {
      return null;
    } 
    
    Node<E> current = head;

    for (int i = 0; i < ind; i++) {
      current = current.next;
    }

    return current.data;
  }

  public E removeFromFront() {
    if (isEmpty()) {
      return null;
    }
    Node<E> current = head;
    head = current.next;
    return current.data;
  }

  public E removeFromRear() {
    if (isEmpty()) {
      return null;
    }

    Node<E> current = head;
    Node<E> prev = current;
    while (current.next != null) {
      prev = current;
      current = current.next;
    }
    prev.next = null;
    return current.data;
  }

  public static void main(String[] args) {
    GenericLinkedList<String> favBabySongs = new GenericLinkedList<>();
    favBabySongs.addToFront("Humpty Dumpty");
    favBabySongs.addToFront("Itsy Bitsy Spider");
    favBabySongs.addToFront("Twinkle, Twinkle Little Star");
    favBabySongs.addToFront("Wheels on the Bus");
    System.out.println(favBabySongs.toString());
    System.out.println(favBabySongs.contains("Humpty Dumpty"));
    System.out.println(favBabySongs.contains("Baby Shark"));
    System.out.println("Get index 0: " + favBabySongs.get(0));
    System.out.println("Get index 1: " + favBabySongs.get(1));
    System.out.println("Removed first item: " + favBabySongs.removeFromFront());
    System.out.println("Removed last item: " + favBabySongs.removeFromRear());
    System.out.println("New playlist: \n" + favBabySongs.toString());
  }
}
