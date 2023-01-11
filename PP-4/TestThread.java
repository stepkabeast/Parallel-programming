public class TestThread extends Thread{

    CommonResource res;
    static Object object = new Object();

    TestThread (CommonResource Res){
        this.res = Res;
    }

    @Override
    public void run() {
        synchronized (object) {
            res.x = 1;
            for (int i = 0; i < 4; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + res.x);
                res.x++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}

