import java.util.*;

public class Queue<T>
{
    public Node<T> head;
    public Node<T> tail;

    public Queue()
    {
        // инициализация внутреннего хранилища очереди
        head = null;
        tail = null;
    }

    public void enqueue(T item)
    {
        // вставка в хвост
        Node temp = new Node<>(item);

        if (head == null) {
            head = temp;
        } else {
            tail.next = temp;
        }
        tail = temp;
    }

    public T dequeue()
    {
        // выдача из головы
        if (head == null) {
            return null; // null если очередь пустая
        } else {
            T value = head.value;
            head = head.next;

            return value;
        }

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

    /*public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        //System.out.println(queue.size());
        System.out.println(queue.dequeue());
    }*/

    public class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T _value) {
            value = _value;
            next = null;
        }

    }

}
