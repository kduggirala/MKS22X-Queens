
public class QueenBoardTest {
	public static void main(String[] args) {
		for (int i = 0; i < 21; i++) {
			QueenBoard q = new QueenBoard(i);
			System.out.println(q.countSolutions());
		}
	}
}
