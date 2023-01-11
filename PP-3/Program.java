public class Program {

    public static void main(String[] args) throws InterruptedException {

       /* System.out.println("Main thread started");

        Thread[] MyThread = new Thread[5];

        for (int i = 0; i < 5; i++) {
            MyThread[i] = new Thread(new TestThread(i)); // добавляем поток
            MyThread[i].start(); // запускаем поток (вызывается метод run)
        }

        for (int i = 0; i < 5; i++) {
            MyThread[i].join();
        }

        System.out.println("Main thread finished");*/


         System.out.println("Main thread started");

        TestThread MyThread = new TestThread(1); // добавляем поток
        MyThread.start(); // запускаем поток (вызывается метод run)

        Thread.sleep(1000);
        /*for(int i = 0; i < 50; i++){
            System.out.println(i);
        }*/
        MyThread.interrupt();
        Thread.sleep(1000);

        System.out.println("Main thread finished");
    }
}

