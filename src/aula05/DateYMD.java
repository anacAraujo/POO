package aula05;

public class DateYMD {

    public boolean validMonth(int month) {
        if (month >= 1 && month <= 12) {
            return true;
        }
        return false;
    }
}
