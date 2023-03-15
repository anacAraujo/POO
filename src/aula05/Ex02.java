package aula05;

import java.util.Scanner;

class Calender {
    private int year;
    private int weekDay;
    private int[][] eventos = new int[12][31];

    public Calender(int year, int weekDay) {
        this.year = year;
        this.weekDay = weekDay;
    }

    public int getYear() {
        return year;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public int firstWeekdayOfMonth(int month) {
        DateYMD date = new DateYMD(1, month, year);
        int totalDays = 0;
        int firstWeekdayOfMonth;

        for (int i = 1; i < month; i++) {
            totalDays += date.monthDays(i, year);
        }

        return firstWeekdayOfMonth = totalDays % 7;

    }

    // TODO
    public void addEvent(DateYMD dateEvent) {
        eventos[dateEvent.getMonth()][dateEvent.getDay()] = 1;
    }

    // TODO
    public void removeEvent(DateYMD dateEvent) {
        eventos[dateEvent.getMonth()][dateEvent.getDay()] = 0;
    }

    // TODO
    public String toStringMonth(int month) {
        DateYMD date = new DateYMD(1, month, year);
        int diaSemanaAtual = weekDay;
        int diaAtual = 1;

        String[] meses = { "", "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        String nomeMes = meses[month];

        System.out.printf("%12s %6d\n", nomeMes, year);
        System.out.print("  Su Mo Tu We Th Fr Sa\n");

        for (int i = 1; i < diaSemanaAtual; i++) {
            System.out.print("   ");
        }

        for (int i = 1; i < date.monthDays(month, year); i++) {
            System.out.printf("%3d", diaAtual);
            diaAtual++;
            diaSemanaAtual++;
            if (diaSemanaAtual > 7) {
                System.out.print("\n");
                diaSemanaAtual = 1;
            }
        }
        return " ";
    }

    // TODO
    public String toStringCalendar() {
        for (int i = 1; i < 12; i++) {
            toStringCalendar();
        }
        return "";
    }
}

public class Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int userInput;
        int year;
        int month;
        int day;
        int weekDay;
        int addEventUser = 3;
        Calender userCalendar;

        do {
            System.out.println(
                    "Calendar operations:\n1 - create new calendar\n2 - print calendar month\n3 - print calendar\n0 - exit");
            userInput = sc.nextInt();

            switch (userInput) {
                case 1:
                    System.out.print("Year: ");
                    year = sc.nextInt();

                    System.out.print("Fist weekday of year: ");
                    weekDay = sc.nextInt();

                    userCalendar = new Calender(year, weekDay);

                    while (addEventUser != 0) {
                        System.out.println("Event:\n1 - add\n2 - eliminate\n0 - exit");
                        addEventUser = sc.nextInt();

                        if (addEventUser == 1) {
                            System.out.print("Month of event: ");
                            month = sc.nextInt();

                            System.out.print("Day of event: ");
                            day = sc.nextInt();

                            DateYMD dateEvent = new DateYMD(day, month, year);

                            userCalendar.addEvent(dateEvent);
                        }

                        if (addEventUser == 2) {

                        }
                    }
                    break;
                case 2:
                    System.out.print("Month: ");
                    month = sc.nextInt();
                    userCalendar.toStringMonth(month);
                    break;
                case 3:

                    break;
                default:
                    break;
            }
        } while (userInput != 0);
        sc.close();
    }
}
