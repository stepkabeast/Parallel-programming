public class Program {

    public static void main(String[] args) {

        DB data = new DB();

        Generator queue = new Generator(data);
        queue.start();
    }
}