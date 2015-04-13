package mcalculator.com.tangnianzu.zoneapp.server;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by tangnianzu on 4/13/15.
 */
public class Message implements Serializable
{

    public static final String LOGIN="LOGIN";
    public static final String LOGOUT="LOGOUT";
    public static final String REG="REG";
    public static final String SEND_TEXT="SEND_TEXT";
    public static final String SEND_IMAGE="SEND_IMAGE";
    public static final String SEND_AMR="SEND_AMR";
    public static final String HUIFU_TEXT="HUIFU_TEXT";
    public static final String HUIFU_IMAGE="HUIFU_IMAGE";
    public static final String HUIFU_AMR="HUIFU_AMR";
    public static final String FIND_USER="FIND_USER";



    public Hashtable value=null;//come
    public Hashtable returnValue=null;//go
    public String type="";





    public Hashtable getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public Hashtable getReturnValue() {
        return returnValue;
    }

    public void setValue(Hashtable value) {
        this.value = value;
    }

    public void setReturnValue(Hashtable returnValue) {
        this.returnValue = returnValue;
    }

    public void setType(String type) {
        this.type = type;
    }
}
