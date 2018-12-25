import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/* CSSSKL 162
 * 
 * UsingStacksSuitorsLab
 * 
 * This class is mostly a driver for playing with Strings as palindromes, 
 * both iteratively and recursively.  The UsingStacksSuitorsLab class itself is
 * a runnable object, so it can be passed to a thread in our Queue demo
 * 
 * 
 */

public class UsingStacksSuitorsLab implements Runnable {
	private static int threadCount = 0;
	private String name;
	
	public UsingStacksSuitorsLab() {
		name = "#" + threadCount++ + "Thread";
	}

	public static void main(String[] args) {
		String s1 = "food";		    //not a palindrome
		String s2 = "racecar";      //a palindrome

		System.out.println("String1 is \"" + s1 + "\"");
		System.out.println("String2 is \"" + s2 + "\"");

		System.out.println(s1 + " reversed is: ");
		printReverse(s1);
		System.out.println(s2 + " reversed is: ");
		printReverse(s2);

		System.out.println();
	    recPrintReverse(s1);
		System.out.println();
		recPrintReverse(s2);
		System.out.println();

		System.out.println(s1 + " is a palindrome: " + isPalindrome(s1));
		System.out.println(s2 + " is a palindrome: " + isPalindrome(s2));

		System.out.println(s1 + " is a palindrome(recursively): " + isPalindromeRec(s1));
		System.out.println(s2 + " is a palindrome(recursively): " + isPalindromeRec(s2));

		//System.out.println("Did we build a Queue of Threads and start them?
        // " + buildThreadQueue());

		int n = 6;
		System.out.println("For " + n + " suitors, stand in place:" + findPlaceToStand(n));

		n = 10;
		System.out.println("For " + n + " suitors, stand in place:" + findPlaceToStand(n));
	}

	
	public static void printReverse(String target) {
		Stack stack = new Stack();
		for(int i = 0; i < target.length(); i ++) {
			Object object1 = (Character) target.charAt(i);
			stack.push(object1);
		}
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
	
	public static void recPrintReverse(String target) {
		if(target != null && target != "") {
			if(target.length() >= 2)
				UsingStacksSuitorsLab.recPrintReverse(target.substring(1));
			System.out.println(target.charAt(0));
		}
	}
	
	public static boolean isPalindrome(String input) {
		Stack stack = new Stack();
		String compare = "";
		for(int i = 0; i < input.length(); i ++) {
			Object object1 = (Character) input.charAt(i);
			stack.push(object1);
		}
		while(!stack.isEmpty()) {
			compare += stack.pop();
		}
		return (input.compareTo(compare) == 0);
	}

	public static boolean isPalindromeRec(String sentence)	{
		if(sentence.length() < 2)
			return true;
		else if (sentence.charAt(0) == sentence.charAt(sentence.length()-1)) {
			return UsingStacksSuitorsLab.isPalindromeRec(sentence.substring(1, sentence.length()-1));
		}
		return false;
	}
	
	public static int findPlaceToStand(int numSuitors) {
		Queue<Integer> myQueue = new LinkedList<Integer>();
		for(int i = 1; i <= numSuitors; i++) {
			myQueue.add(i);
		}
		while(myQueue.size() > 1) {
			for(int i = 0; i < 2; i++) {
				myQueue.add(myQueue.peek());
				myQueue.remove();
			}
			myQueue.remove();
		}
		return myQueue.peek();
	}
	
	public static int findPlaceToStandRev(int numSuitors) {
		Stack<Integer> forward = new Stack<Integer>();
		Stack<Integer> backward = new Stack<Integer>();
		int count = 0;
		for(int i = 1; i <= numSuitors; i++) {
			backward.push(i);
		}
		for(int i = 1; i <= numSuitors; i++) {
			forward.push(backward.pop());
		}
		while((forward.size() > 1) || (backward.size() > 1)) {
			while(!forward.isEmpty()) {
				if(count == 2) {
					forward.pop();
					count = 0;
				} else {
					backward.push(forward.pop());
					count++;
				}
			}
			while(!backward.isEmpty()) {
				if(count == 2) {
					backward.pop();
					count = 0;
				} else {
					forward.push(backward.pop());
					count++;
				}
			}
		}
		if (forward.size() == 1)
			return forward.pop();
		else
			return backward.pop();
	}


	/*public static boolean buildThreadQueue() {	//returns true upon success
		Queue<Thread> q = new LinkedList<Thread>();
		
		//when our program starts up, it might create multiple threads to use
		q.add( new Thread(new UsingStacksSuitorsLab()));
		q.add( new Thread(new UsingStacksSuitorsLab()));
		q.add( new Thread(new UsingStacksSuitorsLab()));
		
		
		System.out.println("Initial Thread order:");
		q.toString();

        //We need to iterate over our pool of threads and call start() on each one
        //Make a loop that dequeues a thread, calls start on it and enqueues
        //it again
        //to do:
        //current = get a thread
        //current.start();
        //put the thread back

		Thread current = q.remove();
		current.start();
		q.add(current);
			current = get a thread
			current.start();
			put the thread back

		System.out.println("Thread order after start()ing:");
		q.toString();  
		
		return true;  //on successful start
	}*/

	
	/*
	 * No need to edit anything below here, 
	 * unless you'd like to change the 
	 * behaviour of each thread in the thread pool above
	 */
	
	@Override
	public void run() {
		for(int i = 0; i < 10000; i++) {
			System.out.println(name + ": " + i + "th iteration");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				//do nothing here
			}
		}
	}
}
