import java.util.LinkedList;

public class SecondMax {
    public int secondMaxElement(LinkedList<Integer> list) {

        Integer largest = getMaxRec(list, 0, list.get(0));

        while (list.remove(largest)) {

        }
        return getMaxRec(list, 0, list.get(0));

    }

    private int getMaxRec(LinkedList<Integer> list, int index, int largest) {
        if (index == list.size()) {
            return largest;
        }
        int element = list.get(index);

        if (element > largest) {
            return getMaxRec(list, index + 1, element);
        }
        return getMaxRec(list, index + 1, largest);
    }
}
