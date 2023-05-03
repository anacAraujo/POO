package aula10.ex2;

import aula10.ex1.Book;

import java.util.ArrayList;
import java.util.TreeMap;

public class DemoEx2 {
    public static void main(String[] args) {
        TreeMap<String, ArrayList<Book>> lista = new TreeMap<String, ArrayList<Book>>();

        lista.put("Drama", new ArrayList<Book>());
        lista.get("Drama").add(new Book("Click", "Kayla Miller", 2007));
        lista.get("Drama").add(new Book("Kcilc", "Miller Kayla", 7002));

        lista.put("Comédia", new ArrayList<Book>());
        lista.get("Comédia").add(new Book("Bossypants", "Tina Fey", 2011));
        lista.get("Comédia").add(new Book("Pantsbossy", "Fey Tina", 2022));

        lista.put("Terror", new ArrayList<Book>());
        lista.get("Terror").add(new Book("Frankenstein", "OLD", 2018));

        lista.put("Romance", new ArrayList<Book>());
        lista.get("Romance").add(new Book("Happy Place", "Ron Miller", 2005));

        lista.put("Animação", new ArrayList<Book>());
        lista.get("Animação").add(new Book("Dora", "Dora", 2009));

        lista.remove("Animação");

        for (String genero : lista.keySet()) {
            String key = genero;
            String value = "";
            for (int i = 0; i < lista.get(genero).size(); i++) {
                value += String.format("%s\n",
                        lista.get(genero).toArray()[i].toString());
            }
            System.out.println(
                    String.format("%s\n%s",
                            key,
                            value));
        }

        System.out.println("\nGeneros:");
        for (String genero : lista.keySet()) {
            System.out.println(
                    String.format("%s",
                            genero));
        }

        System.out.println("\nLivros:");
        for (String genero : lista.keySet()) {
            for (int i = 0; i < lista.get(genero).size(); i++) {
                System.out.println(
                        String.format("%s",
                                lista.get(genero).toArray()[i].toString()));
            }

        }
    }
}
