package client;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        RequestProcessor requestProcessor = new RequestProcessor(6666);
        try {
            System.out.println(requestProcessor.add(0.1d, 0.5d));
            System.out.println(requestProcessor.add(0.7d, 0.5d));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
