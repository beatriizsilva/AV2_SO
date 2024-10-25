package Av3_ProjSist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FIFOPageReplacement {
    
    public static int fifo(ArrayList<Integer> pageSequence, int frameSize) {
        Queue<Integer> pageQueue = new LinkedList<>();
        int faults = 0;

        for (int page : pageSequence) {
            if (!pageQueue.contains(page)) {
                if (pageQueue.size() < frameSize) {
                    pageQueue.offer(page);
                } else {
                    pageQueue.poll();
                    pageQueue.offer(page);
                    faults++;
                }
            }
        }

        return faults;
    }
}

