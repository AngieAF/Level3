import java.util.LinkedList;

public class SecondMax {
    private int secondMaxElement(LinkedList<Integer> list) {
        LinkedList<Integer> listCopy = new LinkedList<>(list);
        int max = getMaxRec(listCopy, list.get(0));
        boolean isMax2Empty = true;

        int max2 = 0;
        for (int i = 0; i < list.size(); i++) {
            if (isMax2Empty) {
                if (list.get(i) != max) {
                    max2 = list.get(i);
                    isMax2Empty = false;
                }
            } else {
                if (list.get(i) > max2 && list.get(i) != max) {
                    max2 = list.get(i);
                }
            }
        }
        return max2;
    }

    private int getMaxRec(LinkedList<Integer> list, int max) {
        if (list.isEmpty()) {
            return max;
        }
        int value = list.remove(0);
        return getMaxRec(list, Math.max(value, max));
    }
}
