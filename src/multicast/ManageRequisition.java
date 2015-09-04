package multicast;

/**
 * Created by joao on 03/09/15.
 */

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class ManageRequisition extends Thread{

    private Socket server;
    private ArrayList<Message> messages;

    public ManageRequisition(Socket server){
        this.server=server;
    }

    public void readMessage(){
        try {
            System.out.println("Iniciada a thread do manage requisition.");
            byte[] object = new byte[1024];
            while(true) {
                int i = 0;
                server.getInputStream().read(object);
                Message message = (Message)Utils.getObject(object);
                System.out.println("Mensagem recebida.");
                if (messages != null) {
                    for (Message m : messages) {
                        if (message.getClockFromProcess() < m.getClockFromProcess()) {
                            messages.add(i, message);
                        } else {
                            i++;
                        }
                    }
                }else{
                    messages.add(message);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    @Override
    public void run() {
        readMessage();
    }
}
