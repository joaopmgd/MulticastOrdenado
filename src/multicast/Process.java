package multicast;

/**
 * Created by joao on 03/09/15.
 */

public class Process {

    private String ip;
    private int porta;
    private Client client;
    private Server server;
    private int pid;

    public Process(String ip ,int porta, int pid){
        this.ip = ip;
        this.porta = porta;
        this.server = new Server(porta,pid);
        this.pid = pid;
    }

    public void showMessages(){
        System.out.println(pid);
        for (int m: server.getMessage()){
            System.out.println(m);
        }
    }

    public void sendMessage(int m){
        client.sendMessage(m);
    }

    public void connect(String ip, int porta){
        this.client = new Client(ip, porta);
    }

    public void startListening(){
        server.start();
    }

    public String getIP(){
        return ip;
    }

    public int getPorta(){
        return porta;
    }
}
