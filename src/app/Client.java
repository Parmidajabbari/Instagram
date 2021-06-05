package app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private final int port = 9090;
    private final String ip= "localhost";
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
    private int indexOfConn;

    public void setConnection() throws IOException {

        try {
            socket = new Socket(ip , port);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            indexOfConn = input.readInt();
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

