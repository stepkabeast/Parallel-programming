import java.util.Random;

public class Detail {

    int mass;
    int index;
    Random r = new Random();
    static int number=0;

    Detail(){
        this.index=++number;
        this.mass=r.nextInt(201)+300;
    }

}
