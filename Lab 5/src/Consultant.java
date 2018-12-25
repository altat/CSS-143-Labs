public class Consultant extends HourlyWorker {
    public static final double PART_TIME_WAGE = 3.00;

    public Consultant(String name, int social){
        super(name, social, PART_TIME_WAGE);
    }

    public Consultant(String name, int social, double hourlyPay) {
        super(name, social, hourlyPay);
    }

    public double calculateWeeklyPay() {
        return super.calculateWeeklyPay()/2;
    }
}
