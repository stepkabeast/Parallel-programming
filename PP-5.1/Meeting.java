public class Meeting extends Thread{

    private Person Man1;
    private Person Man2;

    Meeting(Person A, Person B){
        this.Man1 = A;
        this.Man2 = B;
    }

    @Override
    public void run() {
        Man1.bow(Man2);
    }
}
