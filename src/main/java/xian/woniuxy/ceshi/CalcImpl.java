package xian.woniuxy.ceshi;

import org.springframework.stereotype.Component;

@Component
public class CalcImpl implements Calc {

    // 加法
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    // 减法
    @Override
    public int sub(int a, int b) {
        return a - b;
    }

}