public class Fly {
  private double mass;
  private double speed;

  private static final double DEFAULT_MASS = 5;
  private static final double DEFAULT_SPEED = 10;


  public Fly() {
    this(DEFAULT_MASS, DEFAULT_SPEED);
  }

  public Fly(double mass) {
    this(mass, DEFAULT_SPEED);
  }

  public Fly(double mass, double speed) {
    this.mass = mass;
    this.speed = speed;
  }

  public String toString() {
    if (mass <= 0) {
      return String.format("I'm dead, but I used to be a fly with speed of %.2f.", speed);
    }
    return String.format("I'm a speedy fly with %.2f speed and %.2f mass.", speed, mass);
  }

  public double getMass() {
    return mass; 
  }

  public double getSpeed() {
    return speed;
  }
  
  public void setMass(double mass) {
    this.mass = mass;
  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }

  public void grow(int growMass) {
    for (int i = 0; i < growMass; i++) {
      if (mass < 20) {
        speed++;
      }
      else {
        speed -= 0.5;
      }
      mass++;
    }
  }

  public boolean isDead() {
    return (mass <= 0);
  }




}
