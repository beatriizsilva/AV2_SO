package Av3_ProjSist;
import java.util.ArrayList;

public class OptimalPageReplacement {

    public static int optimal(ArrayList<Integer> pageSequence, int frameSize) {
        int faults = 0;
        ArrayList<Integer> memory = new ArrayList<>();

        for (int i = 0; i < pageSequence.size(); i++) {
            int page = pageSequence.get(i);
            if (!memory.contains(page)) {
                if (memory.size() < frameSize) {
                    memory.add(page);
                } else {
                    int farthestUsedIndex = -1;
                    int farthestUsedPage = -1;
                    for (int j = 0; j < memory.size(); j++) {
                        int nextPageIndex = getNextAppearanceIndex(pageSequence, i + 1, memory.get(j));
                        if (nextPageIndex == -1) {
                            farthestUsedIndex = j;
                            break;
                        } else if (nextPageIndex > farthestUsedPage) {
                            farthestUsedIndex = j;
                            farthestUsedPage = nextPageIndex;
                        }
                    }
                    memory.set(farthestUsedIndex, page);
                    faults++;
                }
            }
        }

        return faults;
    }

    private static int getNextAppearanceIndex(ArrayList<Integer> pageSequence, int startIndex, int page) {
        for (int i = startIndex; i < pageSequence.size(); i++) {
            if (pageSequence.get(i) == page) {
                return i;
            }
        }
        return -1;
    }
}
