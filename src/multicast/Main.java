package multicast;

/**
 * Created by joao on 03/09/15.
 */

import java.io.IOException;

public class Main {

    public static void main(String args[]){
        Process p = null;
        int connect;

        if (args[0].equals("1")){
            System.out.println(1);
            p = new Process("localhost", 3001, 1);
        }else if (args[0].equals("2")){
            System.out.println(2);
            p = new Process("localhost", 3002, 2);
        }else if (args[0].equals("3")){
            System.out.println(3);
            p = new Process("localhost", 3003, 3);
        }

        try {
            connect = System.in.read();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (args[0].equals("1")){
            System.out.println("connect 1");
            p.connect("localhost", 3002);
            p.connect("localhost", 3003);
        }else if (args[0].equals("2")){
            System.out.println("connect 2");
            p.connect("localhost", 3001);
            p.connect("localhost", 3003);
        }else if (args[0].equals("3")){
            System.out.println("connect 3");
            p.connect("localhost", 3002);
            p.connect("localhost", 3001);
        }

        p.startListening();

        if (args[0].equals("1")){
            p.sendMessage(1);
        }else if (args[0].equals("2")){
            p.sendMessage(2);
        }else if (args[0].equals("3")){
            p.sendMessage(3);
        }
    }

}
