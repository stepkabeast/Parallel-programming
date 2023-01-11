public class Store {

    private int product=1;
    private int shelf=5;

    public synchronized void get(){
        try{
            while(product<1){
                wait();
            }
            product--;
            System.out.println("Покупатель купил 1 товар");
            System.out.println("Товара на складе:" + product);
            notify();
        } catch (InterruptedException e) {}
    }

    public synchronized void put(){
        try{
            while(product>shelf-1){
                wait();
            }
            product++;
            System.out.println("Производитель добавил 1 товар");
            System.out.println("Товара на складе:" + product);
            notify();
        } catch (InterruptedException e) {}
    }
}

