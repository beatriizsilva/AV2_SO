package Av3_ProjSist;

import java.util.ArrayList;

public class LRUPageReplacement {
    
    public static int lru(ArrayList<Integer> pageSequence, int frameSize) {
        int faults = 0;
        ArrayList<Integer> memory = new ArrayList<>();
        ArrayList<Integer> lastUsed = new ArrayList<>();

        for (int page : pageSequence) {
            if (!memory.contains(page)) {
                if (memory.size() < frameSize) {
                    memory.add(page);
                    lastUsed.add(page);
                } else {
                    int leastRecentlyUsedIndex = lastUsed.indexOf(lastUsed.stream().min(Integer::compare).get());
                    memory.set(leastRecentlyUsedIndex, page);
                    lastUsed.set(leastRecentlyUsedIndex, page);
                    faults++;
                }
            } else {
                lastUsed.set(memory.indexOf(page), page);
            }
        }

        return faults;
    }
}

