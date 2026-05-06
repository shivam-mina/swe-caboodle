package utils;

import model.Server;

import java.util.TreeMap;

public class ConsistentHashing {

    //  create hash ring
    private final TreeMap<Integer, Server> hashRing=new TreeMap<>();


    public void addServer(Server s){
        int hashedServer = hash(s.getId());
        this.hashRing.put(hashedServer,s);
        System.out.println("Added server " + s + "in hashedServer ring at hashedServer key " + hashedServer);
    }

    public void removeServer(Server s){
        this.hashRing.remove(hash(s.getId()),s);
        System.out.println("Removed server " + s + "from hash ring");
    }

    public void addData (String data){

        if(this.hashRing.isEmpty()) return;

        int hashedData=hash(data);

        Server optimalServer= this.hashRing.ceilingEntry(hashedData).getValue();

        if(null == optimalServer) {
//            optimalServer=this.hashRing.ceilingEntry().getValue();
            optimalServer=this.hashRing.firstEntry().getValue();
        }

        System.out.println("Data - "+ data + " added to server " + optimalServer );
    }

    private int hash(String value) {
        return Math.abs(value.hashCode());
    }
}
