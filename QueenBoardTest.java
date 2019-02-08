
public class QueenBoardTest {
	public static void main(String[] args) {
		QueenBoard q = new QueenBoard(8);
		q.solve();
		System.out.println(q.toString());
	}
}
