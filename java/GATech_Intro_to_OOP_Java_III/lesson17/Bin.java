public class Bin<T> {
  private T content;
  
  public Bin(T content) {
    this.content = content;
  }

  public T getContent() {
    return this.content;
  }

  public void setContent(T content) {
    this.content = content;
  }
  
  public static void main(String[] args) {
    Bin<String> playlist = new Bin<>("34+35");
    playlist.setContent("Stacy's Mom");
    System.out.println(playlist.getContent());
  }
}
