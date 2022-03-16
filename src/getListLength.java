import java.util.LinkedList;
import java.util.NoSuchElementException;

public class getListLength {
    public int getListLength(LinkedList<Integer> list1) {
        try {
            list1.pop();
        } catch (NoSuchElementException e) {
            return 0;
        }
        return 1 + getListLength(list1);
    }
}
