import model.Server;
import utils.ConsistentHashing;

public class main {
    public static void main(String[] args) {
        ConsistentHashing ring = new ConsistentHashing(10);

        ring.addServer(new Server("Tokyo-East"));
        ring.addServer(new Server("Osaka-West"));
        ring.addServer(new Server("Hokkaido-North"));

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        ring.addData("shivam");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        ring.addData("aryan");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        ring.addData("zenith");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        ring.addData("alexios");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        ring.addData("donald");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");


    }
}