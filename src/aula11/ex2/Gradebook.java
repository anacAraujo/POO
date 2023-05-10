package aula11.ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Gradebook {
    TreeMap<String, Student> turma = new TreeMap<>();
    SimpleGradeCalculator calculator = new SimpleGradeCalculator();

    public void load(String path) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(path));

            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                String[] alunoArray = linha.split("\\|");

                List<Double> notas = new ArrayList<>();
                for (int i = 1; i < alunoArray.length; i++) {
                    notas.add(Double.parseDouble(alunoArray[i]));
                }
                addStudent(new Student(alunoArray[0], notas));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não existente!");
        } finally {
            if (sc != null)
                sc.close();
        }
    }

    public void addStudent(Student newStudent) {
        turma.put(newStudent.getName(), newStudent);
    }

    public void removeStudent(String name) {
        turma.remove(name);
    }

    public Student getStudent(String name) {
        return turma.get(name);
    }

    public double calculateAverageGrade(String name) {
        List<Double> grades = turma.get(name).getGrades();

        return calculator.calculate(grades);
    }

    public void printAllStudents() {
        String result = "";
        for (Student aluno : turma.values()) {
            List<Double> grades = aluno.getGrades();
            result += String.format("Nome: %s; Notas: %s; Média: %.2f\n",
                    aluno.getName(),
                    grades.toString(),
                    calculateAverageGrade(aluno.getName()));
        }
        System.out.println(result);
    }
}
