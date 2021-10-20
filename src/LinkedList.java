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

    @Override
    public String toString() {
        String str = "";
        Node element = head;
        for(int i = 0; i < count(); i++) {
            str += element.value;
            if(i < count() - 1) str += ", ";
            element = element.next;
        }

        return "[" + str + "]";
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
                if(head == tail) {
                    head = null;
                    tail = null;
                    return true;
                }
                if(node == head) head = node.next;
                else if(node == tail) {
                    tail = prev;
                    tail.next = null;
                }
                else prev.next = node.next;
                return true;
            }
            else {
                prev = node;
                node = node.next;
            }
        }
        return false;
    }

    public void removeAll(int _value) {
        // код удаления всех узлов по заданному значению
        Node node = this.head, prev = null;
        while (node != null) {
            if (node.value == _value) {
                if(head == tail) {
                    head = null;
                    tail = null;
                    return;
                }
                if(node == head) head = node.next;
                else if(node == tail) {
                    tail = prev;
                    tail.next = null;
                }
                else prev.next = node.next;
            }
            else prev = node;
            node = node.next;
        }
    }

    public void clear() {
        // код очистки всего списка
        this.head = null;
        this.tail = null;

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
        if(head == null) {
            head = _nodeToInsert;
            tail = _nodeToInsert;
            return;
        } else if(_nodeAfter == null) {         // если _nodeAfter = null, добавьте новый элемент первым в списке
            _nodeToInsert.next = head;
            head = _nodeToInsert;
            return;
        }
        else if(_nodeAfter.next == null){
            tail.next = _nodeToInsert;
            tail = _nodeToInsert;
        } else {
            _nodeToInsert.next = _nodeAfter.next;
            _nodeAfter.next = _nodeToInsert;
        }
    }



    public void printLinkedList(LinkedList linkedlist) {
        Node node = this.head;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Node head = null, tail = null;
        /*for(int i = 0; i < 7; i++){
            Node element = new Node(i);
            linkedList.addInTail(element);
        }*/
        Node element = new Node(1);
        linkedList.insertAfter(null, element);
        linkedList.printLinkedList(linkedList);
        System.out.println("\n");
        Node element2 = new Node(2);
        linkedList.insertAfter(element, element2);
        linkedList.printLinkedList(linkedList);
        linkedList.remove(2);
        System.out.println("\n");
        System.out.println(linkedList);
        linkedList.printLinkedList(linkedList);
        /*System.out.println("\n");
        linkedList.remove(3);
        linkedList.printLinkedList(linkedList);*/
    }
}

class Node {
    public int value;
    public Node next;
    public Node(int _value) {
        value = _value;
        next = null;
    }
}

