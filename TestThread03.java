
public class TestThread03 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new TestThread(), "t1");
        Thread t2 = new Thread(new TestThread(), "t2");
        t1.setPriority(1);  // 最低优先级
        // 优先级默认为5，优先级高的先执行
        t2.setPriority(10);  //最高优先级

        t1.start();
        t2.start();

    }
}


class TestThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "---->" + i);

        }
    }

}
