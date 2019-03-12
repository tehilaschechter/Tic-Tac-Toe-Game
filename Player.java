
public class Player {
	private static char currPlayer = 'X';
	
	public char getCurrent() {
		return currPlayer;
	}
	
	public static void switchPlayer() {
		if (currPlayer == 'X') {
			currPlayer = 'O';
		}
		else {
			currPlayer = 'X';
		}
	}
}
