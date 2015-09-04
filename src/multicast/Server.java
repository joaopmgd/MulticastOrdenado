package multicast;

/**
 * Created by joao on 03/09/15.
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread {

    private ServerSocket serverSocket;
    private ArrayList<Socket> socketList;

    public Server(int port){
        try {
            this.serverSocket = new ServerSocket(port);
            this.socketList = new ArrayList<Socket>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void receiveMessage() {
        try {
            System.out.println("Iniciada thread do server.");
            while (true) {
                Socket client = serverSocket.accept();
                socketList.add(client);
                ManageRequisition stream = new ManageRequisition(client);
                stream.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        receiveMessage();
    }
}

