import model.Server;
import utils.ConsistentHashing;

public class main {
    public static void main(String[] args) {
        ConsistentHashing ring = new ConsistentHashing();

//        ring.addServer(new Server("Tokyo-East"));
        ring.addServer(new Server("Osaka-West"));
        ring.addServer(new Server("Hokkaido-North"));

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        ring.addData("shivam");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        ring.addData("aryan1009");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        ring.addData("zenith57");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        ring.addData("alexios29");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        ring.addData("donaldtrump");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");


    }
}