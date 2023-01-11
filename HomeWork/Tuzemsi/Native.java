public class Native extends Thread{
    Pot MyPot;

    Native(Pot pot){
        this.MyPot = pot;
    }

    @Override
    public void run() {
        while(true){
            MyPot.GetFood();
        }
    }
}
