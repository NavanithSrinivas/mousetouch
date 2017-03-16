package com.example.nava.clkmouse.networkutil;

/**
 * Created by nava on 8/3/17.
 */
import android.util.Log;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;


public class NetUtils {

    public static final String SERVER_IP = "192.168.165.33";
    public static final int SERVER_PORT = 9877;
    public static boolean pingServer(String server_ip){
        Socket socket = null;
        try {
            Log.i("", "" + server_ip);
            socket = new Socket(server_ip==null?SERVER_IP:server_ip, SERVER_PORT);
//            Writer writer = new OutputStreamWriter(socket.getOutputStream());
//            writer.write(String.valueOf(1));
//            //writer.write("hello");
//            writer.flush();
//            writer.close();
            // socket.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {

        }

    }
}

