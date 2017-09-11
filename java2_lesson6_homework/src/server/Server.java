package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    ServerSocket server;
    private PrintWriter out;
    private BufferedReader in;
    Socket socket;

    public Server() {
        Scanner scan = new Scanner(System.in);
        server = null;
        socket = null;
        String msg;

        try {
            server = new ServerSocket(8080);
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = server.accept();
            System.out.println("Клиент подключился");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            Connected con = new Connected();
            con.start();
            while (true) {
                msg = scan.nextLine();
                out.println(msg);
                if (msg.equalsIgnoreCase("exit")) break;
            }
            if (msg.equalsIgnoreCase("exit")){
                closeAll();
            }
            con.setStop();


        } catch (IOException e) {
            System.out.println("Ошибка инициализации сервера");
        } finally {
            closeAll();

        }
    }
    private void closeAll(){
        try {

            in.close();
            out.close();
            socket.close();
            server.close();
        } catch (IOException e){

        }
    }
    private class Connected extends Thread {
        private boolean stopped;

        public void setStop() {
            stopped = true;
        }

        @Override
        public void run() {
            try {
                while (!stopped) {
                    String str = in.readLine();
                    if (str.equalsIgnoreCase("exit")){
                        closeAll();
                    }
                    System.out.println("Client: " + str);
                }
            } catch (Exception e) {
                System.err.println("Ошибка при получении сообщения");

            }
        }
    }
}