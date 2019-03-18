import java.util.Scanner;

public class TicTacToe {
	
	public static Scanner inputStream = new Scanner(System.in);
	
	public static void main(String[] args) {
		Player currPlayer = new Player();
		int col;
		int row;
		boolean game = true;
		
		System.out.println("Welcome to **Tic Tac Toe**");
		System.out.println("-------------------------");
		
		
		GameBoard board = new GameBoard();
		board.printBoard();
		
		while(game) {
			System.out.println("Player " + currPlayer.getCurrent() + ", it's your turn!");
			
			do {
			System.out.print("Enter column: "); 
			col = inputStream.nextInt();
			System.out.print("Enter row: ");
			row = inputStream.nextInt();
			System.out.println("");
			}
			while(!validate(col, row, board)); 
			
			board.setValue(row, col, currPlayer);
			board.printBoard();
			
			Player.switchPlayer();
		}
		
		
	}
	
	public static boolean validate(int colInput, int rowInput, GameBoard gb) {
		
		// If input entered is out of bounds
		if(colInput < 1 || colInput > 3 || rowInput < 1 || rowInput > 3) {
			System.out.println("Input entered is out of bounds. Please try again.");
			return false;
		}
		
		// Make sure space has not already been used
		if(gb.getValue(rowInput, colInput) != '*') {
			System.out.println("That spot is taken. Try again!");
			return false;
		}
		
		return true;
	}
	
	public static boolean ifWon(char curr, GameBoard gb) {
		
		// Across top row
		
		// Across middle row
		
		// Across bottom row
		
		// Down left column
		
		// Down middle column
		
		// Down right column
		
		// Diagonal left
		
		// Diagonal right
			
		
		return false;		
	}
	
	
}



