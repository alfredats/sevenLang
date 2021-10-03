import java.util.*;
import java.io.*;

public class Battleship {
	public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      game(input);
    }

//Running: test_battleship_prompt
//Testing starting prompts to the user
//Failed: Your Battleship prompt is formatted incorrectly. Please check the homework .pdf
//Finished: test_battleship_prompt


//Running: alreadyUsedCoordinateForInput
//Inputting already entered ship coordinates for input
//Failed: Doesnt correctly handle the scenario when a user inputs a coordinate thats already taken by another ship.Please check the homework .pdf
//Finished: alreadyUsedCoordinateForInput    


  //static char[][] fullMisses= {
  //{'O', 'O', 'O', 'O', 'O'},
  //{'O', 'O', 'O', 'O', 'O'},
  //{'O', 'O', 'O', 'O', 'O'},
  //{'O', 'O', 'O', 'O', 'O'},
  //{'O', 'O', 'O', 'O', 'O'},
  //};

  //static char[][] fullHits = {
  //{'X', 'X', 'X', 'X', 'X'},
  //{'X', 'X', 'X', 'X', 'X'},
  //{'X', 'X', 'X', 'X', 'X'},
  //{'X', 'X', 'X', 'X', 'X'},
  //{'X', 'X', 'X', 'X', 'X'},
  //};

  //static char[][] utHits = {
  //{'X', 'X', 'X', 'X', 'X'},
  //{'-', 'X', 'X', 'X', 'X'},
  //{'-', '-', 'X', 'X', 'X'},
  //{'-', '-', '-', 'X', 'X'},
  //{'-', '-', '-', '-', 'X'},
  //};

  //static char[][] ltMisses = {
  //{'O', '-', '-', '-', '-'},
  //{'O', 'O', '-', '-', '-'},
  //{'O', 'O', 'O', '-', '-'},
  //{'O', 'O', 'O', 'O', '-'},
  //{'O', 'O', 'O', 'O', 'O'},
  //};

  public static void game(Scanner scan) {
    System.out.println("Welcome to Battleship!");
    System.out.println();
    System.out.println("PLAYER 1, ENTER YOUR SHIPS' COORDINATES.");
    char[][] p1Ships= initPlayerBoard(scan);
    clearScreen();
    System.out.println("PlAYER 2, ENTER YOUR SHIPS' COORDINATES.");
    char[][] p2Ships = initPlayerBoard(scan);
    clearScreen();


    boolean p1Turn = true;
    char[][] p1Hits = initBoard();
    char[][] p2Hits = initBoard();
    while (true) {
      if (winConds(p1Ships, p2Ships, p1Hits, p2Hits)) {
        break;
      }
      char[][] cShips = p1Turn ? p2Ships : p1Ships;
      char[][] cHits = p1Turn ? p1Hits : p2Hits;
      hitShip(scan, p1Turn, cShips, cHits);
      System.out.println();

      p1Turn = !p1Turn;
    } 
  }


    // Use this method to print game boards to the console.
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
	}

  private static void clearScreen() {
    for (int i = 0; i < 99; i++) {
      System.out.println();
    }
  }

  private static boolean validHit(char[][] board, int r, int c) {
    return (board[r][c] != '-');
  }
  
  private static boolean validCoords(int x, int y) {
    boolean isValid = ((x > -1) && (x < 5) && (y > -1) && (y < 5));
    return isValid;
  }

  private static int[] askCoords(Scanner scan, String prompt) {
    // 1) ask user for input of x & y coords of ship/hit
    //    1a) if coords not valid, print error message
    //    1b) re-question
    int x = -1;
    int y = -1;
    int[] ret = {x,y};

    while (!validCoords(x,y)) {
      System.out.println(prompt);
      x = scan.nextInt();
      y = scan.nextInt();
      if (validCoords(x,y)) {
        ret[0] = x; ret[1] = y;
        break;
      }
       
      System.out.println("Invalid coordinates. Choose different coordinates.");
    } 

    return ret;
  }

  private static char[][] initBoard() {
    char[][] emptyBoard = {
    {'-', '-', '-', '-', '-'},
    {'-', '-', '-', '-', '-'},
    {'-', '-', '-', '-', '-'},
    {'-', '-', '-', '-', '-'},
    {'-', '-', '-', '-', '-'},
    };
    return emptyBoard; 
  }


  // Initialize board with x number of battleship positions
  private static char[][] initPlayerBoard(Scanner scan) {
    final int num_battleships = 5;

    // 1) init empty board
    char[][] playerBoard = initBoard();
   
    // 2) ask user for positions
    int initShips = 0;
    do {
      String prompt = "Enter ship " + (initShips + 1) + " location:";

    //    2a) if position invalid, print "Invalid coordinates. Choose different coordinates."
      int[] shipLoc = askCoords(scan, prompt);
      if (validHit(playerBoard, shipLoc[0], shipLoc[1])) {
    //    2b) if position already contains ship, print "You already have a ship there. Choose different coordinates."
        System.out.println("You already have a ship there. Choose different coordinates.");
      }
      else {
        playerBoard[shipLoc[0]][shipLoc[1]] = '@';
        initShips++;
      }
    } while(initShips < num_battleships);

    // 3) print board when user locks in all battleships
    printBattleShip(playerBoard);
    return playerBoard;
  }



  // This method is used for updating the boards while game is in progress
  // - handles printing of hit/non-hit status
  private static void hitShip(Scanner scan, boolean turnP1, char[][] enemyBoard, char[][] prevHits) {
    do {
      String aggressor = turnP1 ? "1" : "2";
      String defender = turnP1 ? "2" : "1";

      String prompt = "Player " + aggressor + ", enter hit row/column:";
      int[] hitLoc = askCoords(scan, prompt);
      if (validHit(prevHits, hitLoc[0], hitLoc[1])) {
        System.out.println("You already fired on this spot. Choose different coordinates.");
      }
      else if (validHit(enemyBoard, hitLoc[0], hitLoc[1])) {
        System.out.println("PLAYER " + aggressor + " HIT PLAYER " + defender + "\'s SHIP!");
        enemyBoard[hitLoc[0]][hitLoc[1]] = 'X';
        prevHits[hitLoc[0]][hitLoc[1]] = 'X';
        break;
      }
      else {
        System.out.println("PLAYER " + aggressor + " MISSED!");
        enemyBoard[hitLoc[0]][hitLoc[1]] = 'O';
        prevHits[hitLoc[0]][hitLoc[1]] = 'O';
        break;
      }
    } while(true);
    printBattleShip(prevHits);
  }
 
  private static boolean winConds(char[][] shipsP1, char[][] shipsP2, char[][] hitsP1, char[][] hitsP2) {
    boolean p1Win = true;
    boolean p2Win = true;

    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (shipsP1[i][j] == '@') {
          p2Win = false;
        }
        if (shipsP2[i][j] == '@') {
          p1Win = false;
        }
      }
    }
    
    if (p1Win) {
      System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT\'S SHIPS!\n");
      printFinals(shipsP1, shipsP2);
      return true;
    }
    else if (p2Win) {
      System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT\'S SHIPS!\n");
      printFinals(shipsP1, shipsP2);
      return true;
    }
    return false;
  }

  private static void printFinals(char[][] sp1, char[][] sp2) {
    System.out.println("Final boards:\n");
    printBattleShip(sp1);
    System.out.println();
    printBattleShip(sp2);
  }
}
