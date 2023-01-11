public class Help implements Runnable {

    public void run(){
        try{
            System.out.println("Санта помогает Эльфам");
            Thread.sleep(500);
        } catch (InterruptedException e){}

    }

}
