import java.util.Random;

public class Generator extends Thread{

    private int Counter=0;
    DB database;
    Random r;

    Generator(DB Data){
        database = Data;
        r = new Random();
    }

    @Override
    public synchronized void run() {
        try{
            while(true){
                Thread t;
                if (r.nextInt(100)<30){
                    t = new Thread(new ClientWriter2(database, Counter, r.nextInt(900)+100));
                } else{
                    t = new Thread(new ClientReader2(database, Counter, r.nextInt(900)+100));
                }
                Counter++;
                t.start();
                sleep(r.nextInt(300));
            }
        } catch(InterruptedException e)
        {System.out.println("Exception!");}
    }

}
