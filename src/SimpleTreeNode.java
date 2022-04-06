import java.util.*;

public class SimpleTreeNode<T> {
    public T NodeValue; // значение в узле
    public SimpleTreeNode<T> Parent; // родитель или null для корня
    public List<SimpleTreeNode<T>> Children; // список дочерних узлов или null

    public SimpleTreeNode(T val, SimpleTreeNode<T> parent) {
        NodeValue = val;
        Parent = parent;
        Children = null;
    }

    @Override
    public String toString() {
        return "SimpleTreeNode{" +
                "NodeValue=" + NodeValue +
                '}';
    }
}

class SimpleTree<T> {
    public SimpleTreeNode<T> Root; // корень, может быть null

    public SimpleTree(SimpleTreeNode<T> root) {
        Root = root;
    }

    public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild) {
        // ваш код добавления нового дочернего узла существующему ParentNode
        NewChild.Parent = ParentNode;
        if (ParentNode.Children == null) {
            ParentNode.Children = new LinkedList<>();
        }
        ParentNode.Children.add(NewChild);
    }

    public void DeleteNode(SimpleTreeNode<T> NodeToDelete) {
        // ваш код удаления существующего узла NodeToDelete
        NodeToDelete.Parent.Children.remove(NodeToDelete);


    }

    public List<SimpleTreeNode<T>> GetAllNodes() {
        // ваш код выдачи всех узлов дерева в определённом порядке

        return getAllNodesRec(Root);
    }

    private List<SimpleTreeNode<T>> getAllNodesRec(SimpleTreeNode<T> node) {
        List<SimpleTreeNode<T>> list = new LinkedList<>();
        list.add(node);
        if (node.Children == null) {
            return list;
        }

        for (SimpleTreeNode<T> element : node.Children) {

            list.addAll(getAllNodesRec(element));
        }
        return list;
    }

    public List<SimpleTreeNode<T>> FindNodesByValue(T val) {
        // ваш код поиска узлов по значению
        List<SimpleTreeNode<T>> nodesList = new LinkedList<>();
        for (SimpleTreeNode<T> element : GetAllNodes()) {
            if (element.NodeValue.equals(val)) {
                nodesList.add(element);
            }
        }
        return nodesList;
    }

    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent) {
        // ваш код перемещения узла вместе с его поддеревом --
        // в качестве дочернего для узла NewParent
        DeleteNode(OriginalNode);
        AddChild(NewParent, OriginalNode);
    }

    public int Count() {
        // количество всех узлов в дереве

        return GetAllNodes().size();
    }

    public int LeafCount() {
        // количество листьев в дереве
        int count = 0;
        for (SimpleTreeNode<T> element : GetAllNodes()) {
            if (element.Children == null || element.Children.isEmpty()) {
                count++;
            }
        }
        return count;
    }
}
