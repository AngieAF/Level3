import java.util.LinkedList;

public class getListLength {
    private int getListLength(LinkedList<Integer> list1) {
        int length = 0;
        try {
            list1.pop();
            System.out.println(length);
            return length + getListLength(list1);
        }

        catch (Exception e) {
            return length;
        }
    }
}
