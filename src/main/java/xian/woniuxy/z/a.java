package xian.woniuxy.z;

public class a {
    public static void main(String[] args) {
        num(3);
    }

    public static void num(int n) {
        if (n > 0) {
            num(n - 1);
            System.out.println(n);
        }
    }
}