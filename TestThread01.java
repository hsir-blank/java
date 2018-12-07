public class TestThread01 {
    public static void main(String[] args) {
        CreatThread ct2 = new CreatThread();
        Thread t2 = new Thread(ct2);
        t2.setName("T2***");
        t2.start();

        CreatThread ct = new CreatThread();
        new Thread(ct, "t1").start();

        for (int i = 0; i < 200; i++) {
            System.out.println(Thread.currentThread().getName() + "---->" + i);
            if (i % 20 == 0) {
                Thread.yield();
            }
        }
    }
}


class CreatThread implements Runnable {

    private boolean flag = false;

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println(Thread.currentThread().getName() + "---->" + i);

        }
    }

}
