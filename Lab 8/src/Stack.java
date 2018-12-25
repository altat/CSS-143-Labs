import java.util.ArrayList;

public class Stack<T> {
	
	private class Node {
		public Object data = null;
		public Node next = null;
		
		public Node(Object d, Node n) {
			data = d;
			next = n;
		}
	}
	
	ArrayList stack = new ArrayList();


	public void push(T obj) {
		stack.add(0, obj);
	}

	public Object pop() {
		return stack.remove(0);
	}

	public int size() {
		return stack.size();
	}

	public String toString() {
		return stack.toString();
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Stack))
			return false;
		Stack copy = (Stack) obj;
		if(stack.size() == copy.size()) {
			for(int i = 0; i < this.size(); i++) {
				if(!this.stack.equals(copy.stack))
					return false;
			}
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Stack<Character> a = new Stack<Character>();
		a.push('R');
		a.push('a');
		a.push('c');
		a.push('e');
		//a.push('c');
		//a.push('a');
		a.push('r');
		System.out.println("Size : " + a.size());
		while(!a.isEmpty()) {
			System.out.println(a.pop());
		}
	}
}

