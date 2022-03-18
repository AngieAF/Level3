import java.util.LinkedList;

public class printEven {
    private void printEven(LinkedList<Integer> list) {
        if (list.isEmpty()) {
            return;
        }
        LinkedList<Integer> listCopy = new LinkedList<>(list);
        System.out.println(listCopy.remove(0));
        if (!listCopy.isEmpty()) {
            listCopy.remove(0);
        }
        printEven(listCopy);

    }
}
