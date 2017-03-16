package com.example.nava.clkmouse.networkutil;

/**
 * Created by nava on 8/3/17.
 */


import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.example.nava.clkmouse.operation.CommandParser;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;


public class CommandSender extends Thread {
    public static final int SEND_COMAND = 0;


    public static final String SERVER_IP = "192.168.165.33";
    public static final int SERVER_PORT = 9869;

    private String mServerIP;
    private int mServerPort;
    private Socket socket;

    public Handler mHandler;


    public CommandSender(String serverIp, int port) {
        mServerIP = serverIp == null ? SERVER_IP : serverIp;
        mServerPort = port == -1 ? SERVER_PORT : port;

    }


    private boolean send(String str) {
        try {

            Log.i("", "ip: " + mServerIP + "port: " + SERVER_PORT);

            socket = new Socket(mServerIP, SERVER_PORT);
            Log.i("", "socket: " + socket);
            Writer writer = new OutputStreamWriter(socket.getOutputStream());

            writer.append(str);
            writer.flush();
            writer.close();
            socket.close();

            return true;


        } catch (IOException e) {
            return false;
        }
    }


    @Override
    public void run() {

        Looper.prepare();
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                switch (msg.what) {
                    case SEND_COMAND:
                        String command = (String) msg.obj;
                        send(command);
                        break;
                    default:
                        Log.e(CommandSender.class.getName(), "Unknown command msg.what = " + msg.what);
                }
            }
        };
        Looper.loop();
    }




}
