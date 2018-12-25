import java.util.Scanner;

public class Lab1 {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++){
            System.out.print(i);
        }
        System.out.println();

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.print(i);
            }
        }
        System.out.println();

        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i < 5; i++){
            System.out.print("Enter a grade: ");
            sum += sc.nextInt();
        }
        System.out.println("sum is " + sum);

        double average = sum/5;
        System.out.println("average is " + average);

        if (average >= 90) {
            System.out.println("Grade is A");
        } else if (average < 90 && average >= 80) {
            System.out.println("Grade is B");
        } else if (average < 80 && average >= 70) {
            System.out.println("Grade is C");
        } else if (average < 70 && average >= 60) {
            System.out.println("Grade is D");
        } else {
            System.out.println("Grade is F");
        }

        int avg = (int) average;
        switch (avg/10) {
            case 1: case 2: case 3: case 4: case 5: System.out.println("F");
                    break;
            case 6: System.out.println("Switch Grade is D");
                    break;
            case 7: System.out.println("Switch Grade is C");
                    break;
            case 8: System.out.println("Switch Grade is B");
                    break;
            case 9: case 10: System.out.println("Switch Grade is A");
                    break;
        }

        int[] data = {3,1,-8,4,-5,2};
        int s =  sum(data);
        System.out.println("array sum is " + s);
        double a = (double) s/data.length;
        System.out.println("array average is " + a);

        int index = findIndex(data, -5);
        System.out.println("index = " + index);

        int pSum = sumPositive(data);
        System.out.println("positive sum = " + pSum);



    }

    public static int sum(int[] data) {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum;
    }

    public static int findIndex(int[] data, int target){
        int index = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static int sumPositive(int[] data) {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > 0) {
                sum += data[i];
            }
        }
        return sum;
    }
}
