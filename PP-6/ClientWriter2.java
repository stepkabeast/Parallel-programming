public class ClientWriter2 extends Thread {

    int TimeRequired;
    int Index;
    String name;
    DB data;

    public ClientWriter2(DB database, int counter, int nextInt) {
        this.data = database;
        this.Index = counter;
        this.TimeRequired = nextInt;
        this.name = "Writer #" + counter;
    }

    public void run() {
        System.out.println("Создан клиент " + name);
        try {
            data.sem3.acquire();
                data.sem1.acquire();
                    System.out.println("Клиент " + name + "получил доступ к базе данных");
                    sleep(TimeRequired);
                    System.out.println("Клиент " + name + "закончил работу с базой данных");
                data.sem1.release();
            data.sem3.release();
        } catch(InterruptedException e) {
            System.out.println("Исключение!");
        }

    }

}
