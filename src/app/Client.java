package app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
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


    public static void sendMessage(byte[] message) throws IOException {
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


        output.write(fullMessage);
        output.flush();
    }
    public static byte[] readMessage() throws IOException {
        int bufferLength = 0;
        byte[] byteBuffer = new byte[0];
        byte[] ret = byteBuffer.clone();
        boolean lengthFound = false;
        int length = 0;
        int lastLengthByte = 0;
        int lastMask = 1;
        while(true){

            while ((!lengthFound) && (bufferLength > lastLengthByte)){
                byte currLengthByte = ret[lastLengthByte];
                if (currLengthByte >= 0) {
                    lengthFound = true;
                    length += lastMask * currLengthByte;
                }
                else {
                    length = lastMask * (currLengthByte + 128);
                    lastMask *= 128;
                }
                lastLengthByte++;
            }

            if(lengthFound){
                if(bufferLength >= length + lastLengthByte){
                    byte[] tempB
                            = new byte[bufferLength - length - lastLengthByte];
                    for (int i = 0; i < tempB.length; i++)
                        tempB[i] = ret[i + length + lastLengthByte];
                    byteBuffer = tempB;
                    bufferLength = tempB.length;

                    byte[] realRetThisTime = new byte[length];
                    System.arraycopy(ret, lastLengthByte
                            , realRetThisTime, 0, length);
                    return realRetThisTime;
                }
            }

            byte[] tempB = new byte[512];
            int numOfBytesRead = input.read(tempB, 0, 512);
            byte[] tempRet = ret.clone();
            bufferLength += numOfBytesRead;
            ret = new byte[bufferLength];
            System.arraycopy(tempRet, 0, ret, 0, tempRet.length);
            if (numOfBytesRead >= 0)
                System.arraycopy(tempB, 0, ret, tempRet.length, numOfBytesRead);

        }
    }
    public int getIndexOfConn() {
        return indexOfConn;
    }
}

