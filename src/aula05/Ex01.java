package aula05;

import java.util.Scanner;

class DateYMD {

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

    public String toString() {
        return this.year + "-" + this.month + "-" + this.day;
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

}

public class Ex01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int userOption;

        DateYMD userDateYMD = null;

        boolean isValid = false;

        do {
            System.out.println(
                    "Date operations:\n1 - create new date\n2 - show current date\n3 - increment date\n4 - decrement date\n0 - exit");
            userOption = sc.nextInt();
            switch (userOption) {
                case 1:
                    do {
                        System.out.print("Enter a year: ");
                        int userYear = sc.nextInt();

                        System.out.print("Enter a month: ");
                        int userMonth = sc.nextInt();

                        System.out.print("Enter a day: ");
                        int userDay = sc.nextInt();

                        isValid = DateYMD.valid(userDay, userMonth, userYear);

                        if (isValid) {
                            userDateYMD = new DateYMD(userDay, userMonth, userYear);
                        } else {
                            System.out.println("Invalid date. Enter again.");
                        }
                    } while (!isValid);
                    break;
                case 2:
                    if (userDateYMD == null) {
                        System.out.println("Enter a valid date first.");
                        break;
                    }
                    System.out.println("Current date: " + userDateYMD);
                    break;
                case 3:
                    if (userDateYMD == null) {
                        System.out.println("Enter a valid date first.");
                        break;
                    }
                    userDateYMD.increment();
                    break;
                case 4:
                    if (userDateYMD == null) {
                        System.out.println("Enter a valid date first.");
                        break;
                    }
                    userDateYMD.decrement();
                    break;
                default:
                    break;
            }
        } while (userOption != 0);

        sc.close();
    }
}
