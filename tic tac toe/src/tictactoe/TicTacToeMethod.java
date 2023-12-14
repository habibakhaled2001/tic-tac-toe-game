package tictactoe;

public class TicTacToeMethod {
	public static void drawBoard(char tictak[][]) {
		System.out.println("The board of the game:");
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print("   " + tictak[i][j]);
			}
			System.out.println();
		}
	}

	public static char playerHasWon(char board[][]) {
		int i, j;
		for (i = 0; i < 6; i++) {
			for (j = 0; j <= 4; j++) {
				if (board[i][j] == board[i][j + 1] && board[i][j + 1] == board[i][j + 2] && board[i][j] != '-') {
					return board[i][j];
				}
			}
		}
		for (i = 0; i <= 3; i++) {
			for (j = 0; j < 7; j++) {

				if (board[i][j] == board[i + 1][j] && board[i + 1][j] == board[i + 2][j] && board[i][j] != '-')
					return board[i][j];
			}
		}
		for (i = 0; i <= 3; i++) {
			for (j = 0; j <= 4; j++) {
				if ((board[i][j] == board[i + 1][j + 1]) && (board[i + 1][j + 1] == board[i + 2][j + 2])
						&& (board[i][j] != '-'))
					return board[i][j];
			}
		}
		for (i = 0; i <= 3; i++) {
			for (j = 6; j >= 2; j--) {
				if ((board[i][j] == board[i + 1][j - 1]) && (board[i + 1][j - 1] == board[i + 2][j - 2])
						&& (board[i][j] != '-'))
					return board[i][j];
			}
		}
		return ' ';
	}

	public static boolean boardIsFull(char tictak[][]) {
		int i, j;
		for (i = 0; i < 6; i++) {
			for (j = 0; j < 7; j++) {
				if (tictak[i][j] == '-')
					return false;
			}
		}
		return true;
	}

}
