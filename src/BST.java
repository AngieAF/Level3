import java.io.*;
import java.util.*;

class BSTNode<T> {
    public int NodeKey;
    public T NodeValue;
    public BSTNode<T> Parent;
    public BSTNode<T> LeftChild;
    public BSTNode<T> RightChild;
    public BSTNode(int key, T val, BSTNode<T> parent) {
        NodeKey = key;
        NodeValue = val;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}
class BSTFind<T> {
    public BSTNode<T> Node;
    public boolean NodeHasKey;
    public boolean ToLeft;
    public BSTFind() {
        Node = null;
    }
}
class BST<T> {
    BSTNode<T> Root;
    private int count;
    public BST(BSTNode<T> node) {
        Root = node;
        count = 1;
    }
    public BSTFind<T> FindNodeByKey(int key) {
        return find(Root, key);
    }
    private BSTFind<T> find(BSTNode<T> node, int key) {
        BSTFind<T> bstFind = new BSTFind<>();
        bstFind.Node = node;
        if (node.NodeKey == key) {
            bstFind.NodeHasKey = true;
            return bstFind;
        }
        if (key < node.NodeKey) {
            if (node.LeftChild == null) {
                bstFind.ToLeft = true;
                return bstFind;
            } else {
                return find(node.LeftChild, key);
            }
        }
        if (node.RightChild == null) {
            return bstFind;
        }
        return find(node.RightChild, key);
    }
    public boolean AddKeyValue(int key, T val) {
        BSTFind<T> bstFind = FindNodeByKey(key);
        if (bstFind.NodeHasKey) {
            return false;
        }
        BSTNode<T> node = new BSTNode<>(key, val, bstFind.Node);
        if (bstFind.ToLeft) {
            bstFind.Node.LeftChild = node;
        } else {
            bstFind.Node.RightChild = node;
        }
        count++;
        return true;
    }
    public BSTNode<T> FinMinMax(BSTNode<T> FromNode, boolean FindMax) {
        if (FindMax) {
            if (FromNode.RightChild == null) {
                return FromNode;
            } else {
                return FinMinMax(FromNode.RightChild, FindMax);
            }
        } else {
            if (FromNode.LeftChild == null) {
                return FromNode;
            } else {
                return FinMinMax(FromNode.LeftChild, FindMax);
            }
        }
    }
    public boolean DeleteNodeByKey(int key) {
        BSTFind<T> bstFind = FindNodeByKey(key);
        if (!bstFind.NodeHasKey) {
            return false;
        }
        BSTNode<T> node = bstFind.Node;
        BSTNode<T> parent = node.Parent;
        if (parent.LeftChild == node) {
            parent.LeftChild = null;
        } else {
            parent.RightChild = null;
        }
        count--;
        return true;
    }
    public int Count() {
        return count;
    }
}
