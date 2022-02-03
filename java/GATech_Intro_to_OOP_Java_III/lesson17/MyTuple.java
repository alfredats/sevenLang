public class MyTuple<T1,T2> {
  private T1 content1;
  private T2 content2;

  public MyTuple(T1 c1, T2 c2) {
    this.content1 = c1;
    this.content2 = c2;
  }
  
  public T1 getContent1() {
    return this.content1;
  }

  public T2 getContent2() {
    return this.content2;
  }

  public void setContent1(T1 c1) {
    this.content1 = c1;
  }

  public void setContent2(T2 c2) {
    this.content2 = c2;
  }

  public static void main(String[] args) {
    MyTuple<Integer, String> tup = new MyTuple<>(1, "hello");
    System.out.println("" + tup.getContent1() + ", " + tup.getContent2());
  }

}
