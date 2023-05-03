package aula10.ex1;

import java.util.HashMap;

public class DemoEx1 {
    public static void main(String[] args) {
        HashMap<String, Book> lista = new HashMap<>();
        lista.put("Drama", new Book("Click", "Kayla Miller", 2007));
        lista.put("Comédia", new Book("Bossypants", "Tina Fey", 2011));
        lista.put("Terror", new Book("Frankenstein", "OLD", 2018));
        lista.put("Romance", new Book("Happy Place", "Ron Miller", 2005));
        lista.put("Animação", new Book("Dora", "Dora", 2009));

        lista.remove("Animação");

        lista.replace("Terror", new Book("Frankenstein", "NEW", 2018));

        for (String genero : lista.keySet()) {
            String key = genero;
            String value = lista.get(genero).toString();
            System.out.println(
                    String.format("%s - %s",
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
            System.out.println(
                    String.format("%s",
                            lista.get(genero).toString()));
        }
    }
}
