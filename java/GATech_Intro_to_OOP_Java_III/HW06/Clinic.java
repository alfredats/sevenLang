import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Clinic {
  private File patientFile;
  private int day;

  public Clinic(File file) {
    this.patientFile = file;
    this.day = 1;
  }

  public Clinic(String fileName) {
    this(new File(fileName));
  }

  public int getDay() {
    return day;
  }

  public void setDay(int d) {
    this.day = d;
  }


  public String nextDay(File f) throws FileNotFoundException {
    Scanner scan = new Scanner(f);
    Scanner userIn = new Scanner(System.in); // Multiple scanner objects, might cause issue with Vocareum
    String apptStrs = "";

    while(scan.hasNextLine()) {

      String line = scan.nextLine();
      String[] deets = line.split(",");
      if (!deets[1].equals("Cat") && !deets[1].equals("Dog")) {
        throw new InvalidPetException();
      }

      boolean succ = false;
      double inHealth = -1.0;
      while(!succ) {
        try {
          System.out.printf("Consultation for %s the %s at %s.\nWhat is the health of %s?\n",
            deets[0], deets[1], deets[3], deets[0]);
          inHealth = userIn.nextDouble(); 
          succ = true;
        } catch (Exception e) {System.out.println("Please enter a number");}
        finally {
          userIn.nextLine();
        }
      } 
        
      succ = false;
      int inPainLevel = -1;
      while(!succ) {
        try {
          System.out.printf("On a scale of 1 to 10, how much pain is %s in right now?\n",
            deets[0]);
          inPainLevel = userIn.nextInt(); 
          succ = true;
        } catch (Exception e) {System.out.println("Please enter a number");}
        finally {
          userIn.nextLine();
        }
      } 


      String apptDeets = "";
      int minsTaken = 0;
      if (deets[1].equals("Cat")) {
        int mc = Integer.parseInt(deets[2]);
        Cat c = new Cat(deets[0], inHealth, inPainLevel, mc);
        c.speak();
        minsTaken = c.treat();
        apptDeets = String.format("%s,%s,%s,Day %d,%s,%s,%.1f,%d\n", 
              deets[0],       // NAME
              deets[1],       // Species
              deets[2],       // Mice Caught
              getDay(),       // day
              deets[3],       // Entry Time
              addTime(deets[3], minsTaken), //Exit Time
              inHealth,       // Initial Health
              inPainLevel);   // initial pain level
      } else if (deets[1].equals("Dog")) {
        double dl = Double.parseDouble(deets[2]);
        Dog d = new Dog(deets[0], inHealth, inPainLevel, dl);
        d.speak();
        minsTaken = d.treat();
        apptDeets = String.format("%s,%s,%s,Day %d,%s,%s,%.1f,%d\n", 
              deets[0],       // NAME
              deets[1],       // Species
              deets[2],       // DroolRate 
              getDay(),       // day
              deets[3],       // Entry Time
              addTime(deets[3], minsTaken), //Exit Time
              inHealth,       // Initial Health
              inPainLevel);   // initial pain level
      }

      apptStrs += apptDeets;

    }

    setDay(getDay() + 1); 
    scan.close(); userIn.close(); 
    return apptStrs;
  }

  public String nextDay(String fileName) throws FileNotFoundException {
    return this.nextDay(new File(fileName));
  }

  public boolean addToFile(String patientInfo) {
    String[] pDeets = patientInfo.split(",");
    Scanner fScan = null; 
    String cumLine = "";

    try {
      fScan = new Scanner(patientFile);

      boolean patInFile = false;
      while (fScan.hasNextLine()) {
        String line = fScan.nextLine();
        String[] lDeets = line.split(",");

        if (lDeets[0].equals(pDeets[0])) {
          line = line + String.format(",%s,%s,%s,%s,%s",
              pDeets[3], pDeets[4], pDeets[5], pDeets[6], pDeets[7]);
          patInFile = true;
        } 
        cumLine = cumLine + line + "\n";
      }
      cumLine = (patInFile) ? cumLine : (cumLine + patientInfo);

    } catch (FileNotFoundException | NullPointerException e) {
      return false;
    } finally {
      fScan.close();
    }

    PrintWriter fPrint = null; 

    try {
      fPrint = new PrintWriter(patientFile);
      fPrint.println(cumLine);
    } catch (FileNotFoundException | NullPointerException e) {
      return false;
    } finally {
      fPrint.close();
    }

    return true;
  }

  private static String addTime(String timeIn, int treatmentTime) {
    int parsed = Integer.parseInt(timeIn);
    int hours = parsed / 100;
    int mins = parsed % 100;

    mins = mins + treatmentTime;
    hours = (mins > 60) ? hours + (mins/60) : hours;
    mins = mins % 60;


    return String.format("%02d%02d",hours, mins);      
  }

  //public static void main(String[] args) {
    //Clinic c = new Clinic("Appointments.csv");
    //try {
      //c.nextDay("Appointments.csv");
    //} catch (FileNotFoundException e) {
      //System.out.println("File not found: " + e);
    //}
  //}
}
