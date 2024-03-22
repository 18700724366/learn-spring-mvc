package xian.woniuxy.z;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(10);

        for (int i = 1; i <= 2; i++) {
            Thread th = new Thread(()->{
                for (int j = 1; j <= 10000 ; j++) {
                    list.add(j);
                }
            });
            th.start();
        }

        System.out.println("over");

    }
}
