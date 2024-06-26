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
        System.out.println("C1");
        ArrayList<Integer> c1 = new ArrayList<>();
        for (int i = 10; i <= 100; i += 10)
            c1.add(i);
        System.out.println("Size: " + c1.size());
        for (int i = 0; i < c1.size(); i++)
            System.out.println("Elemento: " + c1.get(i));

        System.out.println("\nC2");
        ArrayList<String> c2 = new ArrayList<>();
        c2.add("Vento");
        c2.add("Calor");
        c2.add("Frio");
        c2.add("Chuva");
        System.out.println(c2);
        System.out.println("Indice Chuva: " + c2.indexOf("Chuva"));
        Collections.sort(c2);
        System.out.println("Sorted: " + c2);
        c2.remove("Frio");
        c2.remove(0);
        System.out.println(c2);
        System.out.println("Contem Chuva: " + c2.contains("Chuva"));
        System.out.println("Contem Frio: " + c2.contains("Frio"));
        System.out.println(c2.lastIndexOf("Chuva"));

        System.out.println("\nC3");
        Set<Pessoa> c3 = new HashSet<>();
        c3.add(new Pessoa("Tomas", 11111111, new DateYMD(1, 1, 2001)));
        c3.add(new Pessoa("Eva", 55555555, new DateYMD(20, 9, 1997)));
        c3.add(new Pessoa("Joao", 22222222, new DateYMD(15, 8, 2001)));
        c3.add(new Pessoa("Ana", 33333333, new DateYMD(30, 5, 2003)));
        c3.add(new Pessoa("Leonardo", 44444444, new DateYMD(7, 10, 2002)));
        c3.add(new Pessoa("Eva", 55555555, new DateYMD(20, 9, 1997)));
        System.out.println(c3);
        Iterator<Pessoa> iterator = c3.iterator();
        System.out.println("Valores iterador: ");
        while (iterator.hasNext()) {
            Pessoa pessoa = iterator.next();
            System.out.println(pessoa.toString() + " " + pessoa.hashCode());
        }

        System.out.println("\nC4");
        Set<Date> c4 = new TreeSet<Date>();
        c4.add(new aula07.DateYMD(3, 3, 1983));
        c4.add(new aula07.DateYMD(3, 3, 2012));
        c4.add(new aula07.DateYMD(3, 3, 1999));
        c4.add(new aula07.DateYMD(3, 3, 2130));
        // c4.add(new aula07.DateND(new aula07.DateYMD(3, 3, 2030)));
        c4.add(new aula07.DateYMD(3, 3, 2030));
        System.out.println(c4);
    }
}
