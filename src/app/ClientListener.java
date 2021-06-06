package app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.concurrent.TimeUnit;


public class ClientListener implements Runnable{

    private Socket socket;
    private DataOutputStream output;
    private ObjectInputStream input;
    private DataInputStream onlineInput;

    public ClientListener(Socket socket) throws IOException {
        this.socket = socket;
        input = new ObjectInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());
        onlineInput = new DataInputStream(socket.getInputStream());
    }
    public void sendMassage() throws IOException {
        while (onlineInput.readBoolean()) {
            try {
                output.writeUTF("Online");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            try {
                TimeUnit.MINUTES.sleep(1);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void run() {

        while (true) {
            try {
                Object object = input.readObject();
                ObjectHandler objectHandler = new ObjectHandler(object);
                sendMassage();
//                if(objectHandler.getUser() != null) {
//                }
//                else if(objectHandler.getPost() != null) {
//                }
//                else {
//
//                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
