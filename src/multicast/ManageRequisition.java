package multicast;

/**
 * Created by joao on 03/09/15.
 */

import java.io.IOException;
import java.io.InputStream;

public class ManageRequisition implements Runnable{

    private int m;
    private InputStream input;
    private Server server;

    public ManageRequisition(Server s, InputStream input){
        this.input = input;
        this.server = s;
    }

    // mandar mensagem para saida
    public void readMessage(){
        try {
            while(true){
                m = input.read();
                server.addMessage(m);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        readMessage();
    }
}
