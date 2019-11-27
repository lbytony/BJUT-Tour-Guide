package cn.liboyan.bjutTourGuide.ds;

import java.util.Arrays;

public class ArrayList<T> {
    private T[] data;
    private int size;
    private int length;
    private int curPos;

    // Generator
    public ArrayList() {
        data = (T[]) new Object[1];
        size = 1;
        length = curPos = 0;
    }
    public ArrayList(int n) {
        data = (T[]) new Object[n];
        size = n;
        length = curPos = 0;
    }

    public ArrayList(ArrayList<T> arrayList) {
        size = arrayList.getSize();
        data = (T[]) new Object[size];
        for (int i = 0; i < arrayList.getLength(); i++) {
            data[i] = arrayList.data[i];
        }
        length = arrayList.getLength();
        curPos = 0;
    }

    public int getLength() {
        return length;
    }

    public int getSize() {
        return size;
    }

    private void expandSize() {
        T[] data_new;
        size++;
        data_new = (T[]) new Object[size];
        for (int i = 0; i < size - 1; i++) {
            data_new[i] = data[i];
        }
        data = Arrays.copyOf(data, size);
    }
    public void insert(T info, int pos) {
        if (pos < 0 || pos > length) {
            throw new IllegalArgumentException();
        } else if (length + 1 > size) {
            expandSize();
        }
        for (int i = size - 1; i > pos; i--) {
            data[i] = data[i - 1];
        }
        data[pos] = info;
        length++;
    }
    public void add(T info) {
        insert(info, length);
    }

    public void del(int pos) {
        if (pos < 0 || pos > length) {
            throw new IllegalArgumentException();
        } else if (length <= 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            for (int i = pos; i < length - 1; i++) {
                data[i] = data[i+1];
            }
            length--;
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

    public void setData(int pos, T info) {
        data[pos] = info;
    }

    public T getData(int pos) {
        return data[pos];
    }

    public void copy(ArrayList<T> src) {
        for (int i = 0; i < src.getLength(); i++) {
            this.setData(i, src.getData(i));
        }
    }

    public void print() {
        for (int i = 0; i < length; i++) {
            System.out.print(this.getData(i) + "\t");
        }
    }

    public ArrayList<T> toArrayList(T[] list) {
        ArrayList<T> arrayList = new ArrayList<T>(list.length);
        for (int i = 0; i < list.length; i++) {
            arrayList.setData(i, list[i]);
        }
        return arrayList;
    }
}
