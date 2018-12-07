public class TestThread01 {
    public static void main(String[] args) {
        CreatThread ct2 = new CreatThread();
        Thread t2 = new Thread(ct2);
        t2.setName("T2***");
        t2.start();

        Test01 ct = new Test01();  // sleep线程
        new Thread(ct, "t1").start();

        for (int i = 0; i < 200; i++) {
            System.out.println(Thread.currentThread().getName() + "---->" + i);
            if (i % 20 == 0) {
                Thread.yield();  //yield让出时间片
            }
        }
    }
}

class CreatThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println(Thread.currentThread().getName() + "---->" + i);

        }
    }
}

class Test01 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(100);  // sleep
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "---->" + i);

        }
    }

}