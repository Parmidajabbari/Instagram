package app;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientListener implements Runnable{

    private Socket socket;
    private DataOutputStream output;
    private ObjectInputStream input;

    public ClientListener(Socket socket) throws IOException {
        this.socket = socket;
        input = new ObjectInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {

        while (true) {
            try {
                Object object = input.readObject();
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
