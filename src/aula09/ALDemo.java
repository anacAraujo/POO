package aula09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import aula06.DateYMD;
import aula06.Pessoa;
import aula07.Date;

public class ALDemo {
    public static void main(String[] args) {
        ArrayList<Integer> c1 = new ArrayList<>();
        for (int i = 10; i <= 100; i += 10)
            c1.add(i);
        System.out.println("Size: " + c1.size());
        for (int i = 0; i < c1.size(); i++)
            System.out.println("Elemento: " + c1.get(i));
        ArrayList<String> c2 = new ArrayList<>();
        c2.add("Vento");
        c2.add("Calor");
        c2.add("Frio");
        c2.add("Chuva");
        System.out.println(c2);
        Collections.sort(c2);
        System.out.println(c2);
        c2.remove("Frio");
        c2.remove(0);
        System.out.println(c2);
        // TODO tem de ser true
        System.out.println("Contem Calor: " + c2.contains("Calor"));
        System.out.println("Contem Frio: " + c2.contains("Frio"));

        DateYMD date = new DateYMD(1, 1, 2001);
        Set<Pessoa> c3 = new HashSet<>();
        c3.add(new Pessoa("Tomás", 11111111, date));
        c3.add(new Pessoa("Eva", 00000000, new DateYMD(20, 9, 1997)));
        c3.add(new Pessoa("João", 22222222, new DateYMD(15, 8, 2001)));
        c3.add(new Pessoa("Ana", 33333333, new DateYMD(30, 5, 2003)));
        c3.add(new Pessoa("Leonardo", 44444444, new DateYMD(7, 10, 2002)));
        c3.add(new Pessoa("Eva", 00000000, new DateYMD(20, 9, 1997)));

        System.out.println("C3: " + c3);

        // Creating an iterator
        Iterator<Pessoa> value = c3.iterator();

        // Displaying the values after iterating through the iterator
        System.out.println("The iterator values are: ");
        while (value.hasNext()) {
            System.out.println(value.next());
        }

        Set<Date> c4 = new TreeSet<>();

    }
}
