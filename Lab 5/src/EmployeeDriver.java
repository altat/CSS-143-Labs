import java.util.ArrayList;
/*
 * Driver
 * Lab 
 * 
 * A simple driver to exercise the Employee hierarchy 
 */

public class EmployeeDriver {
	
	
	public static void main(String[] args) {
		Accountant emp1 = new Accountant( "Rick", 123456789);
		//this next employee makes a bit more than Rick
		Accountant emp2 = new Accountant( "Tim", 55555555,10000);
		//and lets make an hourly worker
		HourlyWorker emp3 = new HourlyWorker( "Jim", 11111111);
		//then a salaried worker
		SalariedWorker emp4 = new SalariedWorker( "Jane", 222222222, 5000);
		HourlyWorker emp5 = new HourlyWorker( "Joe", 11111111,20);
		
		//todo: Build some PermanentHire and Consultant objects here
        PermanentHire emp6 = new PermanentHire("Nate", 34343434, 8000);
        PermanentHire emp7 = new PermanentHire("Steve", 33333333);
        Consultant emp8 = new Consultant("Randy", 67676767, 7);
        Consultant emp9 = new Consultant("Joel", 7777777);
        ColorWithAlpha c = new ColorWithAlpha(12);
        ColorException e = new ColorException();
		//and add them to the ArrayList below
		
		//and build a set of workers, all of which are employees
		ArrayList<Employee> myEmployees = new ArrayList<Employee>();
		
		myEmployees.add(emp1);
		myEmployees.add(emp2);
		myEmployees.add(emp3);
		myEmployees.add(emp4);
		myEmployees.add(emp5);
		myEmployees.add(emp6);
		myEmployees.add(emp7);
		myEmployees.add(emp8);
		myEmployees.add(emp9);
		//myEmployees.add(c); I get the error: add(Employee) in ArrayList cannot
        // be applied to (ColorWithAlpha). This means that only instances of
        // Employee can be added to myEmployees. ColorWithAlpha is not an
        // instance of Employee.
		//myEmployees.add(e); I got the same error as above except with
        // (ColorException). If I wanted the myEmployees ArrayList to store
        // both ColorExceptions and Employees, then I would have to declare
        // it as an ArrayList for Objects: ArrayList<Object> myObjects = new
        // ArrayList<Object>();
    //todo: add a sixth and seventh employee to this list that you create
		
		
		//this code doesn't need to change, even if you add 10 new employee classes and 
		//add 102 new employees - this is an example of generic code that can be written 
		//when inheritance hierarchies are in use
		for( int i = 0; i < myEmployees.size(); i++) {
			Employee current = myEmployees.get(i);
			System.out.println( current.getName() + " makes " + current.calculateWeeklyPay() + " per week.");
		}
		
	}
}
