package com.breakingbad.socket;

import java.io.*;
import java.net.Socket;

public class MyclientSocket {
    public static void main(String[] args) {
        String msg = "Client Data";

        try {
            Socket socket = new Socket("127.0.0.1",8080);
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw.println(msg);
            pw.flush();
            String line = is.readLine();
            System.out.println("received from server:" + line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
