import java.util.LinkedList;

public class SecondMax {
    public int secondMaxElement(LinkedList<Integer> list) {
        LinkedList<Integer> listCopy = new LinkedList<>(list);

        return getMaxRec(listCopy, 0, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    private int getMaxRec(LinkedList<Integer> list, int index, int largest, int secondLargest) {
        if (index == list.size()) {
            return secondLargest;
        }
        int element = list.get(index);

        if (element > secondLargest && element > largest) {
                return getMaxRec(list, index + 1, element, largest);
            } else if (element > secondLargest && element < largest) {
                return getMaxRec(list, index + 1, largest, element);
            }
        return getMaxRec(list, index + 1, largest, secondLargest);
    }
}
