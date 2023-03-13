package aula05;

public class DateYMD {

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
            totalMonthDays = (month % 4 == 0) ? 29 : 28;
        } else {
            totalMonthDays = 31;
        }
        return totalMonthDays;
    }

}
