public class IntList {
    private int[] data = new int[100];
    private int numElements = 0;

    public static void main(String[] args) {
        IntList a = new IntList();
        a.add(95);
        a.add(100);
        a.add(58);
        System.out.println(a.toString() );
        System.out.println(a.sum() );
        System.out.println(a.indexOf(100));
        System.out.println(a.indexOf(20));
        //System.out.println(a.save() );
    }

    public void add(int n) {
        data[numElements++] = n;
    }

    public String toString() {
        String retVal = "";
        retVal += data[0];
        for (int i = 1; i < numElements; i++) {
            retVal += ", " + data[i];
        }
        return retVal;
    }

    public int sum() {
        int sum = 0;
        for (int i = 0; i < numElements; i++) {
            sum += data[i];
        }
        return sum;
    }

    public int indexOf(int target) {
        int index = -1;
        for (int i = 0; i < numElements; i++) {
            if (data[i] == target) {
                index = i;
            }
        }
        return index;
    }
}
