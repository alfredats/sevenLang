public class CLI_Averager {
  public static void main(String[] args) {
    double cumsum = 0;

    for (int i = 0; i < args.length; i++) {
      cumsum += Double.parseDouble(args[i]);
    }
    double avg = (args.length > 0) ? (cumsum/args.length) : 0;
    System.out.printf("Average is %.2f\n", avg);
  }
}
