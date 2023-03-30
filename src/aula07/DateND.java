package aula07;

public class DateND extends Date {
    private static final DateYMD firstDay = new DateYMD(1, 1, 2000);

    private int nDays;
    private DateYMD data;

    public DateND(DateYMD dataUser) {
        if (!valid(dataUser.getDay(), dataUser.getMonth(), dataUser.getYear())) {
            System.out.println("Invalid date.");
            return;
        }
        this.nDays = 0;
        this.data = new DateYMD(dataUser.getDay(), dataUser.getMonth(), dataUser.getYear());
    }

    public int countND() {
        int totalYears;

        if (data.getYear() > firstDay.getYear()) {
            totalYears = data.getYear() - firstDay.getYear() - 1;

            for (int i = 0; i < totalYears; i++) {
                this.nDays += leapYear(firstDay.getYear() + i) ? 366 : 365;

                for (int j = 1; j <= 12; j++) {
                    this.nDays += monthDays(j, firstDay.getYear() + i);
                }
            }

        } else if (data.getYear() < firstDay.getYear()) {
            totalYears = firstDay.getYear() - data.getYear() - 1;

            for (int i = 0; i < totalYears; i++) {
                this.nDays += leapYear(firstDay.getYear() - i) ? 366 : 365;

                for (int j = 1; j <= 12; j++) {
                    this.nDays += monthDays(j, firstDay.getYear() + i);
                }
            }
        } else if (data.getYear() == firstDay.getYear()) {
            for (int j = 1; j <= 12; j++) {
                this.nDays += monthDays(j, firstDay.getYear());
            }
        }

        if (data.getMonth() > 1) {
            for (int i = 1; i < data.getMonth(); i++) {
                this.nDays += monthDays(i, data.getYear());
            }
        }

        this.nDays += data.getDay() - 1;

        return this.nDays;

    }

    @Override
    public String toString() {
        return String.format("Em relação ao dia 1-1-2000, o dia %s fica a %d dias.",
                super.toString(data.getDay(), data.getMonth(), data.getYear()),
                this.nDays);
    }
}
