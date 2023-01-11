public class Program {

    public static void main (String[] args){

        Belt factory = new Belt();

        for (int i=1; i<3; i++){
            new InputRobot(i, factory).start();
        }

        new OutputRobot(factory).start();

    }

}
