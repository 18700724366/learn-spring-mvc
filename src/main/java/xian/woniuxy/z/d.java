package xian.woniuxy.z;

public class d {
    public static void main(String[] args) {
        // 主函数，程序从这里开始
        ps('A', 'B');
    }

    public static void ps(char a, char b) {
        // 调用p函数，传入参数a，b
        p("", a, b);
    }

    private static void p(String p, char a, char b) {
        // 如果p的长度等于4，则输出p
        if (p.length() == 4) {
            System.out.println(p);
            return;
        }
        // 调用p函数，传入参数p + a，b，'A'
        p(p + a, b, 'A');
        // 调用p函数，传入参数p + b，a，'B'
        p(p + b, a, 'B');
    }
}