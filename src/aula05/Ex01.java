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

    // o set não era suposto ser individual para cada atributo?
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

    public boolean validMonth(int month) {
        if (month >= 1 && month <= 12) {
            return true;
        }
        return false;
    }

    public int monthDays(int month, int year) {
        int totalMonthDays;
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            totalMonthDays = 30;
        } else if (month == 2) {
            totalMonthDays = (year % 4 == 0) ? 29 : 28;
        } else {
            totalMonthDays = 31;
        }
        return totalMonthDays;
    }

    public boolean leapYear(int year) {
        if (year % 4 == 0) {
            return true;
        }
        return false;
    }

    public boolean valid(int day, int month, int year) {
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
        // TODO menu
        Scanner sc = new Scanner(System.in);

        int userOption;
        int userDay = 0;
        int userMonth = 0;
        int userYear = 0;
        DateYMD userDateYMD = new DateYMD(userDay, userMonth, userYear);

        do {
            System.out.println(
                    "Date operations:\n1 - create new date\n2 - show current date\n3 - increment date\n4 - decrement date\n0 - exit");
            userOption = sc.nextInt();
            switch (userOption) {
                case 1:
                    do {
                        System.out.print("Enter a year: ");
                        userYear = sc.nextInt();

                        System.out.print("Enter a month: ");
                        userMonth = sc.nextInt();

                        System.out.print("Enter a day: ");
                        userDay = sc.nextInt();

                        userDateYMD = new DateYMD(userDay, userMonth, userYear);
                        break;
                    } while (!userDateYMD.valid(userDay, userMonth, userYear));
                case 2:
                    if (!userDateYMD.valid(userDay, userMonth, userYear)) {
                        System.out.println("Enter a valid date first.");
                        break;
                    }
                    System.out.println("Current date: " + userDateYMD);
                    break;
                case 3:
                    if (!userDateYMD.valid(userDay, userMonth, userYear)) {
                        System.out.println("Enter a valid date first.");
                        break;
                    }
                    userDateYMD.increment();
                    break;
                case 4:
                    if (!userDateYMD.valid(userDay, userMonth, userYear)) {
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
