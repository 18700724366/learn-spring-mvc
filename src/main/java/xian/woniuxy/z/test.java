package xian.woniuxy.z;

public class test {
    public static void main(String[] args) {
        //调用getNum函数，输出结果
        System.out.print(getNum(100) + " ");

    }
    //定义一个函数，参数为index
    public static int getNum(int index) {
        //如果index小于等于0，返回0
        if (index <= 0){
            return 0;
        }
        //如果index等于1或者2，返回1
        if (index == 1 || index == 2) {
            return 1;
        }
        //否则，返回getNum函数的结果
        return getNum(index - 2) + getNum(index - 1);
    }
}