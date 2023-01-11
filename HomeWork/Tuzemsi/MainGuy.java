public class MainGuy extends Thread{
    Pot MyPot;

    MainGuy(Pot pot){
        this.MyPot = pot;
    }

    @Override
    public void run() {
        while(true){
            MyPot.AddFood();
        }
    }
}
