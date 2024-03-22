package xian.woniuxy.z;


public class AppTest {
//    public static long foo(int index) {
//        if (index <= 2) {
//            return 1;
//        }
//        return foo(index - 1) + foo(index - 2);
//    }
//
//    public static void main(String[] args) {
//        for (int i = 1; i <= 10; i++) {
//            System.out.println(foo(i));
//        }
//    }

//以下为优化后的代码
   public static long[] foo(int index) {
        // 创建一个长度为index+1的数组
        long[] num = new long[index + 1];
        // 初始化数组，第一个元素为0，第二个元素为1
        num[0] = 0;
        num[1] = 1;
        // 从第三个元素开始，计算num[i]的值
        for (int i = 2; i <= index; i++) {
            // num[i]的值为num[i-1]和num[i-2]的和
            num[i] = num[i - 1] + num[i - 2];
        }
        // 返回计算结果
        return num;
    }

    public static void main(String[] args) {
        // 调用foo函数，计算100以内的斐波那契数列
        long[] num = foo(100);
        // 遍历数组，输出结果
        for (int i = 0; i <= 100; i++) {
            System.out.println(num[i]);
        }
    }
}
