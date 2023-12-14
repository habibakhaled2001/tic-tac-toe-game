package tictactoe;
import javax.swing.JOptionPane;
public class TicTacToeGame {
	public static void main(String[] args) {
		char tictak[][] = new char[6][7];
		String x, y;
		char symbolForX, symbolForY;
		String rows, cols;
		int row = 0;
		int col = 0;
		int numberOfWinsX = 0;
		int numberOfWinsY = 0;
		boolean playerTurn = true;
		boolean endGame = false;
		boolean playAgain = true;

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				tictak[i][j] = '-';
			}
		}
		JOptionPane.showMessageDialog(null, "Let's play Tic Tac Toe!");
		x = JOptionPane.showInputDialog("Player1, What is your name?");
		y = JOptionPane.showInputDialog("Player2, What is your name?");
		String k = JOptionPane.showInputDialog("hi " + x + " do you want to play with 'x' or 'o' ?");
		symbolForX = k.charAt(0);
		for (int i = 0; i < 100; i++) {
			if ((symbolForX == 'x') || (symbolForX == 'o')) {
				break;
			} else {
				k = JOptionPane.showInputDialog(null, "please choose 'x' or 'o'");
				symbolForX = k.charAt(0);
			}
		}
		if (symbolForX == 'x') {
			symbolForY = 'o';
		} else
			symbolForY = 'x';
		while (playAgain) {
			while (!endGame) {
				TicTacToeMethod.drawBoard(tictak);
				if (playerTurn) {
					JOptionPane.showMessageDialog(null, "it's " + x + "'s turn,he/she choose (" + symbolForX + "):");
				} else {
					JOptionPane.showMessageDialog(null, "it's " + y + "'s turn,he/she choose (" + symbolForY + "):");
				}
				char c = '-';
				if (playerTurn)
					c = symbolForX;
				else
					c = symbolForY;
				while (true) {
					rows = JOptionPane.showInputDialog("Please enter row bet 0 & 5:");
					cols = JOptionPane.showInputDialog("Please enter col bet 0 & 6:");
					if ((rows.equals("0") || rows.equals("1") || rows.equals("2") || rows.equals("3")
							|| rows.equals("4") || rows.equals("5"))
							&& (cols.equals("0") || cols.equals("1") || cols.equals("2") || cols.equals("3")
									|| cols.equals("4") || cols.equals("5") || cols.equals("6")))
						break;
					else
						JOptionPane.showMessageDialog(null,
								"This position is " + "off the bounds of the board! Try again.");
				}
				row = Integer.parseInt(rows);
				col = Integer.parseInt(cols);
				for (int i = 0; i < 20; i++) {
					if (tictak[row][col] != '-') {
						JOptionPane.showMessageDialog(null, "try again this postion already taken");
						rows = JOptionPane.showInputDialog("Please enter row between 0 & 5:");
						cols = JOptionPane.showInputDialog("Please enter col between 0 & 6:");
						if ((rows.equals("0") || rows.equals("1") || rows.equals("2") || rows.equals("3")
								|| rows.equals("4") || rows.equals("5"))
								&& (cols.equals("0") || cols.equals("1") || cols.equals("2") || cols.equals("3")
										|| cols.equals("4") || cols.equals("5") || cols.equals("6")))
							break;
						else
							JOptionPane.showMessageDialog(null,
									"This position is " + "off the bounds of the board! Try again.");
					}
				}
				row = Integer.parseInt(rows);
				col = Integer.parseInt(cols);

				tictak[row][col] = c;
				if (TicTacToeMethod.playerHasWon(tictak) == symbolForX) {
					JOptionPane.showMessageDialog(null, "player " + x + " has won!");
					numberOfWinsX = numberOfWinsX + 1;
					JOptionPane.showMessageDialog(null,
							"score is \n" + x + " : " + numberOfWinsX + "\n" + y + " : " + numberOfWinsY);
					endGame = true;
				} else if (TicTacToeMethod.playerHasWon(tictak) == symbolForY) {
					JOptionPane.showMessageDialog(null, "player " + y + " has won!");
					numberOfWinsY = numberOfWinsY + 1;
					JOptionPane.showMessageDialog(null,
							"score is \n" + x + " : " + numberOfWinsX + "\n" + y + " : " + numberOfWinsY);
					endGame = true;
				} else {
					if (TicTacToeMethod.boardIsFull(tictak)) {
						JOptionPane.showMessageDialog(null, "The board is full" + "!");
						endGame = true;
					} else {
						playerTurn = !playerTurn;
					}
				}
			}
			TicTacToeMethod.drawBoard(tictak);
			System.out.println();
			System.out.println("___________________");
			String q = JOptionPane.showInputDialog(null, "do you want to play again ? yes or no");
			for (int count = 0; count < 10; count++) {
				if (q.equals("no")) {
					playAgain = false;
					break;
				} else if (q.equals("yes")) {
					for (int i = 0; i < 6; i++) {
						for (int j = 0; j < 7; j++) {
							tictak[i][j] = '-';
						}
					}
					endGame = false;
					break;
				} else {
					q = JOptionPane.showInputDialog(null, "please choose yes or no");
				}
			}
		}
	}
}