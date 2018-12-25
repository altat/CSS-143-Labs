public class Date {
    private int month, day, year;
    static int d = 1;

    public Date() {
    }

    public Date(int month, int day, int year) {
        if (month < 1 || month > 12) throw new IllegalArgumentException("Illegal month: " + month);
        this.month = month;
        if (day < 1 || day > 31) throw new IllegalArgumentException("Illegal day: " + day);
        this.day = day;
        if (year < 0) throw new IllegalArgumentException("Illegal year: " + year);
        this.year = year;
    }

    public Date(Date other) {
        month = other.month;
        day = other.day;
        year = other.year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Illegal month: " + month);
        }
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Illegal day: " + day);
        }
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 0) {
            throw new IllegalArgumentException("Illegal year: " + year);
        }
        this.year = year;
    }

    public void setDate(int month, int day, int year) {
        setMonth(month);
        setDay(day);
        setYear(year);
    }

    public String toString() {
        return month + "/" + day + "/" + year;
    }

    public boolean equals(Object other) {
        if(other != null && !(other instanceof Date)) return false;
        Date otherDate = (Date) other;
        return this.month == otherDate.month && this.day == otherDate.day && this.year == otherDate.year;
    }
}

/*
When data is defined as static...
a.Can it be accessed or read? Static data can be accessed
b.Can it be written to? Yes
c.If we had declared one static variable and 10 objects declared in RAM, how many static variables would also be in memory?
There should only be one static variable in memory since the 10 objects share
 one static variable.

When data is defined as final...
a.Can it be accessed/used or read?
b.Can it be written to other than the first initialization? No.
c.Why would it be ok to declare a final (or static final) variable as public?
Because a final variable can't be changed unless you change its value at the
spot where it is initialized.
d.Later: How does the concept of a final variable relate to Immutableclasses?
a final variable stays constant (can't be changed) and immutable classes also
 can't be changed. you can only make a new one.
 */
