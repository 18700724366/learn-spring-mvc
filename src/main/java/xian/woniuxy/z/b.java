package xian.woniuxy.z;

import java.util.Scanner;

public class b {
  public static void main(String[] args) {
        //调用num函数，传入参数1和5
        num(1,5);
    }

    public static void num(int n1,int n2) {
        //如果n1小于等于n2，则输出n1，并调用num函数，传入参数n1+1和n2
        if(n1<=n2){
            System.out.print(n1+" ");
            num(n1+1,n2);
            //输出n1
            System.out.print(n1+" ");
        }
    }


//    public static void num(int n) {
//        if (n <= 0) {
//            return;
//        } else {
//          System.out.printf(String.valueOf(n) + ","); // 从n打印到1
//            num(n - 1);
//            System.out.printf(n + ","); // 从1打印到n
//        }
//
//    }
//
//    public static void main(String[] args) {
//        num(5);
//    }

//        public static void main(String[] args) {
//            num(5);
//        }
//
//        public static void num(int n) {
//            if (n <= 0) {
//                return;
//            }
//
//            System.out.println(n);
//            num(n - 1);
//            System.out.println(n);
//        }

}