import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Santa extends Thread{

    CyclicBarrier NeedHelp;
    Santa(){
        NeedHelp = new CyclicBarrier(4, new Help());
    }

    @Override
    public void run() {
        while(true){
            try {
                System.out.println("Санта засыпает");
                NeedHelp.await();
                System.out.println("Санта помог");
            }
            catch (InterruptedException | BrokenBarrierException e){}
        }
    }
}
