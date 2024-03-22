package xian.woniuxy.z;

import java.util.ArrayList;
import java.util.List;

public class appp {
   public static List<String> list(int n) {
        // 创建一个存储结果的列表
        List<String> result = new ArrayList<>();
        // 调用回溯函数，传入参数n，n，空字符串，result
        backtrack(n, n, "", result);
        // 返回结果列表
        return result;
    }

    private static void backtrack(int left, int right, String track, List<String> result) {
        // 如果左右括号数量都为0，则将track添加到结果列表中
        if (left == 0 && right == 0) {
            result.add(track);
            return;
        }
        // 如果左括号数量大于0，则继续递归，将左括号数量减1，track添加左括号
        if (left > 0) {
            backtrack(left - 1, right, track + "(", result);
        }
        // 如果右括号数量大于左括号数量，则继续递归，将右括号数量减1，track添加右括号
        if (right > left) {
            backtrack(left, right - 1, track + ")", result);
        }
    }

    public static void main(String[] args) {
        // 调用list函数，传入参数3，获取结果列表
        List<String> ans = list(3);
        // 遍历结果列表，将每一个结果打印出来
        for (String an : ans) {
            System.out.println(an);
        }
    }

    /*首先，我们定义了一个名为list的方法，该方法接受一个整数n作为参数，表示要生成的括号对的长度。
    然后，我们创建了一个名为result的List，用于存储所有合法的括号组合。
    接下来，我们定义了一个名为backtrack的方法，该方法接受五个参数：result列表、当前的括号组合、已打开的括号数、已关闭的括号数和最大括号对长度。
    如果当前括号组合的长度等于最大括号对长度的两倍，说明我们已经生成了一个合法的括号组合，将其添加到result列表中，然后返回。
    如果当前还有未使用的左括号，我们可以继续添加左括号。
    如果当前还有未使用的右括号，并且右括号数量小于左括号数量，我们可以继续添加右括号。
    最后，我们调用backtrack方法，递归地生成所有可能的括号组合。
    在main方法中，我们调用list方法，传入n参数，然后打印出所有生成的括号组合。
    */


}
