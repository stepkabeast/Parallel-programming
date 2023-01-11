public class TestThread extends Thread{

    private String name;

    TestThread(int I){
        this.name="MyThread #" + I;
        System.out.println(this.name + " created");
    }

    @Override
    public void run() { //определяем точку входа в поток, начало работы потока
        System.out.println(name + " started");

        int counter=1;

        while (!isInterrupted())
        {
            System.out.println("Step " + counter++);
            try {
                Thread.sleep(100); // ловим ошибку прерывания потока
            } catch (InterruptedException e) {
                System.out.println("Interruption");
                interrupt();
            }
        }

        System.out.println(name + " finished");
    }

}
