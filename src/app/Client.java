package app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    private final int port = 9090;
    private final String ip= "localhost";
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
    private int indexOfConn;
    private static final ExecutorService threadPool = Executors.newCachedThreadPool();

    public void setConnection() throws IOException {

        try {
            socket = new Socket(ip , port);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            indexOfConn = input.readInt();

            ClientListener clientListener = new ClientListener(socket);
            threadPool.execute(clientListener);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Write() throws IOException {
//            try {
//                //.
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            }
    }

    public void sendRequest(String json) throws IOException {
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

}

