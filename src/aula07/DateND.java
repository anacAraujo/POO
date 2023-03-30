package aula07;

public class DateND extends Date {
    private static final DateYMD firstDay = new DateYMD(1, 1, 2000);

    private int nDays;
    private DateYMD data;

    public DateND(DateYMD data) {
        if (!valid(data.getDay(), data.getMonth(), data.getYear())) {
            System.out.println("Invalid date.");
            return;
        }
        this.nDays = 0;
        this.data.setDate(data.getDay(), data.getMonth(), data.getYear());
    }

    public int countND() {
        int totalYears;

        if (data.getYear() > firstDay.getYear()) {
            totalYears = data.getYear() - firstDay.getYear();

            for (int i = 0; i < totalYears; i++) {
                this.nDays += leapYear(firstDay.getYear() + i) ? 366 : 365;

                for (int j = 0; j < data.getMonth(); j++) {
                    this.nDays += monthDays(firstDay.getMonth() + j, firstDay.getYear() + j);
                }
            }
        } else if (data.getYear() < firstDay.getYear()) {
            totalYears = firstDay.getYear() - data.getYear();
            for (int i = 0; i < totalYears; i++) {
                this.nDays += leapYear(firstDay.getYear() - i) ? 366 : 365;

                for (int j = 0; j < data.getMonth(); j++) {
                    this.nDays += monthDays(firstDay.getMonth() + j, firstDay.getYear() + j);
                }
            }
        } else if (data.getYear() == firstDay.getYear()) {
            for (int j = 0; j < data.getMonth(); j++) {
                this.nDays += monthDays(firstDay.getMonth() + j, firstDay.getYear() + j);
            }
        }

        this.nDays += data.getDay();

        return this.nDays;

    }

    @Override
    public String toString() {
        return String.format("Em relação ao dia 1-1-2000, o dia %s fica a %d dias.",
                super.toString(data.getDay(), data.getMonth(), data.getYear()),
                this.nDays);
    }
}
