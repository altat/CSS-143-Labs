import java.util.ArrayList;

public class QuizTracker implements Cloneable {
	ArrayList<QuizScore> al = new ArrayList<>();

	public void add(QuizScore qs) {
		al.add((QuizScore)qs.clone());
	}

	public Object clone() {
		QuizTracker copy = new QuizTracker();
		for(int i = 0; i < al.size(); i++) {
			copy.add((QuizScore)al.get(i).clone());
		}
		return copy;
	}
}
