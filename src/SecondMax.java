import java.util.LinkedList;

public class SecondMax {
    private int maxElement(LinkedList<Integer> list, int tempMax) {
        if (list.isEmpty()) {
            return tempMax;
        }
        LinkedList<Integer> listCopy = new LinkedList<>(list);
        if (listCopy.get(0) >= tempMax) {
            tempMax = listCopy.get(0);
        }
        listCopy.remove(0);
        return maxElement(listCopy, tempMax);

    }

    private int secondMaxElement(LinkedList<Integer> list) {
        int tempMax = maxElement(list, Integer.MIN_VALUE);

        list.removeIf(name -> name.equals(tempMax));

        return maxElement(list, Integer.MIN_VALUE);

    }
}
