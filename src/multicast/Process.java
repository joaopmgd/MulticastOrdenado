package multicast;

/**
 * Created by joao on 03/09/15.
 */

public class Process extends Thread{

    private String ip;
    private int port;
    private int pid;
    private int clock;

    private Client client;
    private Server server;


    public Process(String ip ,int port, int pid){
        this.ip = ip;
        this.port = port;
        this.pid = pid;
        this.clock = 0;
        this.client = new Client();
    }

    public void startListening(){
        this.server = new Server(port);
        server.start();
        this.client.connect(ip, port);
    }

    public void connect(String ip, int port) {
        this.client.connect(ip, port);
    }

    public void sendMessage(){
        this.clock++;
        client.sendMessage(this.clock, this.pid);
    }

    @Override
    public void run(){
        startListening();
    }
}
