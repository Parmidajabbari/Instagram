package app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class Client {

    private Socket socket;
    private static SSSocket ssSocket;
    private static DataInputStream input;
    private static DataOutputStream output;
    private int indexOfConn;


    public void setConnection() throws IOException {
        try {
            int port = 9090;
            String ip = "localhost";
            socket = new Socket(ip, port);
            ssSocket = new SSSocket(socket);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            indexOfConn = input.readInt();

            ClientListener clientListener = new ClientListener(socket);
            new Thread(clientListener).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendRequest(String json) throws IOException {
        try {
            output.writeUTF(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Close() throws IOException {
        try {
            output.flush();
            output.close();
            input.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void sendMessage(byte[] message) throws IOException {
        output.writeInt(message.length);
        output.write(message);
    }

    public static byte[] readMessage() throws IOException {
        byte[] byteBuffer = new byte[1024];
        int length;
        int messageLength = input.readInt();
        if (messageLength < 0) {
            return new byte[0];
        }
        byte[] message = new byte[messageLength];
        int read = 0;
        while (read < messageLength) {
            if ((length = input.read(byteBuffer)) != -1) {
                int readableLength = read + length <= messageLength ? length : messageLength - read;
                if (readableLength >= 0) System.arraycopy(byteBuffer, 0, message, read, readableLength);
                read += length;
            } else {
                break;
            }
        }

        return message;
    }

    public int getIndexOfConn() {
        return indexOfConn;
    }
}

