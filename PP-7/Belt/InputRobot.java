import java.util.Random;

public class InputRobot extends Thread{

    int index;
    Belt conv;
    Random r = new Random();

    InputRobot(int i, Belt Conv){
        this.index = i;
        this.conv = Conv;
    }

    @Override
    public void run() {
        try {
            while(true){
                conv.add(new Detail(), index);
                Thread.sleep(r.nextInt(901)+100);
            }
        } catch (InterruptedException e) {}
    }
}
