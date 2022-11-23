package com.phoenixdian.socket.talk;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;

public class TcpClientSteam {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //send
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
        bufferedWriter.write("Hello server i'm client");
        bufferedWriter.newLine();//插入一个换行符，表示写入的内容结束，对方读取要用readLine()
        bufferedWriter.flush();//使用字符流需要手动刷新
        //receive
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        String message = bufferedReader.readLine();
        System.out.println("response from server :" + message);
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
    }
}
