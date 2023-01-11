public class Program {

    public static void main(String[] args){
        CommonResource dataX = new CommonResource();
        for (int i=0; i<5; i++){
            TestThread t = new TestThread(dataX);
            t.setName("Thread #" + i);
            t.start();
        }

    }

}
