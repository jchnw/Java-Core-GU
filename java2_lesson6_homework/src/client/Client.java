package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;

    public Client(){
        Scanner scan = new Scanner(System.in);
        try {
            socket = new Socket("localhost", 8080);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            Resender resender = new Resender();
            resender.start();
            String str ="";
            while (!str.equals("exit")) {
                str = scan.nextLine();
                out.println(str);
            }

            resender.setStop();
        }
        catch (IOException e){
            System.out.println("Что-то пошло не так");
        }
        finally {
            close();
        }



    }
    private class Resender extends Thread {

        private boolean stopped;

        public void setStop() {
            stopped = true;
        }

        @Override
        public void run() {
            try {
                while (!stopped) {
                    String str = in.readLine();
                    System.out.println("Server:" + str);
                }
            } catch (Exception e) {
                System.err.println("Ошибка при получении сообщения");

            }
        }
    }
     private void close() {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (Exception e) {
                System.err.println("Потоки не были закрыты!");
            }
     }
}

