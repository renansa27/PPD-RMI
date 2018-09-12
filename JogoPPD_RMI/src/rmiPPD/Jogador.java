package rmiPPD;

public class Jogador {

    public String name;
    public ClienteItf client;

    //constructor
    public Jogador(String name, ClienteItf client) {
        this.name = name;
        this.client = client;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public ClienteItf getClient() {
        return client;
    }
}