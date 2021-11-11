import java.util.*;

public class Stack<T>
{
    private Node<T> head;

    public Stack()
    {
        // инициализация внутреннего хранилища стека
        head = null;
    }

    public int size()
    {
        // размер текущего стека
        Node<T> node = this.head;
        int elementCounter = 0;
        while (node != null) {
            elementCounter++;
            node = node.next;
        }

        return elementCounter;
    }

    public T pop()
    {
        if (head == null) {
            return null;
        }
        T value = head.value;
        head = head.next;

        return value;
    }

    public void push(T val)
    {
        head = new Node<>(val, head);
    }

    public T peek()
    {
        if (head == null) {
            return null;
        }
      return head.value;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        //stack.push(4);
        //stack.push(2);
        System.out.println(stack.size());
        System.out.println(stack.peek());
        System.out.println(stack.pop());

    }

    public class Node <T> {

        private T value;
        private Node<T> next;

        public Node(T _value, Node<T> next) {
            value = _value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

    }
}

