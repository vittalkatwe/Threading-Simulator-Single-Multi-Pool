package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Server {
    private final ExecutorService threadPool;

    public Server(int poolSize) {
        this.threadPool = Executors.newFixedThreadPool(poolSize);
    }

    public void handlePool(Socket socket) {
        try(PrintWriter toClient = new PrintWriter(socket.getOutputStream() , true)){
            toClient.println("hello from server");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int poolSize = 10;
        int port =8010;
        Server server = new Server(poolSize);
        try{
            ServerSocket socket=new ServerSocket(port);
            socket.setSoTimeout(70000);
            System.out.println("server is listening on port "+port);
            while(true){
                Socket client = socket.accept();
                server.threadPool.execute(() -> server.handlePool(client));
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            server.threadPool.shutdown();
        }
    }
}