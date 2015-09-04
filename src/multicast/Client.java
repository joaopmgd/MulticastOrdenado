package multicast;

/**
 * Created by joao on 03/09/15.
 */

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client{

    private ArrayList<Socket> socketList;

    public Client(){
        socketList = new ArrayList<Socket>();
    }

    public void connect(String ip, int port){
        try{
            Socket socket = new Socket(ip,port);
            socketList.add(socket);
            System.out.println("Conectado ao processo a porta: " + port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(int clock, int pid){
        try {
            System.out.println("Entre com a mensagem a ser enviada pelo processo " + pid);
            Scanner scanner = new Scanner(System.in);
            String text = scanner.nextLine();
            System.out.println("Enviando mensagem com texto: " + text + "\nclock: " + clock + "\npid: " + pid);
            Message message = new Message(text,clock,pid);
            for(Socket s:socketList){
                OutputStream out = s.getOutputStream();
                out.write(Utils.getBytes(message));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
