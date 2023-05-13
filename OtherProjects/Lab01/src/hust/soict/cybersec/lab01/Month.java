package hust.soict.cybersec.lab01;
public class Month {
    private int monthNumber;
    private int year;

    public Month(int monthNumber, int year) {
        this.monthNumber = monthNumber;
        this.year = year;
    }

    public int getNumberOfDays() {
        switch (monthNumber) {
            case 2:
                return isLeapYear(this.year) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
