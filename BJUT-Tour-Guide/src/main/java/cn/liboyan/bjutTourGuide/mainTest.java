package cn.liboyan.bjutTourGuide;

import cn.liboyan.bjutTourGuide.ds.ArrayList;

public class mainTest {
    private static void testArrayGenArray() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>(5);
        arrayList.add(5);
        arrayList.add(4);
        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(1);
        ArrayList<Integer> arrayListNew = new ArrayList<Integer>(arrayList);
        for (int i = 0; i < arrayList.getLength(); i++) {
            System.out.println(arrayList.getData(i));
        }
    }

    private static void testExpandSize() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>(5);
        arrayList.add(5);
        arrayList.add(4);
        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(5);
        arrayList.add(9);
        arrayList.add(7);
        System.out.println(arrayList.getLength());
        for (int i = 0; i < arrayList.getLength(); i++) {
            System.out.println(arrayList.getData(i));
        }
    }

    public static void main(String[] args) {
        System.out.println("=========Test Gen By ArrayList:=========");
        testArrayGenArray();
        System.out.println("=========Test Expand Size:=========");
        testExpandSize();
    }
}
