import java.util.*;
import java.util.Comparator;

 
public class MyArrayList implements Comparable<MyArrayList>{
    protected int comparisons = 0;

    // instance data
    protected int[] IntList;
    protected char[] CharList;
    protected String[] StringList;
    
     // constructor will build all 3 arrays here
    public MyArrayList() {
        this.IntList = new int[10];
        this.CharList = new char[10];
        this.StringList = new String[5];
        
        // fill all 3 arrays with data
       for(int i = 0; i < IntList.length; i++) {
            IntList[i] = (int) (Math.random()*52);
       }
       // Populate char array
       for(int i = 0; i < CharList.length; i++) {
           
          Random random = new Random();
          CharList[i] = (char)(random.nextInt(26) + 'a');
       }
	   
       // Populate String array
       StringList[0] = "joe";
       StringList[1] = "mark";
       StringList[2] = "abbey";
       StringList[3] = "tony";
       StringList[4] = "kevin";    
    }
    
    public int compareTo(MyArrayList other) {
    	if(this.IntList[0] < other.IntList[0]) {
    		System.out.println("compareTo() is returning -1, array[0] < other[0]");
    		return -1; // -1 means this is less than other
    	}
    	else if(this.IntList[0] > other.IntList[0]) {
    		System.out.println("compareTo() is returning 1, array[0] > other[0]");
    		return 1; // 1 means this is greater than other
    	}
    	else {
    		System.out.println("compareTo() is returning 0, array[0] != other[0] ");
    		return 0; // 0 means this is equal to other
    	}
    }

    
    public void intBubbleSort() {
    	boolean unsorted = true;
    	while(unsorted) {
    		unsorted = false;
    		for (int i = 0; i < IntList.length-1; i++) {
    			if (IntList[i] > IntList[i + 1]) {
    				swapInts(IntList, i);
    				unsorted = true;
    			}
    		}
    	}
    }
    
    public void CharBubbleSort() {
    	boolean unsorted = true;
    	while(unsorted) {
    		unsorted = false;
    		for (int i = 0; i < CharList.length-1; i++) {
    			if (CharList[i] > CharList[i + 1]){
    				swapChars(CharList, i);
    				unsorted = true;
    			}
    		}
    	}
    }
    
    public void stringBubbleSort() {
    	boolean unsorted = true;
    	while(unsorted) {
    		unsorted = false;
    		for (int i = 0; i < StringList.length-1; i++) {
    			if (StringList[i].compareTo(StringList[i + 1]) > 0){
    				swapStrings(StringList, i);
    				unsorted = true;
    			}
    		}
    	}
    }


    public void swapInts(int[] intList, int j) { 
    	int temp = intList[j];
		intList[j] = intList[j + 1];
		intList[j + 1] = temp;
    }
    
    public void swapChars(char[] charList, int j) { 
    	char temp = charList[j];
    	charList[j] = charList[j + 1];
    	charList[j + 1] = temp;
    }
    
    public void swapStrings(String[] stringList, int j) { 
    	String temp = stringList[j];
    	stringList[j] = stringList[j + 1];
    	stringList[j + 1] = temp;
    }
    
    //selection sort for ints
    public void selectionSort() {
    	int a = IntList[0];
    	for(int i = 0; i < IntList.length - 1; i++) {
        	a = findSmallest(IntList, i, IntList.length);
        	swapSelection(IntList, i, a);
        }
    }

    //selection sort for Strings
    public void stringSelectionSort() {
        int a = 0;
        for (int i = 0; i < StringList.length - 1; i++) {
            a = findSmallestString(StringList, i, StringList.length);
            swapSelectionStrings(StringList, i, a);
        }
    }

    public void swapSelection(int[] intList, int i, int nextMin) { 
    	int temp = intList[i];
		intList[i] = intList[nextMin];
		intList[nextMin] = temp;
    }

    public void swapSelectionStrings(String[] StringList, int i, int nextMin) {
        String temp = StringList[i];
        StringList[i] = StringList[nextMin];
        StringList[nextMin] = temp;
    }
    
    public int findSmallest(int[] arr, int begin, int end) {
        //returns the index of the smallest element
        int minIndex = begin;  
        for(int i = begin; i < end - 1; i++) {
            comparisons++;
            if(arr[i+1] < arr[minIndex])
                minIndex = i+1;
        }
        return minIndex;
    }

    public int findSmallestString(String[] arr, int begin, int end) {
        //returns the index of the smallest element
        int minIndex = begin;
        for(int i = begin; i < end - 1; i++) {
            if(arr[i+1].compareTo(arr[minIndex]) < 0)
                minIndex = i+1;
        }
        return minIndex;
    }
    
    public int findLargest(int[] arr, int begin, int end) {
        //returns the index of the smallest element
    	 int maxIndex = begin;  
         for(int i = begin; i < end - 1; i++) {
             comparisons++;
             if(arr[i+1] > arr[maxIndex])
            	 maxIndex = i+1;
         }
         return maxIndex;
    }
    
    //Insertion Sort 
    public void insertionSort() {
	
		for(int i = 1; i < IntList.length; i++) {
            //note -1 above since we're dealing with neighbors (a, a+1)
            int current = IntList[i];
            int hole = i - 1;
            
            while(hole >= 0 && IntList[hole] > current ) {
            	IntList[hole+1] = IntList[hole];
                hole = hole-1;
            }  
            IntList[hole+1] = current;
        }  
    }
} 

    

