import java.util.LinkedList;

public class SecondMax {
    private int maxElement(LinkedList<Integer> list, int max1, int max2) {
        if (list.isEmpty()) {
            return max1;
        }
        LinkedList<Integer> listCopy = new LinkedList<>(list);
        if (listCopy.get(0) >= max1 && listCopy.get(0) != max2) {
            max1 = listCopy.get(0);
        }
        listCopy.remove(0);
        return maxElement(listCopy, max1, max2);

    }

    public int secondMaxElement(LinkedList<Integer> list) {
        int tempMax = maxElement(list, Integer.MIN_VALUE, Integer.MIN_VALUE + 1);

        return maxElement(list, Integer.MIN_VALUE, tempMax);

    }
}
