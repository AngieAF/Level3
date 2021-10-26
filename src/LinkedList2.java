import java.util.*;

public class LinkedList2
{
    public Node head;
    public Node tail;

    public LinkedList2()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item)
    {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
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

    public Node find(int _value)
    {
        // поиск узла по заданному значению
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value)
    {
        // поиск всех узлов по заданному значению
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        // код удаления одного узла по заданному значению
        Node node = this.head, prev = null;

        while (node != null) {
            if (node.value == _value) {
                if (head == tail) { // one element in the list
                    head = null;
                    tail = null;
                    return true;
                }
                if (node == head) { // remove first element
                    head = node.next;
                    head.prev = null;
                }
                else if (node == tail) { // remove last element
                    tail = prev;
                    tail.next = null;
                    tail.prev = prev.prev;
                }
                else {
                    prev.next = node.next;
                    node.next.prev = prev;
                }
                return true;
            }
            else {
                prev = node;
                node = node.next;
            }
        }
        return false;
    }

    public void removeAll(int _value)
    {
        // код удаления всех узлов по заданному значению
        Node node = this.head, prev = null;
        while (node != null) {
            if (node.value == _value) {
                if(head == tail) {
                    head = null;
                    tail = null;
                    return;
                }
                if(node == head) {
                    head = node.next;
                    head.prev = null;
                }
                else if(node == tail) {
                    tail = prev;
                    tail.next = null;
                    tail.prev = prev.prev;
                }
                else {
                    prev.next = node.next;
                    node.next.prev = prev;
                }
            }
            else prev = node;
            node = node.next;
        }
    }

    public void clear()
    {
        // код очистки всего списка
        this.head = null;
        this.tail = null;
    }

    public int count()
    {
        // код подсчёта количества элементов в списке
        Node node = this.head;
        int elementCounter = 0;
        while (node != null) {
            elementCounter++;
            node = node.next;
        }
        return elementCounter;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        // код вставки узла после заданного узла
        if(head == null) { // if the list is empty
            head = _nodeToInsert;
            tail = _nodeToInsert;
            this.head.next = null;
            this.head.prev = null;
            return;
        } else if(_nodeAfter == null) {  // если _nodeAfter = null, добавьте новый элемент первым в списке
            _nodeToInsert.next = head;
            head = _nodeToInsert;
            _nodeToInsert.prev = null;
            return;
        }
        else if(_nodeAfter.next == null) { // the element is added in tail
            this.tail.next = _nodeToInsert;
            _nodeToInsert.prev = tail;
            this.tail = _nodeToInsert;

        } else {
            _nodeToInsert.next = _nodeAfter.next;
            _nodeAfter.next = _nodeToInsert;
            _nodeToInsert.prev = _nodeAfter;
            _nodeToInsert.next.prev = _nodeToInsert;
        }

    }

}

class Node
{
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}