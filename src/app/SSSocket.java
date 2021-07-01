package app;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class SSSocket {
    public Socket socket;
    byte[] byteBuffer;
    int bufferLength = 0;
    OutputStream out;
    InputStream in;

    public SSSocket (String host, int port) throws IOException {
        socket =  new Socket(host, port);
        byteBuffer = new byte[0];
        out = socket.getOutputStream();
        in = socket.getInputStream();
    }

    public SSSocket (Socket s) throws IOException {
        socket = s;
        byteBuffer = new byte[0];
        out = socket.getOutputStream();
        in = socket.getInputStream();
    }



    public void sendMessage(byte[] message) throws IOException {
        int messageLen = message.length;
        ArrayList<Byte> lengthHelperBytes = new ArrayList<>();

        while(messageLen > 0){
            byte t = (byte) (messageLen % 128);
            messageLen /= 128;
            if (messageLen > 0)
                t = (byte) (t + 128);
            lengthHelperBytes.add(t);
        }

        byte[] fullMessage = new byte[message.length + lengthHelperBytes.size()];
        for (int i = 0; i < lengthHelperBytes.size(); i++)
            fullMessage[i] = lengthHelperBytes.get(i);
        for(int i =0; i < message.length; i++){
            fullMessage[i + lengthHelperBytes.size()] = message[i];
        }


        out.write(fullMessage);
        out.flush();
    }


    public void close() throws IOException {
        socket.close();

    }
}
