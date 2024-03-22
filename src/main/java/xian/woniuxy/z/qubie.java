package xian.woniuxy.z;

import java.util.ArrayList;
import java.util.LinkedList;

public class qubie {


    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        // 添加元素到 ArrayList
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
        }
        // 添加元素到 LinkedList
        for (int i = 0; i < 10000; i++) {
            linkedList.add(i);
        }
        // 删除元素从 ArrayList
        for (int i = 0; i < 5000; i++) {
            arrayList.remove(0);
        }
        // 删除元素从 LinkedList
        for (int i = 0; i < 5000; i++) {
            linkedList.removeFirst();
        }
        // 查询元素在 ArrayList
        for (int i = 0; i < 5000; i++) {
            int index = arrayList.indexOf(i);
        }
        // 查询元素在 LinkedList
        for (int i = 0; i < 5000; i++) {
            int index = linkedList.indexOf(i);
        }
    }
}

