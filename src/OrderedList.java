import java.util.*;


class Node<T>
{
    public T value;
    public Node<T> next, prev;

    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T>
{
    public Node<T> head, tail;
    private boolean _ascending;

    public OrderedList(boolean asc)
    {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2)
    {
        if (v1 instanceof Integer && v2 instanceof Integer) {
            Integer i1 = (Integer) v1;
            Integer i2 = (Integer) v2;
            return Integer.compare(i1, i2);
        }

        if (v1 instanceof String && v2 instanceof String) {
            String s1 = (String) v1;
            String s2 = (String) v2;
            if (s1.trim().compareTo(s2.trim()) > 0) {
                return 1;
            } else if (s1.trim().compareTo(s2.trim()) < 0) {
                return -1;
            } else return 0;
        }

        throw new IllegalArgumentException();
    }

    public void add(T value)
    {
        // автоматическая вставка value
        // в нужную позицию
        Node<T> node = head;
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            while (node != null && compare(value, node.value) == (_ascending ? 1 : -1)) {
                node = node.next;
            }
            if (node == null) {
                newNode.prev = tail;
                tail.next = newNode;
                tail = newNode;
                tail.next = null;
            } else {
                Node<T> prev = node.prev;
                if (prev == null) {
                    head = newNode;
                    head.next = node;
                    node.prev = newNode;
                } else {
                    prev.next = newNode;
                    newNode.prev = prev;
                    newNode.next = node;
                    node.prev = newNode;
                }

            }
        }
    }

    public Node<T> find(T val)
    {
        Node<T> node = head;
        while (node != null) {
            if (node.value == val) {
                return node;
            }

            if (compare(val, node.value) == (_ascending ? 1 : -1)) {
                node = node.next;
            } else {
                break;
            }
        }
        return null;
    }

    public void delete(T val)
    {
        // код удаления одного узла по заданному значению
        Node node = head, prev = null;

        while (node != null) {
            if (node.value == val) {
                if (head == tail) { // one element in the list
                    head = null;
                    tail = null;
                    break;
                }
                if (node == head) { // remove first element
                    head = node.next;
                    head.prev = null;
                    break;
                }
                else if (node == tail) { // remove last element
                    tail = prev;
                    tail.next = null;
                    tail.prev = prev.prev;
                    break;
                }
                else {
                    prev.next = node.next;
                    node.next.prev = prev;
                    break;
                }
            }
            else {
                prev = node;
                node = node.next;
            }
        }
    }

    public void clear(boolean asc)
    {
        _ascending = asc;
        head = null;
        tail = null;
    }

    public int count()
    {
        Node node = head;
        int elementCounter = 0;

        while (node != null) {
            elementCounter++;
            node = node.next;
        }
        return elementCounter; // код подсчёта количества элементов в списке
    }

    ArrayList<Node<T>> getAll() // выдать все элементы упорядоченного
    // списка в виде стандартного списка
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while(node != null)
        {
            r.add(node);
            node = node.next;
        }
        return r;
    }

    @Override
    public String toString() {
        String str = "";
        Node<T> node = head;

        while (node != null) {
            str += node.value;
            str += ", ";
            node = node.next;
        }
        return "[" + str + "]";
    }


    /*public static void main(String[] args) {
        OrderedList<String> orderedList = new OrderedList<>(true);
        orderedList.add("a");
        orderedList.add("z");
        System.out.println(orderedList.compare("z", "a"));
        System.out.println(orderedList.toString());
        orderedList.add(2);
        orderedList.delete(2);
        orderedList.clear(false);

    }*/
}
