package Av3_ProjSist;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Sequência de páginas de exemplo
        ArrayList<Integer> pageSequence = new ArrayList<>();
        pageSequence.add(1);
        pageSequence.add(2);
        pageSequence.add(3);
        pageSequence.add(1);
        pageSequence.add(4);
        pageSequence.add(1);
        pageSequence.add(2);
        pageSequence.add(8);
        pageSequence.add(2);
        pageSequence.add(1);
        pageSequence.add(3);
        pageSequence.add(6);
        pageSequence.add(5);

        // Tamanho do quadro
        int frameSize = 3;

        // Testar cada algoritmo e exibir o número de faltas de página
        System.out.println("FIFO: " + FIFOPageReplacement.fifo(new ArrayList<>(pageSequence), frameSize) + " faltas de página");
        System.out.println("LRU: " + LRUPageReplacement.lru(new ArrayList<>(pageSequence), frameSize) + " faltas de página");
        System.out.println("Clock: " + ClockPageReplacement.clock(new ArrayList<>(pageSequence), frameSize) + " faltas de página");
        System.out.println("Ótimo: " + OptimalPageReplacement.optimal(new ArrayList<>(pageSequence), frameSize) + " faltas de página");
    }
}

