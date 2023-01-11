import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Belt {

    private ArrayList<Detail> conv;
    final private int CtiticalMass = 3000;
    private int CurrentMass;
    ReentrantLock lock;
    Condition EmptyBelt;

    Belt(){
        this.conv = new ArrayList<>();
        this.CurrentMass = 0;
        this.lock = new ReentrantLock();
        EmptyBelt = lock.newCondition();
    }

    public void add(Detail A, int i){
        lock.lock();
        try{
            conv.add(A);
            System.out.println("Деталь №" + A.index + " поставлена на конвейер Роботом " + i);
            CurrentMass += A.mass;
            System.out.println("Общая масса деталей: " + CurrentMass);
            if (CurrentMass > CtiticalMass){
                BeltClear();
            } else {
                EmptyBelt.signalAll();
            }
        } catch (InterruptedException e) {}
        finally {
            lock.unlock();
        }

    }

    public Detail getDetail(){
        lock.lock();
        Detail temp = null;
        try {
            while (conv.size()==0){
                EmptyBelt.await();
            }
            temp = conv.remove(0);
            CurrentMass -= temp.mass;
        } catch (InterruptedException e) {}
        finally {
            lock.unlock();
        }
        return temp;
    }

    public void BeltClear() throws InterruptedException {
        System.out.println("Началась очистка ленты");
        System.out.println("Всего " + conv.size() + " деталей массой " + CurrentMass);
        Thread.sleep(500);
        conv.clear();
        CurrentMass=0;
    }

}
