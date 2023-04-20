package aula09;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

public class CollectionTester {
    public static void main(String[] args) {
        String table = "";

        String[] opration = { "add", "search", "remove" };

        int[] DIM = { 1000, 5000, 10000, 20000, 40000, 100000 };
        Collection[] collections = { new ArrayList<>(), new LinkedList<>(), new HashSet<>(), new TreeSet<>(),
                new Stack<>(), new ArrayDeque<>() };

        table += String.format("%10s", "Collection");

        for (int i = 0; i < DIM.length; i++) {
            table += String.format("%10d", DIM[i]);
        }

        for (int c = 0; c < collections.length; c++) {
            HashMap<Integer, Double[]> performance = new HashMap<Integer, Double[]>();

            Collection<Integer> col = collections[c];

            for (int i = 0; i < DIM.length; i++) {
                Double[] results = checkPerformance(col, DIM[i]);
                performance.put(DIM[i], results);
            }

            table += "\n" + col.getClass().getSimpleName() + "\n";

            for (int op = 0; op < opration.length; op++) {
                table += String.format("%10s", opration[op]);

                for (int i = 0; i < DIM.length; i++) {
                    table += String.format("%10.1f", performance.get(DIM[i])[op]);
                }
                table += "\n";
            }
        }

        System.out.println(table);
    }

    private static Double[] checkPerformance(Collection<Integer> col, int DIM) {
        double start, stop, add, search, remove;
        Double[] resultados = new Double[3];
        // Add
        start = System.nanoTime(); // clock snapshot before
        for (int i = 0; i < DIM; i++)
            col.add(i);
        stop = System.nanoTime(); // clock snapshot after
        add = (stop - start) / 1e6; // convert to milliseconds
        // System.out.println(col.size() + ": Add to " +
        // col.getClass().getSimpleName() + " took " + add + "ms");
        // Search
        start = System.nanoTime(); // clock snapshot before
        for (int i = 0; i < DIM; i++) {
            int n = (int) (Math.random() * DIM);
            if (!col.contains(n))
                System.out.println("Not found???" + n);
        }
        stop = System.nanoTime(); // clock snapshot after
        search = (stop - start) / 1e6; // convert nanoseconds to milliseconds
        // System.out.println(col.size() + ": Search to " +
        // col.getClass().getSimpleName() + " took " + search + "ms");
        // Remove
        start = System.nanoTime(); // clock snapshot before
        Iterator<Integer> iterator = col.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        stop = System.nanoTime(); // clock snapshot after
        remove = (stop - start) / 1e6; // convert nanoseconds to milliseconds
        // System.out.println(col.size() + ": Remove from " +
        // col.getClass().getSimpleName() + " took " + remove + "ms");

        resultados[0] = add;
        resultados[1] = search;
        resultados[2] = remove;
        return resultados;
    }
}
