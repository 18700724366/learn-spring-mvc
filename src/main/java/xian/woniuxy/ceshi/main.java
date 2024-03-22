package xian.woniuxy.ceshi;

public class main {
    // 计算n的和
    public static int sum(int n) {
        // 如果n等于1，返回1
        if (n == 1) {
            return 1;
        } else {
            // 否则返回n加上sum(n-1)
            return n + sum(n - 1);
        }
    }

    public static void main(String[] args) {
        // 输出sum(100)的结果
        System.out.println(sum(100));
    }
}