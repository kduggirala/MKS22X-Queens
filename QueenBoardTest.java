
public class QueenBoardTest {
	public static void main(String[] args) {
		for (int i = 0; i < 12; i++) {
			QueenBoard q = new QueenBoard(i);
			q.solve();
			System.out.println(q.toString());
			q.clearBoard();
			System.out.println(q.countSolutions());
		}
	}
}
