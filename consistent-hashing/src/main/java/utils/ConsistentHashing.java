package utils;

import com.google.common.hash.Hashing;
import model.Server;

import java.nio.charset.StandardCharsets;
import java.util.TreeMap;

public class ConsistentHashing {

    //  create hash ring
    private final TreeMap<Integer, Server> hashRing=new TreeMap<>();
    private final int virtualNodeCount;

    public ConsistentHashing(int virtualNodeCount) {
        this.virtualNodeCount = virtualNodeCount;
    }


    public void addServer(Server s){
        for (int i = 0; i < virtualNodeCount; i++) {

            String virtualNodeId = s.getId() + "-VN-" + i;
            int hashedServer = hash(virtualNodeId);
            this.hashRing.put(hashedServer, s);

            System.out.println("Added vnode " + virtualNodeId + " at hashedServer " + hashedServer);
        }

    }

    public void removeServer(Server s){
        for (int i = 0; i < virtualNodeCount; i++) {

            String virtualNodeId = s.getId() + "-VN-" + i;

            this.hashRing.remove(hash(virtualNodeId));
        }
        System.out.println("Removed server " + s + "from hash ring");
    }

    public void addData (String data){

        if(this.hashRing.isEmpty()) return;

        int hashedData=hash(data);

        var optimalServer= this.hashRing.ceilingEntry(hashedData);

        if(null == optimalServer) {
            optimalServer=this.hashRing.firstEntry();
        }

        System.out.println("Data - "+ data + " added to server " + optimalServer.getValue() );
    }

    private int hash(String value) {
        return Hashing.murmur3_32_fixed().hashString(value, StandardCharsets.UTF_8).asInt() & Integer.MAX_VALUE;
    }
}
