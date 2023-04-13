package aula08.Ex02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ementa {
    public enum DiaSemana {
        domingo, segunda, terca, quarta, quinta, sexta, sabado
    }

    private String nome;
    private String local;
    private Map<Prato, String> pratos;

    public Ementa(String nome, String local) {
        this.nome = nome;
        this.local = local;
        pratos = new HashMap<>();
    }

    public void addPrato(Prato prato, String dia) {
        pratos.entrySet();
    }

    @Override
    public String toString() {
        String result = "";
        for (Prato prato : pratos) {
            result = prato.toString() + "\n";
        }
        return result;
    }
}
