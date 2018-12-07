// 线程不同步例子，线程不安全
public class TestThread04 {
    public static void main(String[] args) {
        Account a = new Account(100, "hsir");
        // 创建两个取钱线程
        Thread t1 = new Thread(new drawCash(80, a), "第一次");
        Thread t2 = new Thread(new drawCash(80, a), "第二次");

        t1.start();
        try {
            t1.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}

class Account {
    int money;
    String userName;

    public Account(int money, String userName) {
        super();
        this.money = money;
        this.userName = userName;
    }
}

// 取钱的线程
class drawCash implements Runnable {

    int drawNum; // 取多少钱
    Account account; //取钱账户
    int drawTotal; //总共取钱

    // 构造器
    public drawCash(int drawNum, Account account) {
        this.drawNum = drawNum;
        this.account = account;
    }

    @Override
    public void run() {
        if (account.money - drawNum < 0) {
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