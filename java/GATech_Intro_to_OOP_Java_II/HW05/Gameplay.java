public class Gameplay {
  public static void main(String[] args) {
    BlueAstronaut ba1 = new BlueAstronaut("Bob", 20, 6, 30);
    BlueAstronaut ba2 = new BlueAstronaut("Heath", 30, 3, 21);
    BlueAstronaut ba3 = new BlueAstronaut("Albert", 44, 2, 0);
    BlueAstronaut ba4 = new BlueAstronaut("Angel", 0, 1, 0);

    RedAstronaut ra1 = new RedAstronaut("Liam", 19, "experienced");
    RedAstronaut ra2 = new RedAstronaut("Suspicious Person", 100, "expert");


    ra1.sabotage(ba1);

    ra1.sabotage(ra2);

    ra1.freeze(ba3);

    ba3.emergencyMeeting();
    ra2.emergencyMeeting();

    ba1.emergencyMeeting();

    ba2.completeTask();
    ba2.completeTask();

    ra1.freeze(ba4);

    ra1.sabotage(ba1);
    ra1.sabotage(ba1);

    ra1.freeze(ba1);

    //ba4.emergencyMeeting();
    ra1.sabotage(ba2);
    ra1.sabotage(ba2);
    ra1.sabotage(ba2);
    ra1.sabotage(ba2);
    ra1.sabotage(ba2);
    ra1.freeze(ba2);
  }

}
