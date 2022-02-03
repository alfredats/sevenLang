Lines in FileTest.java containing a:
0: import java.io.File;
1: import java.io.FileNotFoundException;
2: import java.util.Scanner;
3: import java.io.PrintWriter;
5: public class FileTest {
6:   public static void main(String[] args) {
7:     String inputFileName = args[0];
8:     String word = args[1];
10:     File fileIn = new File(inputFileName);
11:     File fileOut = new File(word + "In"+inputFileName);
13:     Scanner fileScan = null;
17:       fileScan = new Scanner(fileIn);
20:       filePrint.printf("Lines in %s containing %s:\n",
21:           args[0], args[1]);
23:       while (fileScan.hasNextLine()) {
24:         String line = fileScan.nextLine();
25:         if (line.contains(word)) {
30:     } catch (FileNotFoundException e) {
31:       System.out.println(e.getMessage());
33:     finally {
34:       if (fileScan != null) {
35:         fileScan.close();
43:   // suppose now we didn't wanna explicitly catch the error and want  
44:   // some downstream method to call this one
45:   public static void calledByOther(String[] args) 
46:      // here we are declaring that the method might throw an exception
48:     String inputFname = args[0];
49:     String word = args[1];
51:     File fileIn = new File(inputFname);
52:     File fileOut = new File(word + "In" + inputFname);
54:     Scanner scan = null;
56:     scan = new Scanner(fileIn);
58:     System.out.printf("Lines in %s containing %s:\n", args[0], args[1]);
60:     while (scan.hasNextLine()) {
61:       String line = scan.nextLine();
62:       if (line.contains(word)) {
67:     scan.close();
