package app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

    private Socket socket;
    private static DataInputStream input;
    private static DataOutputStream output;
    private int indexOfConn;

    public void setConnection() throws IOException {
        try {
            int port = 9090;
            String ip = "localhost";
            socket = new Socket(ip, port);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            indexOfConn = input.readInt();

            ClientListener clientListener = new ClientListener(socket);
            new Thread(clientListener);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendRequest(String json) throws IOException {
        try {
            output.writeUTF(json);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Close() throws IOException {
        try {
            output.flush();
            output.close();
            input.close();
            socket.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getIndexOfConn() {
        return indexOfConn;
    }
}

