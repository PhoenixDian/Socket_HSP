package com.phoenixdian.socket.sayhi;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("server listening");
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readLen;
        while ((readLen=inputStream.read(bytes))!=-1){
            System.out.print(new String(bytes,0,readLen));
        }
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
