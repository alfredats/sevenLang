public class RedAstronaut extends Player implements Impostor {
  private String skill;

  public RedAstronaut(String name, int susLevel, String skill) {
    super(name, susLevel);
    this.skill = skill;
  }

  public RedAstronaut(String name) {
    super(name, 15);
    this.skill = "experienced";
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
      
   if (maxSusPlayer != null && numSus == 1 && !(equals(allPlayers[maxSusInd]))) {
     maxSusPlayer = allPlayers[maxSusInd];
     maxSusPlayer.setFrozen(true);
   }

    gameOver();
  }
  
  public void sabotage(Player p) {
    if (isFrozen() || p.isFrozen() || p instanceof Impostor) {
      return;
    }

    int psl = p.getSusLevel();
    if (getSusLevel() < 20) {
      p.setSusLevel((int)(psl * 1.5));
    } else {
      p.setSusLevel((int)(psl * 1.25));  
    }
  }

  public void freeze(Player p) {
    if (p instanceof Impostor || isFrozen()) {
      return;
    }
    int sl = getSusLevel(); 
    if (sl < p.getSusLevel()) { // freeze success condition
      p.setFrozen(true);
    } else {
      setSusLevel(2 * sl);
    }
    gameOver();
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof RedAstronaut) {
      RedAstronaut ra = (RedAstronaut)o;
      return (ra.getName() == super.getName()         && 
              ra.isFrozen() == super.isFrozen()       && 
              ra.getSusLevel() == super.getSusLevel() && 
              ra.getSkill() == getSkill());
    } 
    return false;
    
  }
  
  public String toString() {
    String out = super.toString() + " I am an " + getSkill() + " player!"; 
    out = (getSusLevel() > 15) ? out.toUpperCase() : out;

    return out;
  }

  // Getters and Setters
  public String getSkill() {
    return skill; 
  }
  
  public void setSkill(String skill) {
    this.skill = skill;
  }

   //test
  public static void main(String[] args) {
    RedAstronaut ra1 = new RedAstronaut("Liam", 19, "experienced");
    RedAstronaut ra2 = new RedAstronaut("Suspicious Person", 100, "expert");
    RedAstronaut ra3 = new RedAstronaut("Not Sus", 1, "inexperienced");

    System.out.println(ra1.toString());
    System.out.println(ra2.toString());
    System.out.println(ra3.toString());
    System.out.println("Equality of RA: ");
    System.out.println("ra1 == ra2: " + ra1.equals(ra2));
    System.out.println("ra1 == ra1: " + ra1.equals(ra1));

    System.out.println("ra2.compareTo(ra1): " + ra2.compareTo(ra1));
    System.out.println("ra1.compareTo(ra2): " + ra1.compareTo(ra2));
    System.out.println("ra1.compareTo(ra1): " + ra1.compareTo(ra1));

  }

}