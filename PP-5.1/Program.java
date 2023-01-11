public class Program {

    public static void main(String[] args) throws InterruptedException {

        Person alphonse = new Person("Alphonse");
        Person gaston = new Person("Gaston");

        Meeting today1 = new Meeting(alphonse, gaston);
        Meeting today2 = new Meeting(gaston, alphonse);

        today1.start();
        Thread.sleep(100);
        today2.start();
    }

}

