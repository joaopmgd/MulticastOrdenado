package multicast;

/**
 * Created by joao on 03/09/15.
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread {

    private ServerSocket socket;
    private ArrayList<Socket> socketList;
    private ArrayList<Integer> messages;
    private int pid;

    public Server(int porta, int pid){
        try {
            this.pid = pid;
            socketList = new ArrayList<Socket>();
            socket = new ServerSocket(porta);
            messages = new ArrayList<Integer>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> getMessage(){
        return messages;
    }

    //Adicionar na ordem ***
    public void addMessage(int message){
        messages.add(message);
        System.out.println(message + " - " + pid);
    }

    public void receiveMessage(){
        try {
            while(true){
                Socket s = socket.accept(); // enquanto nao vir uma requisiçao nao passa dessa linha - trava
                socketList.add(s);
                ManageRequisition mr = new ManageRequisition(this, s.getInputStream());
                Thread t = new Thread(mr);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        receiveMessage();
    }

    public ArrayList<Socket> getStreams(){
        return socketList;
    }
}

