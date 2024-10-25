package Av3_ProjSist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ClockPageReplacement {

    public static int clock(ArrayList<Integer> pageSequence, int frameSize) {
        Queue<Integer> pageQueue = new LinkedList<>();
        boolean[] referenced = new boolean[frameSize];
        int[] memory = new int[frameSize];
        int faults = 0;
        int hand = 0;

        for (int page : pageSequence) {
            boolean pageFound = false;

            for (int i = 0; i < memory.length; i++) {
                if (memory[i] == page) {
                    pageFound = true;
                    referenced[i] = true;
                    break;
                }
            }

            if (!pageFound) {
                while (referenced[hand]) {
                    referenced[hand] = false;
                    hand = (hand + 1) % frameSize;
                }

                if (memory[hand] != 0) {
                    faults++;
                }

                memory[hand] = page;
                referenced[hand] = true;
                hand = (hand + 1) % frameSize;
            }
        }

        return faults;
    }
}
