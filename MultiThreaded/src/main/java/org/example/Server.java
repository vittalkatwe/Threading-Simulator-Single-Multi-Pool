package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Server {


    public Consumer<Socket> getConsumer() {
//      Method 1
//        return new Consumer<Socket>() {
//            @Override
//            public void accept(Socket socket) {
//                try {
//                    PrintWriter toClient= new PrintWriter(socket.getOutputStream());
//                    toClient.println("Hello from server");
//                    toClient.close();
//                    socket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        };


//        Method 2
        return (clientSocket) -> {
            try(PrintWriter toSocket = new PrintWriter(clientSocket.getOutputStream(), true)) {
                toSocket.println("hello from server "+clientSocket.getInetAddress());
            }catch(IOException e) {
                e.printStackTrace();
            }
        };
    }



    public static void main(String[] args) {
        int port = 8010;
        Server server = new Server();
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(70000);
            System.out.println("Server listening on port " + port);
            while (true) {
                Socket acceptedConnection = serverSocket.accept();
                Thread thread = new Thread(() -> server.getConsumer().accept(acceptedConnection));
                thread.start();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}