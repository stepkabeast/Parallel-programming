public class Program {
    public static void main(String[] args) {
        Santa Claus = new Santa();
        Claus.start();

        for(int i = 0; i < 10; i++){
            new Thread(new Elf(Claus)).start();
        }
    }
}
