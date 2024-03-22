package xian.woniuxy.z;

import java.util.ArrayList;
import java.util.List;

public class aaa {
    // 定义一个函数，参数为int类型的n
    public static List<String> strings(int n) {
        // 创建一个ArrayList类型的list
        List<String> list = new ArrayList<>();
        // 调用addnum函数，参数为n，空字符串，list
        addnum(n, "", list);
        // 返回list
        return list;
    }

    // 定义一个函数，参数为int类型的n，字符串类型的str，ArrayList类型的list
    private static void addnum(int n, String str, List<String> list) {
        // 如果n等于0，将str添加到list中，并返回
        if (n == 0) {
            list.add(str);
            return;
        }
        // 从1开始，到n结束，每次加1
        for (int i = 1; i <= n; i++) {
            // 调用addnum函数，参数为n-i，str+i+“ ”，list
            addnum(n - i, str + i + " ", list);
        }
    }

    // 主函数
    public static void main(String[] args) {
        // 定义一个int类型的n，值为5
        int n = 10;
        // 调用strings函数，参数为n，将返回值赋值给list
        List<String> list = strings(n);
        // 遍历list，将每一个元素添加到System.out.println中
        for (String formula : list) {
            System.out.println(formula);
        }
    }
}
//这个 strings 函数接受一个整数
//n 作为参数，并返回一个包含所有可能的加法式子的列表。addnum 是一个辅助函数，用于递归地找到所有可能的加法式子。
//在 main 函数中，我们调用 strings 函数并打印结果。您可以更改 n 的值以测试不同的输入