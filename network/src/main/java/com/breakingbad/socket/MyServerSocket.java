package com.breakingbad.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        Socket socket = server.accept();
        BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = is.readLine();
        System.out.println("received from client: " + line);
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        pw.println("received data: " + line);
        pw.flush();
        pw.close();
        is.close();
        socket.close();
        server.close();
    }
}
