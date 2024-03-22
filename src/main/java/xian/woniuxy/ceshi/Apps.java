package xian.woniuxy.ceshi;

public class Apps {
        public static void main(String[] args) {
            // 创建一个StringBuilder实例
            StringBuilder sb = new StringBuilder();

            // 创建一个线程来修改StringBuilder
            Thread t1 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    sb.append("a");
                }
            });

            // 创建另一个线程来修改StringBuilder
            Thread t2 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    sb.append("a");
                }
            });

            // 启动线程
            t1.start();
            t2.start();

            // 等待线程结束
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 输出最终的StringBuilder内容
            System.out.println(sb.length());
        }
    }