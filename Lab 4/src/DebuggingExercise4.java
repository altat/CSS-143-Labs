class DebuggingExercise4
{
    public static void main(String[] args)
    {
        Account a = new Account("Tanvir");
        a.deposit(100);
        System.out.println(a.getOwner() + " has $" + a.getBalance());
        a.withdraw(200);
        System.out.println("After trying to withdraw $200, " + a.getOwner() + " has $" + a.getBalance());
    }
/*
a.Where is the variable watch window on your screen?
The variable watch window is on the bottom left of my screen
    i.What information does this present to you?
    It lists the variables and objects in my program and tells me their
    values and addresses

b.Where is the method call stack on your screen?
The method call stack is to the left of the variables watch window.
    i.What information does this describe?
    It tells you which methods are currently being called and executed.


a.Step over
    i.What does this do?
    Step over executes the currently highlighted line/method and goes to the
    next line
b.Step into
    i.What does this do?
    Step into goes into the code of a method.
    ii.How is it different from step over?
    It lets you see the individual steps/instructions of a method as it executes
c.Step out
    i.What does this do?
    Step out goes back to main from a method and goes to the next line.
    ii.How is it different from step over or step into?
    It lets you skip the individual steps of a method and puts you back into
    main
d.Continue
    i.What does this do?
    Continue or Resume will execute everything up until the next breakpoint
    ii.How is it different than moving in steps?
    It lets you skip multiple lines.
 */
}