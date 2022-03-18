import java.util.LinkedList;

public class printEvenValues {
    private void printEvenValues(LinkedList<Integer> list) {
        if (list.isEmpty()) {
            return;
        }
        LinkedList<Integer> listCopy = new LinkedList<>(list);
        if (listCopy.get(0) % 2 == 0) {
            System.out.println(listCopy.get(0));
        }
        listCopy.remove(0);
        printEvenValues(listCopy);
    }
}
