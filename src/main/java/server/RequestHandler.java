package server;

import java.io.*;
import java.net.Socket;

public class RequestHandler {
    private final Socket socket;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    public void process() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        final Double numberA = Double.parseDouble(in.readLine());
        final Double numberB = Double.parseDouble(in.readLine());
        final String result = String.valueOf((numberA * 10 + numberB * 10) / 10);
        System.out.println(String.format("Numbers received: %s %s -> %s", numberA, numberB, result));
        out.write(result + '\n');
        out.flush();

        in.close();
        out.close();;
    }
}
