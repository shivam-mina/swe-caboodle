package model;

public class Server {

    private String id;

    @Override
    public String toString() {
        return "Server{" +
                "id='" + id + '\'' +
                '}';
    }

    public Server(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
