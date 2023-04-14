package aula08.Ex02;

import java.util.Map;
import java.util.TreeMap;

enum DiaSemana {
    SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO
}

public class Ementa {
    private String nome;
    private String local;
    private Map<DiaSemana, Prato> pratos;

    public Ementa(String nome, String local) {
        this.nome = nome;
        this.local = local;
        pratos = new TreeMap<>();
    }

    public void addPrato(Prato prato, DiaSemana dia) {
        pratos.put(dia, prato);
    }

    @Override
    public String toString() {
        String result = this.nome + " em " + this.local + "\n";
        // for (Map.Entry<DiaSemana, Prato> produto : pratos.entrySet()) {
        // result += produto.getValue() + ", dia " + produto.getKey() + "\n";
        // }
        for (DiaSemana diaSemana : DiaSemana.values()) {
            result += pratos.get(diaSemana).toString() + ", dia " + diaSemana + "\n";
        }
        return result;
    }
}