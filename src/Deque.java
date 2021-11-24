//import java.util.*;

public class Deque<T>
{
    private Node<T> head;
    private Node<T> tail;

    public Deque()
    {
        // инициализация внутреннего хранилища
        head = null;
        tail = null;
    }

    public T getHead() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    public T getTail() {
        if (tail == null) {
            return null;
        }
        return tail.value;
    }

    public void addFront(T item)
    {
        // добавление в голову
        Node<T> node = head;
        if (head == null) {
            head = new Node<>(item);
            tail = head;
        } else {
            head = new Node<>(item);
            head.next = node;
        }

    }

    public void addTail(T item)
    {
        // добавление в хвост
        Node temp = new Node<>(item);

        if (head == null) {
            head = temp;
        } else {
            tail.next = temp;
        }
        tail = temp;

    }

    public T removeFront()
    {
        // удаление из головы
        if (head == null) {
            return null;
        } else {
            T value = head.value;
            head = head.next;
            return value;
        }

    }

    public T removeTail()
    {
        // удаление из хвоста
        Node<T> node = head;
        Node<T> prev = null;
        T value = null;

        if (head == null) {
            return null;
        }

        while (node != null) {
            if (node == tail) {
                value = tail.value;
                if (head == tail) {
                    head = null;
                    tail = null;
                    return value;
                }
                tail = prev;
                tail.next = null;
            }
            prev = node;
            node = node.next;

        }
        return value;
    }

    public int size()
    {
        Node<T> node = head;
        int elementCounter = 0;

        while (node != null) {
            elementCounter++;
            node = node.next;
        }
        return elementCounter; // размер очереди
    }

    public String printDeque() {
        String str = "";
        Node<T> node = head;
        int count = 0;

        while (node != null) {
            str += node.value;
            count++;
            if (count < size()) {
                str += ", ";
            }
            node = node.next;
        }

        return "[" + str + "]";
    }

    /*public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.addTail(1);
        //System.out.println("Head: " + deque.head.value + " Tail: " + deque.tail.value);
        //deque.addTail(2);
        //System.out.println("Head: " + deque.head.value + " Tail: " + deque.tail.value);
        //System.out.println("Size " + deque.size());
        //deque.printDeque();

        //deque.addFront(10);
        //System.out.println("Head: " + deque.head.value + " Tail: " + deque.tail.value);
        //deque.printDeque();
        //System.out.println("Size " + deque.size());

        /*deque.removeTail();
        deque.printDeque();
        System.out.println("Head: " + deque.head.value + " Tail: " + deque.tail.value);
        System.out.println("Size " + deque.size());

        deque.removeTail();
        deque.printDeque();
        System.out.println("Head: " + deque.head.value + " Tail: " + deque.tail.value);
        System.out.println("Size " + deque.size());

        System.out.println(deque.removeTail());
        //deque.printDeque();
        //System.out.println("Head: " + deque.head.value + " Tail: " + deque.tail.value);
        System.out.println("Size " + deque.size());


    } */

    private class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T _value) {
            value = _value;
            next = null;
        }
    }
}


