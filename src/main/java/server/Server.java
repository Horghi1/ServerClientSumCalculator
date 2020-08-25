package server;

import java.io.IOException;

public class Server {
    public static void main(String[] args) {
        ServerController serverController = new ServerController(6666);
        try {
            serverController.start();
        } catch (IOException e) {
            System.out.println("Connection could not be established.");
        }
    }
}
