package Logic;

public class Score {
	private static int point;
	
	public Score() {
		point = 0;
	}
	
	public void upScore(int i) {
		point += i;
	}
	
	public static int getScore() {
		return point;
	}
}
