public class Producer extends Thread{

    Store store;

    Producer(Store store){
        this.store = store;
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++){
            store.put();
        }
    }
}

