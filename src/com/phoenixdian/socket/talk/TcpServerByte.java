package com.phoenixdian.socket.talk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TcpServerByte {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("listening");
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int length=0;
        while ((length= inputStream.read(bytes))!=-1){
            System.out.print(new String(bytes,0,length));
        }
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("response".getBytes(StandardCharsets.UTF_8));
        socket.shutdownOutput();
        outputStream.close();
        inputStream.close();
        serverSocket.close();
    }
}
