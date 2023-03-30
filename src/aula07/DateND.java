package aula07;

public class DateND extends Date {
    private static final DateYMD firstDay = new DateYMD(1, 1, 2000);

    private int nDays;

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
