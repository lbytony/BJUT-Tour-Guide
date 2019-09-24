package cn.liboyan.bjutTourGuide.ds;

/*
 * @author LiBoyan
 * @class LinkedList with a Head Node
 */
public class LinkedList {
    private Node<Integer> head, tail;
    private int curLen;

    public LinkedList() {
        head = tail = new Node<Integer>(null);
        curLen = 0;
        head.next = tail.next = null;
    }

    public Node<Integer> setPos(int i) {
        int count = 0;
        if (i < 0) {
            throw new IllegalArgumentException();
        } else {
            Node<Integer> p = head.next;
            while (p != null && count < i) {
                p = p.next;
                count++;
            }
            return p;
        }
    }

    public void insert(int info, int pos) {
        // p 当前节点
        // q 插入节点
        Node<Integer> p, q;
        p = setPos(pos - 1);
        if (p == null) {
            throw new IllegalArgumentException();
        }
        q = new Node<Integer>(info);
        q.next = p.next;
        p.next = q;
        if (p == tail) {
            tail = q;
        }
        curLen++;
    }

    public void add(int info) {
        insert(info, curLen);
    }

    public void del(int pos) {
        Node<Integer> p, q;
        p = setPos(pos - 1);
        if (p == null) {
            throw new IllegalArgumentException();
        }
        q = p.next;
        p.next = q.next;
        if (q == tail) {
            tail = p;
        }
        curLen--;
    }

    public int getCurLen() {
        return curLen;
    }

    public void setValue(int data, int pos) {
        Node<Integer> p = setPos(pos);
        p.data = data;
    }

    public int getValue(int pos) {
        Node<Integer> p = this.head;
        int data = 0;
        while (p.next != null) {
            pos++;
            p = p.next;
        }
        return data;
    }
}
