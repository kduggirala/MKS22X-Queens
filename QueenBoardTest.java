
public class QueenBoardTest {
	public static void main(String[] args) {
		QueenBoard q = new QueenBoard(8);
		q.addQueen(2, 0);
		for(int[] row : q.board) {
			for(int i : row) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		q.addQueen(3, 1);
		System.out.println();
		for(int[] row : q.board) {
			for(int i : row) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
