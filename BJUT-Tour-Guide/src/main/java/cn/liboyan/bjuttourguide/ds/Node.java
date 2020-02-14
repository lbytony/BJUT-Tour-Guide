package cn.liboyan.bjuttourguide.ds;

public class Node<T> {
    T data;
    Node<T> next = null;

    public Node(T _data) {
        data = _data;
    }
}
