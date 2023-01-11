public class ClientReader extends Thread {

    int TimeRequired; // требуемое время
    int Index;
    String name;
    DB data;

    public ClientReader(DB database, int counter, int nextInt) {
        this.data = database;
        this.Index = counter; // порядковый номер нашего читателя
        this.TimeRequired = nextInt;
        this.name = "Reader #" + counter;
    }

    public synchronized void run() {
        System.out.println("Создан клиент " + name);
        try {
            data.sem2.acquire(); // получаем разрешение у 2-го семафора
                data.counter++;
                if (data.counter==1){
                    data.sem1.acquire();
                }
            data.sem2.release();

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
