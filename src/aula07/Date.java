package aula07;

public abstract class Date implements Comparable<Date> {
    public static boolean validMonth(int month) {
        if (month >= 1 && month <= 12) {
            return true;
        }
        return false;
    };

    public static int monthDays(int month, int year) {
        int totalMonthDays;
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            totalMonthDays = 30;
        } else if (month == 2) {
            totalMonthDays = leapYear(year) ? 29 : 28;
        } else {
            totalMonthDays = 31;
        }
        return totalMonthDays;
    }

    public static boolean leapYear(int year) {
        if (year % 4 == 0) {
            return true;
        }
        return false;
    };

    public static boolean valid(int day, int month, int year) {
        if (day > monthDays(month, year) || day <= 0
                || !validMonth(month) || year < 1000) {
            return false;
        }
        return true;
    }

    public String toString(int day, int month, int year) {
        return String.format("%d-%d-%d",
                day,
                month,
                year);
    }

    abstract int getDay();

    abstract int getMonth();

    abstract int getYear();

    @Override
    public int compareTo(Date o) {
        int a = this.getYear() * 365 + this.getMonth() * 31 + this.getDay();
        int b = o.getYear() * 365 + o.getMonth() * 31 + o.getDay();
        return a - b;
    }
}