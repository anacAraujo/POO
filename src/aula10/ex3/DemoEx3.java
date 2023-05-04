package aula10.ex3;

import java.util.ArrayList;
import java.util.HashMap;

public class DemoEx3 {
    public static void main(String[] args) {

        String frase = "Hello World";
        HashMap<Character, ArrayList<Integer>> ocorrencias = new HashMap<>();

        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);
            if (!ocorrencias.containsKey(c)) {
                ocorrencias.put(c, new ArrayList<Integer>());
            }
            ocorrencias.get(c).add(i);
        }

        System.out.println(ocorrencias);

    }
}
