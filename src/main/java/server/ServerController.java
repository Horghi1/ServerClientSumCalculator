package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerController {

    private final int port;

    public ServerController(int port) {
        this.port = port;
    }


    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);

        while(true) {
            System.out.println("Server is waiting for connections.");
            Socket clientSocket = serverSocket.accept();
            System.out.println("New connection established.");
            RequestHandler requestHandler = new RequestHandler(clientSocket);
            try {
                requestHandler.process();
            } catch (IOException ex) {
                System.out.println("Connection could not be established.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid numbers");
            }
        }
    }
}
