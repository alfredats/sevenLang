public class BlueAstronaut extends Player implements Crewmate {
  private int numTasks;
  private int taskSpeed;
  
  public BlueAstronaut(String name, int susLevel, 
      int numTasks, int taskSpeed) {
    super(name, susLevel);
    this.numTasks = numTasks;
    this.taskSpeed = taskSpeed;
  }
  
  public BlueAstronaut(String name) {
    super(name, 15);
    this.numTasks = 6;
    this.taskSpeed = 10;
  }

  public void emergencyMeeting() {
    Player[] allPlayers = getPlayers();
    int maxSus = 0;
    int maxSusInd = -1;
    int numSus = 0;
    Player maxSusPlayer = null;

    if (!isFrozen()) {

      for (int i = 0; i < allPlayers.length; i++) {
        int sl = allPlayers[i].getSusLevel();
        if (!allPlayers[i].isFrozen()) {
          if (sl > maxSus) {
          maxSus = sl;
          maxSusInd = i;
          numSus = 1;
          } else if (sl == maxSus) {
          numSus += 1;
          }
        } 
      }
      
      maxSusPlayer = allPlayers[maxSusInd];
    } 
      
   if (maxSusPlayer != null && numSus == 1) {
     maxSusPlayer.setFrozen(true);
   }

    gameOver();
  }

  public void completeTask() {
    if (!isFrozen()) {
      if (getTaskSpeed() > 20) {
        setNumTasks(getNumTasks() - 2);
      } else {
        setNumTasks(getNumTasks() - 1);
      }

      if (getNumTasks() <= 0) {
        setNumTasks(0);
        System.out.println("I have completed all my tasks");
        setSusLevel((int)(0.5 * getSusLevel()));
      }
    }
  };

  public boolean equals(Object o) {
    if (o instanceof BlueAstronaut) {
      BlueAstronaut ba = (BlueAstronaut) o;
      return ba.getName() == getName() && ba.isFrozen() == isFrozen() && 
        ba.getSusLevel() == getSusLevel() && ba.getNumTasks() == numTasks && 
        ba.taskSpeed == taskSpeed;
    }
    return false;
  }

  public String toString() {
    String out = super.toString() + " I have " + getNumTasks() + " left over.";
    out = (getSusLevel() > 15) ? out.toUpperCase() : out;

    return out;
  }

  // Setters and getters
  public int getNumTasks() {
    return numTasks;
  }

  public int getTaskSpeed() {
    return taskSpeed;
  }

  public void setNumTasks(int nt) {
    this.numTasks = nt;
  }

  public void setTaskSpeed(int ts) {
    this.taskSpeed = ts;
  }

  public static void main(String[] args) {
    BlueAstronaut ba1 = new BlueAstronaut("Bob", 20, 6, 30);
    BlueAstronaut ba2 = new BlueAstronaut("Heath", 30, 3, 21);
    BlueAstronaut ba3 = new BlueAstronaut("Albert", 44, 2, 0);
    BlueAstronaut ba4 = new BlueAstronaut("Angel", 0, 1, 0);
    BlueAstronaut ba5 = new BlueAstronaut("Angel", 5, 1, 0);

    System.out.println(ba1);
    System.out.println(ba2);
    System.out.println(ba3);
    System.out.println(ba4);

    System.out.println(ba1.equals(ba2));
    System.out.println(ba1.equals(ba1));
    System.out.println(ba4.equals(ba5));
  }

}
