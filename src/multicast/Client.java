package multicast;

/**
 * Created by joao on 03/09/15.
 */

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Client{

    private Socket socket;
    private ArrayList<Socket> socketList;

    public Client(String ip ,int porta){
        try {
            socket = new Socket (ip, porta);
            socketList.add(socket);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(int message){
        try {
            for(Socket s:socketList){
                s.getOutputStream().write(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
