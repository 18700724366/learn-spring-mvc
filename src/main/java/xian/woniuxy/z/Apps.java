package xian.woniuxy.z;

import java.util.ArrayList;
import java.util.List;


public class Apps {
    public static List<String> compose(int maxLength) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        dfs(ans, sb, maxLength);
        return ans;
    }

    private static void dfs(List<String> ans, StringBuilder path, int maxLength) {

        if (path.length() == maxLength) {
            ans.add(path.toString());
            return;
        }
        path.append("(");
        dfs(ans, path, maxLength);
        path.deleteCharAt(path.length() - 1);

        path.append(")");
        dfs(ans, path, maxLength);
        path.deleteCharAt(path.length() - 1);


    }

    public static void main(String[] args) {
        List<String> ans = compose(6);
        for (String an : ans) {
            System.out.println(an);
        }
    }
}
