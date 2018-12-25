public class ObjectList {
    private Object[] myShapes = new Object[100];
    private int numElements = 0;

    public static void main(String[] args) {
        ObjectList a = new ObjectList();
        a.add(95);
        a.add(100);
        a.add(58);
        System.out.println(a.toString() );
    }

    public void add(Object n) {
        myShapes[numElements++] = n;
    }

    public String toString() {
        String retVal = "";
        retVal += myShapes[0];
        for (int i = 1; i < numElements; i++) {
            retVal += ", " + myShapes[i];
        }
        return retVal;
    }
/*
(1)Why did we do so much copying-and-pasting in our software above?
There was a lot of copying and pasting because the software above reused code
from IntList.

    a.How can this approach be problematic?
    If there is a problem that needs to be fixed in IntList, then you also
    have to fix the problem in ObjectList. Duplicate code is hard to maintain
    since you have to make the same change for each duplicate.


(2)Are there obvious improvements that could be made here with respect the
software design for Squares and Circles?
To be honest, the only obvious improvement I see is making ObjectList
resizable and adding getters and setters to this software. Maybe constructors
and an equals() method can be added as well?.


(3)What programming constructs were you familiar with, and which did you need to look up?
I was familiar with every programming construct in this lab. I did not have
to look anything up.


(4)Assume we used a separate array for Squares and for Circles rather than one
 unifying Object array.
    a.How would this complicate the task of adding a new Shape (say, a
    Triangle) to our ObjectList class?

    You would end up with a lot of similar code that is hard to maintain. You
    would need 6 instance variables to do it that way (one array for each
    shape and one int for each shape to count the elements in the arrays).
    Then you would need 3 separate add methods so you can add each shape.
    Finally, you would have to loop over each separate array in the toString().
    A unifying Object array is easier because one method fits all Shapes (or
    any other object). The code above would work just fine if you added a
    Triangle to ObjectList.
*/
}
