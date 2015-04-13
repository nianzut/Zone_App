package mcalculator.com.tangnianzu.zoneapp.tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by tangnianzu on 4/12/15.
 */


//property file operation class

public class ServerConfig {

    private static Properties p=new Properties();
    static {
        try {
            p.load(new FileInputStream("./server.ini"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error in Server Configuration file *.ini!");
        }
    }

    public static String getValue(String key){
        return p.getProperty(key);
    }
}
