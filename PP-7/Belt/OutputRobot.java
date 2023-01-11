public class OutputRobot extends Thread{

    Belt conv;
    Detail detail;

    OutputRobot(Belt Conv){
        this.conv = Conv;
    }

    @Override
    public void run() {
        try {
            while(true) {
                detail = conv.getDetail();
                System.out.println("Деталь №" + detail.index + " снята с конвейера разгрузчиком");
                Thread.sleep(400);
            }
        } catch (InterruptedException e) {}
    }
}
