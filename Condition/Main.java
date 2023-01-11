import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
/**
 * @author Stepan Kovalev
 * Рассмотрим Condition на селдующем примере:
 * У нас имеются 2 операции - положить деньги и вывести деньги.
 * Условие - мы не можем вывести деньги если их нет на счете */
public class Main {
    static Account account = new Account();
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyDeposit());
        Thread t2 = new Thread(new MyWithDrawl());

        t1.start();
        t2.start();
    }

     static class MyDeposit extends Thread{
        @Override
        public void run() {
            try {
                account.deposit(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class MyWithDrawl extends Thread{
        @Override
        public void run() {
            try {
                account.withdraw(700);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

   static class Account{
        Lock lock = new ReentrantLock();
        Condition newCondition = lock.newCondition(); // инициализируем переменную состояния

        int balance = 0;

        public void deposit(int amount) throws InterruptedException {
            lock.lock();
            Thread.sleep(1000);
            balance += amount;
            System.out.println("Счет пополнен " + balance);
            newCondition.signalAll();
            lock.unlock();
        }

        public void withdraw(int amount) throws InterruptedException {
            lock.lock();
            while(amount > balance){
                newCondition.await();
            }
            System.out.println("Счет перед выводом " + balance);
            balance -= amount;
            System.out.println("Счет после вывода " + balance);
            lock.unlock();
        }
    }
}
