package client;

import java.io.*;
import java.net.Socket;

public class RequestProcessor {
    private final int port;

    public RequestProcessor(int port) {
        this.port = port;
    }

    public Double add(Double a, Double b) throws IOException {
        try {
            Socket socket = new Socket("localhost", 6666);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            writer.write(a + "\n");
            writer.write(b + "\n");
            writer.flush();

            return Double.parseDouble(reader.readLine());
        } catch (IOException e) {
            throw new IOException("Err_Connection.");
        }
    }
}
