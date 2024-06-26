package aula06;

public class DateYMD {

    private int day;
    private int month;
    private int year;

    public DateYMD(int day, int month, int year) {
        if (!valid(day, month, year)) {
            System.out.println("Invalid date.");
            return;
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void setDate(int day, int month, int year) {
        if (!valid(day, month, year)) {
            System.out.println("Invalid date.");
            return;
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    private static boolean validMonth(int month) {
        if (month >= 1 && month <= 12) {
            return true;
        }
        return false;
    }

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

    private static boolean leapYear(int year) {
        if (year % 4 == 0) {
            return true;
        }
        return false;
    }

    public static boolean valid(int day, int month, int year) {
        if (day > monthDays(month, year) || day <= 0
                || !validMonth(month) || year < 1000) {
            return false;
        }
        return true;
    }

    public void increment() {
        this.day++;
        if (this.day > monthDays(month, year)) {
            this.day = 1;
            this.month++;
        }
        if (this.month > 12) {
            this.month = 1;
            this.year++;
        }
    }

    public void decrement() {
        this.day--;
        if (this.day < 1) {
            this.month--;
            this.day = monthDays(month, year);
        }
        if (this.month < 1) {
            this.month = 12;
            this.year--;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + day;
        result = prime * result + month;
        result = prime * result + year;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DateYMD other = (DateYMD) obj;
        if (day != other.day)
            return false;
        if (month != other.month)
            return false;
        if (year != other.year)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return this.day + "/" + this.month + "/" + this.year;
    }
}