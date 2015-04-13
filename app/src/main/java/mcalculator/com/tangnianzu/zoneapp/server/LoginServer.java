package mcalculator.com.tangnianzu.zoneapp.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Vector;

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

    //count how many users in the user pool,<Id,Port> is the authentication
    private static  HashMap<String,ObjectOutputStream> UserPool=new HashMap<>();
    //private static Vector<OutputStream> pool=new Vector<>();

    //son thread: provide service for Client Request
    // better use "object stream" to transfer

    String userid="";
    public void run() {
        try{
            ObjectInputStream oin=new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oout=new ObjectOutputStream(socket.getOutputStream());
            while(true) {
                Message m = (Message) oin.readObject();
                //Login
                if(m.getType().equalsIgnoreCase(Message.LOGIN)){
                    try {
                        //if the user is already logged in
                        ObjectOutputStream oout1=UserPool.get(userid);
                        if(oout1!=null){oout1.close(); UserPool.remove(userid);}
                    }catch (Exception e){}
                    
                    UserPool.put(userid,oout);

                }else if(m.getType().equalsIgnoreCase(Message.LOGOUT)){

                    UserPool.remove(userid);

                }else if(m.getType().equalsIgnoreCase(Message.SEND_TEXT)){

                }else if(m.getType().equalsIgnoreCase(Message.SEND_IMAGE)){

                }else if(m.getType().equalsIgnoreCase(Message.SEND_AMR)){

                }else if(m.getType().equalsIgnoreCase(Message.HUIFU_TEXT)){

                }else if(m.getType().equalsIgnoreCase(Message.HUIFU_IMAGE)){

                }else if(m.getType().equalsIgnoreCase(Message.HUIFU_AMR)){

                }else if(m.getType().equalsIgnoreCase(Message.REG)){

                }else if(m.getType().equalsIgnoreCase(Message.FIND_USER)){

                }else if(m.getType().equalsIgnoreCase(Message.DOWNLOAD)){

                }
            }
            }catch (Exception e){
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
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
