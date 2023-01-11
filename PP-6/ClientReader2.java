public class ClientReader2 extends Thread {

    int TimeRequired;
    int Index;
    String name;
    DB data;

    public ClientReader2(DB database, int counter, int nextInt) {
        this.data = database;
        this.Index = counter;
        this.TimeRequired = nextInt;
        this.name = "Reader #" + counter;
    }

    public synchronized void run() {
        System.out.println("Создан клиент " + name);
        try {
            data.sem3.acquire();
                data.sem2.acquire();
                    data.counter++;
                    if (data.counter==1){
                        data.sem1.acquire();
                    }
                data.sem2.release();
            data.sem3.release();

            System.out.println("Клиент " + name + "получил доступ к базе данных");
            sleep(TimeRequired);
            System.out.println("Клиент " + name + "закончил работу с базой данных");

            data.sem2.acquire();
                data.counter--;
                if (data.counter==0){
                    data.sem1.release();
                }
            data.sem2.release();

        } catch(InterruptedException e) {
            System.out.println("Исключение!");
        }
    }
}
