package mcalculator.com.tangnianzu.zoneapp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import mcalculator.com.tangnianzu.zoneapp.tools.ServerConfig;

/**
 * Created by tangnianzu on 4/12/15.
 */


//Login Server


public class LoginServer extends Thread {


    private Socket socket = null;

    public LoginServer(Socket socket) {
        this.socket = socket;
    }

    //son thread: Client Request
    public void run() {

    }


    private static ServerSocket server = null;
    private static boolean b = true;


    public static void openServer() throws Exception {
        try {
            server = new ServerSocket(Integer.parseInt(ServerConfig.getValue("server_port")));
            while (b) {
                new LoginServer(server.accept()).start();//give the client socket object to LoginServer and start the son thread

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            throw ex;
        }
    }

    public static void closeServer() throws Exception {
       try {
           b = false;
           server.close();
       }catch (Exception ex){
           throw ex;
       }
    }
}
