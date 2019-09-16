package cn.liboyan.bjutTourGuide;

public class ArrayList<T> {
    private T[] data;
    private int size;
    private int curLen;
    private int curPos;
    public int getCurLen() {
        return curLen;
    }
    public int getSize() {
        return size;
    }
    // Generator
    public ArrayList() {
        data = (T[]) new Object[1];
        size = 1;
        curLen = curPos = 0;
    }
    public ArrayList(int n) {
        data = (T[]) new Object[n];
        size = n;
        curLen = curPos = 0;
    }
    private void expandSize() {
        T[] data_new;
        size += 10;
        data_new = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            data_new[i] = data[i];
        }
        data = data_new;
    }
    public void insert(T info, int pos) {
        if (pos < 0 || pos > curLen) {
            throw new IllegalArgumentException();
        } else if (curLen + 1 >= size) {
            expandSize();
        } else {
            for (int i = size - 1; i > pos ; i--) {
                data[i] = data[i-1];
            }
            data[pos] = info;
            curLen++;
        }
    }
    public void add(T info) {
        insert(info, curLen);
    }
    public void del(int pos) {
        if (pos < 0 || pos > curLen) {
            throw new IllegalArgumentException();
        } else if (curLen <= 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            for (int i = pos; i < curLen-1 ; i++) {
                data[i] = data[i+1];
            }
            curLen--;
        }
    }
    public int getPos(T info) {
        for (int i = 0; i < size; i++) {
            if (data[i] == info) {
                return i;
            }
        }
        return -1;
    }
}
