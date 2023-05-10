package aula11.ex2;

import java.util.List;

public class SimpleGradeCalculator implements IGradeCalculator {

    @Override
    public double calculate(List<Double> grades) {
        double media = 0;
        for (Double grade : grades) {
            media += grade;
        }
        media = media / grades.size();

        return media;
    }

}
