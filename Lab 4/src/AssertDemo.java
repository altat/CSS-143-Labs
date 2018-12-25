/* 
 * CSS 162 Assert Demo
 * 
 * Usage: This software is configured to crash your program immediately upon execution.
 * If your software doesn't crash, you don't have assertions enabled (use "-ea")
 * in your editor.  Google the name of your editor and "how to enable asserts" or follow
 * the instructions specific to BlueJ or Eclipse in the lab.
 * 
 * Author: Rob Nash
 */

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AssertDemo {

	/* Work on this in a piecewise fashion by uncommenting and focusing on one section at a time
	 * in isolation rather than running everything at once.
	 */
	public static void main(String[] args) {
		assert(true);
		//assert(false); assert(false) breaks the code
		
		warmUpAsserts();
		
		assertWithPrimitives();
		
		assertWithObjects();
		
		homeworkRelatedAsserts();
	}

	/*
	 * Just a few warm-up asserts here.
	 * Add two new assert() statements after the TODO below
	 */
	private static void warmUpAsserts() {	
			assert( 5 > 1 );
			
			int a = 30;
			assert(a != 0);
	
			assert(null == null);	  //could this ever be false? No, null is
		// always null
			assert(true == true);	  //a bad day indeed if this could be false
			//TODO: craft two more asserts and place them here.  If they're false, they'll crash the program.
		assert(a > 5);
		assert(a/6 == 5);
	}

	/*
	 * Using asserts in conjunction with primitive types is familiar to you;
	 * just as in a loop or if, you want to form a true/false (boolean) expression
	 * by employing the relational operators.
	 */
	private static void assertWithPrimitives() {
		//assert below to ensure a Fraction's denominator is never 0
		Scanner keys = new Scanner(System.in);
		System.out.println("Enter an integer numerator:");
		int num = keys.nextInt();
				
		System.out.println("Enter an int denominator, not 0:");
		int denom = keys.nextInt();
				
		assert(denom != 0);
	
		//assert that all ArrayLists start empty
		ArrayList<String> emptyList = new ArrayList<String>();
		assert(emptyList.size() == 0);
		//TODO: build two more asserts that use primitives and relational operators here
        assert(denom > 0 || denom < 0);
        assert(num * 0 == 0);
	}
	
	/*
	 * Asserts work with both primitives and objects.  Just as you 
	 * use "==" with primitives and ".equals()" with objects, so too 
	 * will you use ".equals()" in asserts that deal with object equality. 
	 */
	private static void assertWithObjects() {
		AssertDemo ad = new AssertDemo();
		ad.checkAddress(ad);		
		//guess what .equals() does if you don't create one yourself? (hint ==)
        // .equals() will compare if the addresses are the same if you don't
        // make your own
		assert( ad.equals(ad) );
        //i.To what address does “this” map to?
        //"this" maps to the address of the object that "this" refers to ("ad")
        //ii.To what address does“input” or “ad“ map to?
        //"input" and "ad" map to the address of the object that was created
        // in line 82
            //1.What does this mean? Explain this in your comments.
            //This means that "this", "input" and "ad" all map to the same
            // address
		//TODO: make a few objects from any previous lab and test them with assert
        Point p1 = new Point(1,2);
        Point p2 = new Point(1,2);
        Box b1 = new Box(2,2,3,4);
        Box b2 = new Box(2,2,3,4);
        Point p3 = p2;
		assert(p1.equals(p2));
		assert(b1.equals(b2));
		assert(p3.equals(p1));

		//immutable objects are tested with boolean methods and primitives
        // are tested with boolean expressions
	}


	/*
	 * This function compares the address at "this" to the address of the object handed 
	 * into the function.
	 */
	public void checkAddress(Object input) {
		System.out.println("Address of this :" + this);
		System.out.println("Address of input:" + input);
		//how many aliases for the one "new" object created in main exist in this scope? 
		//1? 2? 3? Which are they?  There are 2. "this" and "input"
		assert(this == input);  //== does an address check for objects, which is frequently NOT what we want
	}

	/*	
	 * Asserts are a useful tool for transforming postconditions and class invariants into code.
	 * Lets build a few asserts that work with your current Bill & Money assignment.
	 * Change the value of paidDate and cents to trip the asserts and observe the asserted error message. 
	 */
	private static void homeworkRelatedAsserts() {
		Object paidDate = new Object();  //really, a Date 
		assert( paidDate != null);  	 //perhaps one rule is that paidDate shouldn't be null after calling setPaidDate()
		int cents = 0;
		assert( cents >= 0 && cents <=99);  //another class invariant is written as an assert here.
		//TODO: craft 2 more asserts that you could use with any assignment
        int dollars = 2;
        assert(dollars >= 0);
        int month = 2;
        assert(month >= 1 && month <= 12);
        int day = 12;
        assert(day >= 1 && day <= 31);
	}
}
/*
(1)Which technique do you prefer?
I prefer using the debugger.
    a.Why?
    I prefer the debugger because it walks me through every step of my
    program. I can see what happens as my program executes and the debugger
    shows me exactly where my code breaks.

(2)Are some debugging techniques more (or less) appropriate for longer programs?
I think using the debugger is better for longer programs because the
debugger will walk you through every step of your program which makes
it easy to find bugs. Assertions are less appropriate for longer programs
because you have to enter the assertions manually.

(3)What are the advantages to using a debugger with a GUI?
    a.What can you inspect here that you couldn't when just printing to the
    console?
    Debuggers with a GUI can show you variables and their values as the
    program executes. They can also show you method call stacks. They can
    show you where, when, and how your program breaks as it executes.


(4)How can proper documentation help in finding and avoiding bugs?
Proper documentation tells you a method should do and what shouldn't happen.
If it does anything other than what is described in the documentation, then
there is a probably a bug at wherever you used that method. Documentation
also tells you about the parameters and invariants of that method/class so
you can avoid bugs as long as you follow those rules.
 */