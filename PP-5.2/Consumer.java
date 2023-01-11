public class Consumer extends Thread{

    Store store;

    Consumer(Store store){
        this.store = store;
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++){
            store.get();
        }
    }
}

