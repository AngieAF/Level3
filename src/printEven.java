import java.util.LinkedList;

public class printEven {
    private void printEven(LinkedList<Integer> list) {
        if (list.isEmpty()) {
            return;
        }
        LinkedList listCopy = new LinkedList(list);
        listCopy.remove(0);
        listCopy.remove(0);
        System.out.println(list.get(0));
        printEven(listCopy);

    }
}
