package mcalculator.com.tangnianzu.zoneapp.server;

import java.net.Socket;

/**
 * Created by tangnianzu on 4/12/15.
 */


//Login Server


public class LoginServer extends Thread {


    private Socket socket=null;

    public LoginServer(Socket socket){
        this.socket=socket;
    }

}
