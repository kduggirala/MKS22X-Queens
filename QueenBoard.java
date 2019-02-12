
public class QueenBoard {
	private int[][] board;
	private int n;
	public QueenBoard(int size) {
		n = size;
		board = new int[size][size];
	}
	/**
	 *@return The output string formatted as follows:
	 *All numbers that represent queens are replaced with 'Q' 
	 *all others are displayed as underscores '_'
	 *There are spaces between each symbol:  
	 *"""_ _ Q _
	 *Q _ _ _

	 *_ _ _ Q

	 *_ Q _ _"""
	 *(pythonic string notation for clarity, 
	 *excludes the character up to the *)
	 */
	public String toString(){
		StringBuffer boardStringBuffer = new StringBuffer();
		for (int[] row: board) {
			for (int i : row) {
				boardStringBuffer.append(i == -1 ? "Q" : "_");
				boardStringBuffer.append(" ");
			}
			boardStringBuffer.append("\n");
		}
		return boardStringBuffer.toString();
	}



	/**
	 *@return false when the board is not solveable and leaves the board filled with zeros; 

	 *        true when the board is solveable, and leaves the board in a solved state

	 *@throws IllegalStateException when the board starts with any non-zero value

	 */
	public boolean solve(){
		if (!isEmpty()) {
			throw new IllegalStateException("The board must be empty before solving");
		}
		boolean solvable = solveHelp(0);
		if (!solvable) {
			clearBoard();
		}
		return solvable;
	}
	/**
	 * Searches the columns of the board and returns true if a solution is found
	 * @param c column at which the algorithm searches for a solution
	 * @return true if a solution is possible with the preceding board configuration
	 */
	private boolean solveHelp(int c) {
		if (c == n) {
			return true;
		}
		for (int i  = 0; i < n; i++) {
			if (board[i][c] == 0) {
				addQueen(i, c);
				if (solveHelp(c + 1)) {
					return true;
				}
				else {
					removeQueen(i, c);
				}
			}
		}
		return false;
	}
	/*
	 * Adds a queen to the board at board[r][c] and marks all the threatened spaces
	 */
	private void addQueen(int r, int c) {
		board[r][c] = -1;
		for (int i = c + 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				//at horizontal
				if (j == r) {
					board[j][i]++;
				}
				//at diagonal
				if (Math.abs(j - r) == Math.abs(i - c)) {
					board[j][i]++;
				}
			}
		}
	}
	/**
	 * Removes a queen from the board at board[r][c] and unmarks all threatened spaces.
	 * @throws IllegalArgumentException if there is no queen at the space r, c
	 */
	private void removeQueen(int r, int c) {
		if (board[r][c] != -1) {
			throw new IllegalArgumentException("No queen here");
		}
		board[r][c] = 0;
		for (int i = c + 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				//at horizontal
				if (j == r) {
					board[j][i]--;
				}
				//at diagonal
				if (Math.abs(j - r) == Math.abs(i - c)) {
					board[j][i]--;
				}
			}
		}
	}
	/**
	 *@return the number of solutions found, and leaves the board filled with only 0's
	 *@throws IllegalStateException when the board starts with any non-zero value
	 */
	public int countSolutions(){
		if (!isEmpty()) {
			throw new IllegalStateException("The board must be empty before solving");
		}
		int countSolutions = countSolutionsHelp(0);
		return countSolutions;
	}
	/**
	 * Returns the number of solutions possible at a column c given the preceding board configuration
	 * @param c the column of the board being searched for solutions
	 * @return the number of possible solutions with the preceding board configuration
	 */
	private int countSolutionsHelp(int c) {
		if (c == n) {
			return 1;
		}
		else {
			int countSolutions = 0;
			for (int i  = 0; i < n; i++) {
				if (board[i][c] == 0) {
					addQueen(i, c);
					countSolutions += countSolutionsHelp(c+1);
					removeQueen(i, c);
				}
			}
			return countSolutions;
		}
	}
	/*
	 * Sets all values on the board to zero
	 */
	public void clearBoard() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = 0;
			}
		}
	}
	/*
	 * Checks whether the board is all zeros
	 */
	private boolean isEmpty() {
		for (int[] row: board) {
			for (int i : row) {
				if (i != 0) {
					return false;
				}
			}
		}
		return true;
	}
}
