package aula07;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int userOption;

        DateYMD userDateYMD = null;

        boolean isValid = false;

        do {
            System.out.println(
                    "Date operations:\n1 - create new date\n2 - show current date\n3 - increment date\n4 - decrement date\n5 - how many days away to 2000\n0 - exit");
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
                case 5:
                    if (userDateYMD == null) {
                        System.out.println("Enter a valid date first.");
                        break;
                    }
                    DateND count = new DateND(userDateYMD);
                    count.countND();
                    System.out.println(count.toString());
                    break;
                default:
                    break;
            }
        } while (userOption != 0);

        sc.close();
    }
}
