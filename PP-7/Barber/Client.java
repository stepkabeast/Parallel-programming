import java.util.Random;

public class Client extends Thread{

    int index;
    String name;
    Barbershop shop;
    Random rand = new Random();

    Client(int Name, Barbershop barber){
        this.index = Name;
        this.shop = barber;
        this.name = "Клиент №" + index;
        try{
            sleep(rand.nextInt(200)+10);
        } catch (InterruptedException e) {}
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " пришёл в парикмахерскую");
            if (shop.stay > 9) {
                System.out.println(name + " ушёл, так как мест нет");
                return;
            }
            shop.sem1.acquire();
                    shop.stay++;
            System.out.println(name + " встал в очередь в стоячей зоне, всего стоит " + shop.stay);
                shop.sem2.acquire();
                    shop.seat++;
                    shop.stay--;
                System.out.println(name + " сел на диван, всего сидит " + shop.seat + ", всего стоит " + shop.stay);
                shop.sem1.release();
                    shop.sem3.acquire();
                    shop.barbers++;
                    shop.seat--;
                    System.out.println(name + " стрижется, всего стригутся " + shop.barbers + ", всего сидит на диване " + shop.seat);
                    shop.sem2.release();
                        sleep(500);
                        shop.barbers--;
                    shop.sem3.release();

                    System.out.println(name + " подстрижен и идет оплачить стрижку");

                    shop.sem4.acquire();
                        shop.sem3.acquire();
                            System.out.println(name + " оплачивает в кассу");
                            sleep(50);
                        shop.sem3.release();
                    shop.sem4.release();


            shop.sem1.acquire();
                shop.sem2.acquire();
            shop.sem1.release();
                    shop.sem3.acquire();
                shop.sem2.release();
                        sleep(500);
                    shop.sem3.release();

            shop.sem4.acquire();
                shop.sem3.acquire();
                    sleep(50);
                shop.sem3.release();
            shop.sem4.release();

            System.out.println(name + " оплатил и уходит");

        } catch (InterruptedException e) {}
    }

}
