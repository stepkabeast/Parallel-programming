import java.util.concurrent.Semaphore;

/**
 * @author Stepan Kovalev
 * Пример работы Semaphore
 */

public class SemaphoreTest {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(2); // созадем semaphore с ограничем до 2 потоков

        /* Создаем три объекта CheckSemaphore для того, чтобы присвоить в них наши semaphore
         * Далее будем их передавать в конструктор потоков
         */

        CheckSemaphore s1 = new CheckSemaphore();
        s1.semaphore = semaphore;

        CheckSemaphore s2 = new CheckSemaphore();
        s2.semaphore = semaphore;

        CheckSemaphore s3 = new CheckSemaphore();
        s3.semaphore = semaphore;

        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s2);
        Thread t3 = new Thread(s3);

        t1.start();
        t2.start();
        t3.start();
    }
    static class CheckSemaphore extends Thread{
        Semaphore semaphore;

        @Override
        public void run() {
            try {
                semaphore.acquire(); // впускаем поток в semaphore
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for(int i = 0; i < 3; i++)
                System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            semaphore.release(); // позволяем потоку выйти
        }
    }
}