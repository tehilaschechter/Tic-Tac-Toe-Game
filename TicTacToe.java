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
			System.out.print("Enter column: "); 
			col = inputStream.nextInt();
			System.out.print("Enter row: ");
			row = inputStream.nextInt();
			
			board.setValue(row, col, currPlayer);
			board.printBoard();
			
			Player.switchPlayer();
		}
		
		
	}
	
}



