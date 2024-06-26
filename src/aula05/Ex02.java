package aula05;

import java.util.Scanner;

class Calendar {
    private int year;
    private int firstWeekdayOfYear;
    private int[][] eventos = new int[12][31];

    public Calendar(int year, int firstWeekdayOfYear) {
        this.year = year;
        this.firstWeekdayOfYear = firstWeekdayOfYear;
    }

    public int year() {
        return this.year;
    }

    public int firstWeekdayOfYear() {
        return this.firstWeekdayOfYear;
    }

    public int firstWeekdayOfMonth(int month) {
        int totalDays = 0;
        int firstWeekdayOfMonth;

        for (int i = 1; i < month; i++) {
            totalDays += DateYMD.monthDays(i, this.year);
        }
        firstWeekdayOfMonth = (totalDays % 7) + 1;
        return firstWeekdayOfMonth;
    }

    public void addEvent(DateYMD dateEvent) {
        eventos[dateEvent.getMonth() - 1][dateEvent.getDay() - 1]++;
    }

    public void removeEvent(DateYMD dateEvent) {
        if (eventos[dateEvent.getMonth() - 1][dateEvent.getDay() - 1] <= 0) {
            return;
        }
        eventos[dateEvent.getMonth() - 1][dateEvent.getDay() - 1]--;
    }

    public String printMonth(int month) {
        int diaSemanaAtual = firstWeekdayOfMonth(month);
        int totalMonthDays = DateYMD.monthDays(month, this.year);
        String result = "";

        String[] meses = { "", "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        String nomeMes = meses[month];

        result += String.format("%12s %6d\n", nomeMes, this.year);
        result += "  Su  Mo  Tu  We  Th  Fr  Sa\n";

        for (int i = 1; i < diaSemanaAtual; i++) {
            result += "    ";
        }

        for (int i = 1; i <= totalMonthDays; i++) {
            if (eventos[month - 1][i - 1] > 0) {
                result += String.format(" *%2d", i);
            } else {
                result += String.format("%4d", i);
            }

            diaSemanaAtual++;
            if (diaSemanaAtual > 7) {
                result += "\n";
                diaSemanaAtual = 1;
            }
        }
        result += "\n";

        return result;
    }

    public String toString() {
        String result = "";
        for (int i = 1; i <= 12; i++) {
            result += printMonth(i);
        }
        return result;
    }

    public static boolean validation(int year, int weekDay) {
        if (year >= 1000 && weekDay >= 1 && weekDay <= 7) {
            return true;
        }
        return false;
    }
}

public class Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int userInput;
        Calendar userCalendar = null;

        do {
            System.out.println(
                    "\nCalendar operations:\n1 - create new calendar\n2 - print calendar month\n3 - print calendar\n0 - exit");
            userInput = sc.nextInt();

            switch (userInput) {
                case 1:
                    System.out.print("Year: ");
                    int year = sc.nextInt();

                    System.out.print("Fist weekday of year: ");
                    int weekDay = sc.nextInt();

                    boolean isValid = Calendar.validation(year, weekDay);

                    if (!isValid) {
                        System.out.println("Invalid calendar. Try again.");
                        break;
                    }

                    userCalendar = new Calendar(year, weekDay);

                    while (true) {
                        System.out.println("Event:\n1 - add\n2 - remove\n0 - exit");
                        int addEventUser = sc.nextInt();

                        if (addEventUser == 0) {
                            break;
                        }

                        System.out.print("Month of event: ");
                        int month = sc.nextInt();

                        System.out.print("Day of event: ");
                        int day = sc.nextInt();

                        if (!DateYMD.valid(day, month, userCalendar.year())) {
                            System.out.println("Invalid date.");
                            continue;
                        }

                        DateYMD dateEvent = new DateYMD(day, month, userCalendar.year());

                        if (addEventUser == 1) {
                            userCalendar.addEvent(dateEvent);
                        }

                        if (addEventUser == 2) {
                            userCalendar.removeEvent(dateEvent);
                        }
                    }
                    break;
                case 2:
                    if (userCalendar == null) {
                        System.out.println("Creat a valid calendar first.");
                        break;
                    }
                    System.out.print("Month: ");
                    int month = sc.nextInt();
                    System.out.println(userCalendar.printMonth(month));
                    break;
                case 3:
                    if (userCalendar == null) {
                        System.out.println("Creat a valid calendar first.");
                        break;
                    }
                    System.out.println(userCalendar);
                    break;
                default:
                    break;
            }
        } while (userInput != 0);
        sc.close();
    }
}
