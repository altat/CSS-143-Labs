public class QuizScore implements Cloneable {
	private int score;
	
	public QuizScore() {}

	private QuizScore(QuizScore qs) {
		score = qs.score;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int sco) {
		score = sco;
	}

	public Object clone() {
		return new QuizScore(this);
	}
}
