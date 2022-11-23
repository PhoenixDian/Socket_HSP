package com.phoenixdian.socket.talk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TcpClientByte {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hi".getBytes(StandardCharsets.UTF_8));
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int length;
        while ((length= inputStream.read(bytes))!=-1){
            System.out.print(new String(bytes,0,length));
        }
        outputStream.close();
        inputStream.close();
        socket.close();
    }
}
