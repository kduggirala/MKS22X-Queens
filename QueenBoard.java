
public class QueenBoard {
	public int[][] board;
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
	  public boolean solve(){}
	  
	  public void addQueen(int r, int c) {
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
	  
	  public void removeQueen(int r, int c) {
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
	  public int countSolutions(){}
	  private void clearBoard() {
		  for (int i = 0; i < n; i++) {
			  for (int j = 0; j < n; j++) {
				  board[i][j] = 0;
			  }
		  }
	  }
}
