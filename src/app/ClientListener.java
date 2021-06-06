package app;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

import static app.ClientThreadHandler.isOnline;

public class ClientListener implements Runnable{

    private Socket socket;
    private DataOutputStream output;
    private ObjectInputStream input;

    public ClientListener(Socket socket) throws IOException {
        this.socket = socket;
        input = new ObjectInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());
    }
    public void sendMassage() {
        while (isOnline) {
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
