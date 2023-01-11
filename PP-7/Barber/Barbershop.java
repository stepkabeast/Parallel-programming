import java.util.concurrent.Semaphore;

public class Barbershop {

    int stay, seat, barbers;
    Semaphore sem1, sem2, sem3, sem4;

    Barbershop(){
        stay=0;
        seat=0;
        barbers=0;

        sem1 = new Semaphore(10, true);
        sem2 = new Semaphore(7, true);
        sem3 = new Semaphore(3, true);
        sem4 = new Semaphore(1, true);
    }


}
