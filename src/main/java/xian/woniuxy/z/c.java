package xian.woniuxy.z;

public class c {
    public static void main(String[] args) {
        printStrings('A', 'B');
    }
    public static void printStrings(char a, char b) {
        for (int n = 1; n <= 8; n++) {
            for (int i = 0; i < n; i++) {
                System.out.print(a);
            }
            for (int i = 0; i < 4 - n; i++) {
                System.out.print(b);


            }
            System.out.println();
        }
    }

}