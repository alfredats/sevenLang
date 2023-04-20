import java.util.NoSuchElementException;

/**
 * Your implementation of a MinHeap.
 */
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

     /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new MinHeap.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MinHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    //public MinHeap(T[] inArr) {
      //this();
      //size = inArr.length;
      //for (int i = 0; i < size; i++) {
        //backingArray[i+1] = inArr[i];
      //}
    //}

    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     *
     * Method should run in amortized O(log n) time.
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If the data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
          throw new IllegalArgumentException();
        }
        if (size + 1 >= backingArray.length) {
          T[] newBA = (T[]) new Comparable[backingArray.length * 2];
          for (int i = 1; i <= size; i++) {
            newBA[i] = backingArray[i];
          }
          backingArray = newBA;
        }

        size++;
        backingArray[size] = data;
        
        upheap(size);
        return;
    }

    private void upheap(Integer ind) {
      if (ind == 1) {
        return;
      }
      Integer parentInd = ind / 2;
      if (backingArray[parentInd].compareTo(backingArray[ind]) > 0) {
        T temp = backingArray[parentInd];
        backingArray[parentInd] = backingArray[ind];
        backingArray[ind] = temp;
      }
      
      upheap(parentInd);
      return;
    }

    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * Method should run in O(log n) time.
     *
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the heap is empty.
     */
    public T remove() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
      T dummy = backingArray[1];
      if (dummy == null) {
        throw new NoSuchElementException();
      }
      
      backingArray[1] = backingArray[size];
      backingArray[size] = null;
      size--;
      downheap(1);

      return dummy;
    }

    private void downheap(Integer ind) {

      if (backingArray[ind] == null || ind > (size/2)) {
        return;
      } 

      Integer swpInd;
      Integer lc = ind * 2;
      Integer rc = 1 + (ind * 2);

      if (backingArray[rc] == null) {
        swpInd = lc;
      } else {
        swpInd = (backingArray[rc].compareTo(backingArray[lc]) < 0) ? rc : lc;
      }
      
      if (backingArray[swpInd].compareTo(backingArray[ind]) < 0) {
        T foo = backingArray[ind];
        backingArray[ind] = backingArray[swpInd];
        backingArray[swpInd] = foo;

        downheap(swpInd);
      } 

      return;
      
    }


    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}
