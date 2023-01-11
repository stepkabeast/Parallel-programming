import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Pot {
    ReentrantLock Spoon, Boss;
    Condition Empty, Full;
    private int Food = 0;
    private int MaxFood = 0;

    Pot(int Amount){
        Boss = new ReentrantLock();
        Empty = Boss.newCondition();
        Full = Boss.newCondition();

        Spoon = new ReentrantLock(false);
        this.MaxFood = Amount;
        this.Food = Amount;
    }

    public void GetFood(){
        Spoon.lock();
        Boss.lock();
        try {
            if (Food == 0) {
                System.out.println(Thread.currentThread().getName() + "будит вождя");
                Empty.signal();
                while (Food < MaxFood) {
                    Full.await();
                }
            }

            System.out.println(Thread.currentThread().getName() + "будит вождя");
            Thread.sleep(20);
            Food--;
            System.out.println(Thread.currentThread().getName() + "поел, в котле осталось " + Food);
        }
        catch (InterruptedException e) {
        }
        finally {
            Boss.unlock();
            Spoon.unlock();
        }
    }

    public void AddFood() {
        Boss.lock();
        try {
            Empty.await();
            while(Food < MaxFood){
                System.out.println("Вождь готовит еду: " + Food + "/" + MaxFood);
                Food++;
                Thread.sleep(10);
            }
            System.out.println("Котел полный " + Food + "/" + MaxFood);
            Full.signal();

        } catch (InterruptedException e) {
        } finally {
            Boss.unlock();
        }
    }
}
