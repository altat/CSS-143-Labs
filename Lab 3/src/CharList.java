import java.util.Arrays;

public class CharList {
    private char[] myChars = new char[100];
    int numChars = 0;

    public CharList() {
    }

    public CharList(String startStr) {
        for (int i = 0; i < startStr.length(); i++){
            myChars[numChars++] = startStr.charAt(i);
        }
    }

    public CharList(CharList other) {
        myChars = other.myChars;
        numChars = other.numChars;
    }

    public void add(char next) {
        if (numChars + 1 > myChars.length) {
            myChars = Arrays.copyOf(myChars, myChars.length*2);
        }
        myChars[numChars++] = next;
    }

    public char get(int index) {
        return myChars[index];
    }

    public int size() {
        return numChars;
    }


    public String toString() {
        String retVal = "";

        for (int i = 0; i < numChars; i++) {
            retVal += myChars[i];
        }
        return retVal;
    }

    public boolean equals(Object other) {
        if(other == null && !(other instanceof CharList)) return false;
        CharList otherList = (CharList) other;
        if (this.numChars == otherList.numChars) {
            for (int i = 0; i < numChars; i++) {
                if (this.get(i) != otherList.get(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
