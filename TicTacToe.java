import java.util.Scanner;

public class TicTacToe {
	
	public static Scanner inputStream = new Scanner(System.in);
	
	public static void main(String[] args) {
		Player currPlayer = new Player();
		int col;
		int row;
		boolean game = true;
		boolean play = true; 
		String input = "";		
		System.out.println("Welcome to **Tic Tac Toe**");
		System.out.println("-------------------------");
		
		
		while(play) {
			GameBoard board = new GameBoard();
			board.printBoard();
			
			while(game) {
				System.out.println("Player " + currPlayer.getCurrent() + ", it's your turn!");
				
				// Prompt user until input entered is valid
				do {
				System.out.print("Enter row: "); 
				row = inputStream.nextInt();
				System.out.print("Enter column: ");
				col = inputStream.nextInt();
				System.out.println("");
				}
				while(!validate(row, col, board)); 
				
				board.setValue(row, col, currPlayer);
				board.printBoard();
				
				
				// Determine if game is over
				if(ifWon(currPlayer.getCurrent(), board)) {
					System.out.println("Player " + currPlayer.getCurrent() + ", you won!");
					break;
				}
				
				if(ifCats(board)) {
					System.out.println("Cats game...");
					break;
				}
				
				Player.switchPlayer();
			}
			
			
			
			// Determine if user wants to play again
			System.out.print("Play again?(y/n) ");
			input = inputStream.next();
			
			if(input.equals("n")) {
				play = false;
				System.out.println("Good Bye.");
				break;
			}
			else if(input.equals("y")) {
				play = true;
			}
			else {
				System.out.println("Invalid input. Goodbye.");
				break;
			}
		}		
	}
	
	public static boolean validate(int rowInput, int colInput, GameBoard gb) {
		
		// If input entered is out of bounds
		if(rowInput < 1 || rowInput > 3 || colInput < 1 || rowInput > 3) {
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
		if(gb.getValue(1, 1) == curr && gb.getValue(1, 2) == curr && gb.getValue(1, 3) == curr)
			return true;
		// Across middle row
		if(gb.getValue(2, 1) == curr && gb.getValue(2, 2) == curr && gb.getValue(2, 3) == curr)
			return true;
		// Across bottom row
		if(gb.getValue(3, 1) == curr && gb.getValue(3, 2) == curr && gb.getValue(3, 3) == curr)
			return true;
		// Down left column
		if(gb.getValue(1, 1) == curr && gb.getValue(2, 1) == curr && gb.getValue(3, 1) == curr)
			return true;
		// Down middle column
		if(gb.getValue(1, 2) == curr && gb.getValue(2, 2) == curr && gb.getValue(3, 2) == curr)
			return true;
		// Down right column
		if(gb.getValue(1, 3) == curr && gb.getValue(2, 3) == curr && gb.getValue(3, 3) == curr)
			return true;
		// Diagonal left
		if(gb.getValue(1, 3) == curr && gb.getValue(2, 2) == curr && gb.getValue(3, 1) == curr)
			return true;
		// Diagonal right
		if(gb.getValue(1, 1) == curr && gb.getValue(2, 2) == curr && gb.getValue(3, 3) == curr)
			return true;
		
		return false;		
	}
	
	
	public static boolean ifCats(GameBoard gb) {
		
		// When entire board is filled, yet no one won...
		if(gb.getValue(1,1) != '*' && gb.getValue(1,2) != '*' && gb.getValue(1,3) != '*' &&
				gb.getValue(2,1) != '*' && gb.getValue(2,2) != '*' && gb.getValue(2,3) != '*' &&
				gb.getValue(3,1) != '*' && gb.getValue(3,2) != '*' && gb.getValue(3,3) != '*') {
			return true;
		}
		
		return false;
	}
	
}



