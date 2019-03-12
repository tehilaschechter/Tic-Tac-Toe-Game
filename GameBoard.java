
public class GameBoard {
	
		private char[][] board;

		public GameBoard(){
			board = new char[3][3];//{{'*', '*', '*'},{'*', '*', '*'},{'*', '*', '*'}};
			
			for(int row = 0; row < board.length; row++) {
				for(int col = 0; col < board.length; col++) {
					board[row][col] = '*';
				}
			}
		}
		
		public void setValue(int row, int col, Player input) { //check input to make sure in bounds
			this.board[(row - 1)][(col - 1)] = input.getCurrent();
		}
		
		public char getValue(int row, int col) {
			return this.board[col - 1][row - 1];
		}
		
		public void printBoard() { 
			for(int row = 0; row < board.length; row++) {
				for(int col = 0; col < board.length; col++) {
					System.out.print(board[row][col]);
				}
				System.out.println("");
			}
			
			System.out.println("");
		}
		
	
}
