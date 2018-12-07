// 线程同步
public class TestThread05 {
    public static void main(String[] args) {
        Account1 a1 = new Account1(100, "hsir");

        // 创建两个取钱线程
        Thread t3 = new Thread(new drawCash1(80, a1),"first");
        Thread t4 = new Thread(new drawCash1(20, a1),"second");

        t3.start();
        try {
            t3.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t4.start();
    }
}

class Account1 {
    int money;
    String userName;

    public Account1(int money, String userName) {
        super();
        this.money = money;
        this.userName = userName;
    }
}

// 取钱的线程
class drawCash1 implements Runnable {

    int drawNum; // 取多少强
    Account1 account; //取钱账户
    int drawTotal; //总共取钱

    // 构造器
    public drawCash1(int drawNum, Account1 account) {
        super();
        this.drawNum = drawNum;
        this.account = account;
    }

    @Override
    public void run() {
        draw();

    }

    // 或者public synchronized void draw(account)
    // 线程同步，在要同步的代码前加-->synchronized
    void draw() {
        synchronized (account) {
            if (account.money - drawNum < 0) {
                System.out.println("余额不足哦");
                return; // 取不出来这么多钱
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money -= drawNum;
            drawTotal += drawNum;
            System.out.println(Thread.currentThread().getName() + "总共取了： " + drawTotal);
            System.out.println(Thread.currentThread().getName() + "取钱后的余额： " + account.money);
        }
    }
}