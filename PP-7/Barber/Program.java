public class Program {

    public static void main(String[] args){
        Barbershop Barb = new Barbershop();

        int cnt = 0;
        while (true){
            cnt++;
            Client NewCl = new Client(cnt, Barb);
            NewCl.start();
        }
    }

}
