public class PermanentHire extends SalariedWorker {
    public static final double FLAT_BONUS = 1000;

    public PermanentHire(String name, int social){
        super(name, social);
    }

    public PermanentHire(String name, int social, double monthlyPay) {
        super(name, social, monthlyPay);
    }

    public double calculateWeeklyPay() {
        return super.calculateWeeklyPay() + FLAT_BONUS;
    }
}

/*
What methods are polymorphic in the Employee Hierarchy?
calculateWeeklyPay() is polymorphic in the Employee Hierarchy.

How could we build a method like getRandShape() above but for use with Employees?
You could use make an instance of Random class and then assign 10000000 +
random.nextInt(1000000000) to int social. For hourlyPay or monthlyPay you
could also use random.nextInt(). To get a random subclass of Employee, you
would use a switch case statement like the one in getRandShape(). For name
you could also use a switch case statement and come up with a bunch
of names for each case.

If we built a getRandomEmployee() method that returns various Employee
subclass objects; write a few lines of code that would demonstrate late binding

Employee emp = getRandomEmployee();
emp.calculateWeeklyPay();

This is late binding because calculateWeeklyPay() is an overridden method.
The compiler is not able to resolve the call of overridden methods at compile
time.
 */
