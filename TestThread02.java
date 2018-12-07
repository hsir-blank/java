public class TestThread02 {
    public static void main(String[] args){
        joinThread tt = new joinThread();
        Thread t = new Thread(tt,"joinThread");
        t.start();


        for (int i =0;i<500;i++){
            if(i==100){
                try {
                    t.join();  // （线程合并）加入join后线程变成单线程，Waits for this thread to die.
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"--->"+i);
        }

    }
}

class joinThread implements Runnable{

    @Override
    public void run() {
        for (int i =0;i<50;i++){
            System.out.println(Thread.currentThread().getName()+"--->"+i);
        }
    }
}
//
//public class TestThread02 {
//    public static void main(String[] args) {
//        System.out.println("爸爸和儿子买烟故事");
//        Thread father = new Thread(new FatherThread());
//        father.start();
//    }
//}
//
//class FatherThread implements Runnable {
//    public void run() {
//        System.out.println("爸爸想抽烟，发现烟抽完了");
//        System.out.println("爸爸让儿子去买包红塔山");
//        Thread son = new Thread(new SonThread());
//        son.start();
//        System.out.println("爸爸等儿子买烟回来");
//        try {
//            son.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            System.out.println("爸爸出门去找儿子跑哪去了");
//            // 结束JVM。如果是0则表示正常结束；如果是非0则表示非正常结束
//            System.exit(1);
//        }
//        System.out.println("爸爸高兴的接过烟开始抽，并把零钱给了儿子");
//    }
//}
//
//class SonThread implements Runnable {
//    public void run() {
//        System.out.println("儿子出门去买烟");
//        System.out.println("儿子买烟需要10分钟");
//        try {
//            for (int i = 1; i <= 10; i++) {
//                System.out.println("第" + i + "分钟");
//                Thread.sleep(1000);
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("儿子买烟回来了");
//    }
//}