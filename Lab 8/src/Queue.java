import java.util.ArrayList;

public class Queue<T> {
	
	private class Node {
		public Object data = null;
		public Node next = null;
		
		public Node(Object d, Node n) {
			data = d;
			next = n;
		}
	}
	
	private ArrayList queue = new ArrayList();
	

	public void enqueue(T obj) {
		queue.add(obj);
	}

	public Object dequeue() {
		return queue.remove(0);
	}

	public int size() {
		return queue.size();
	}

	public String toString() {
		return queue.toString();
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Queue))
			return false;
		Queue copy = (Queue) obj;
		if(queue.size() == copy.size()) {
			for(int i = 0; i < this.size(); i++) {
				if(!this.queue.equals(copy.queue))
					return false;
			}
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Queue<Character> q = new Queue<Character>();
		q.enqueue('R');
		q.enqueue('a');
		q.enqueue('c');
		q.enqueue('e');
		//a.push('c');
		//a.push('a');
		q.enqueue('r');
		System.out.println("Size : " + q.size());
		while(!q.isEmpty()) {
			System.out.println(q.dequeue());
		}
	}
}
