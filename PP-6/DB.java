import java.util.concurrent.Semaphore;

public class DB {
    /*Наша база данных к которой могут получить доступ:
    * А)    Ровно один писатель и ноль читателей
    * В)    Ноль писателей и сколько угодно читателей*/

    Semaphore sem1, sem2, sem3;
    int counter=0;

    DB(){
        /*В конструкторе класса нашей базы создаем три объекта семафора,
        * где запускается один поток в порядке очереди*/

        sem1 = new Semaphore(1, true);
        sem2 = new Semaphore(1, true);
        sem3 = new Semaphore(1, true);
    }

}
