import java.util.*;


public class LinkedList {

    public Node head;
    public Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        // код поиска всех узлов
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                nodes.add(node);
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        // код удаления одного узла по заданному значению
        Node node = this.head, prev = null;
        while (node != null) {
            if (node.value == _value) {
                if(node == head) {
                    head = node.next;
                    return true;
                } else {
                    prev.next = node.next;
                    return true;
                }
            }
            else {
                prev = node;
                node = node.next;
            }
        }
        return true; // если узел был удалён
    }

    public void removeAll(int _value) {
        // код удаления всех узлов по заданному значению
        Node node = this.head, prev = null;
        while (node != null) {
            if (node.value == _value) {
                if(node == head) {
                    head = node.next;
                } else {
                    prev.next = node.next;
                }
                node = node.next;
            }
            else {
                prev = node;
                node = node.next;
            }
        }
    }

    public void clear() {
        // код очистки всего списка
        this.head = null;

    }

    public int count() {
        Node node = this.head;
        int elementCounter = 0;
        while (node != null) {
            elementCounter++;
            node = node.next;
        }

        return elementCounter; // код подсчёта количества элементов в списке
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        // код вставки узла после заданного
        if(_nodeAfter == null) {
            _nodeToInsert.next = head;
            head = _nodeToInsert;
        }
        else {
            _nodeToInsert.next = _nodeAfter.next;
            _nodeAfter.next = _nodeToInsert;
        }
        // если _nodeAfter = null,
        // добавьте новый элемент первым в списке
    }

    public void printLinkedList(LinkedList linkedlist) {
        Node node = this.head;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }

    /*public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Node head, tail = null;
        Node first = new Node(5);
        Node second = new Node(10);
        Node third = new Node(2);
        Node fourth = new Node(2);
        Node fifth = new Node(11);
        linkedList.addInTail(first);
        linkedList.addInTail(second);
        linkedList.addInTail(third);
        linkedList.addInTail(fourth);
        //System.out.println(linkedList.findAll(2));
        //System.out.println(linkedList.count());
        linkedList.printLinkedList(linkedList);
        //linkedList.clear();
        //System.out.println("\n" + linkedList);
        Node _nodeToInsert = new Node(0);
        linkedList.insertAfter(fifth, _nodeToInsert);
        linkedList.printLinkedList(linkedList);
        System.out.println("\n");
        linkedList.remove(5);
        linkedList.printLinkedList(linkedList);
        System.out.println("\n");
        linkedList.removeAll(2);
        linkedList.printLinkedList(linkedList);
    }*/
}

class Node {
    public int value;
    public Node next;
    public Node(int _value) {
        value = _value;
        next = null;
    }
}

