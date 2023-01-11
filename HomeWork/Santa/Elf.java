import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Semaphore;

public class Elf extends Thread{
    Santa MySanta;
    Random r;
    static Semaphore Queue = new Semaphore(3);
    Elf(Santa santa){
        this.MySanta = santa;
        r = new Random();
    }

    @Override
    public void run(){
        while(true){
            try{
                sleep(400 + r.nextInt(600));
                System.out.println("Эльфу " + Thread.currentThread().getName() + " нужна помощь");
                Queue.acquire();
                MySanta.NeedHelp.await();
                Queue.release();
            }
            catch (InterruptedException | BrokenBarrierException e) {}
        }
    }
}
