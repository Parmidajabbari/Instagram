package app;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class ClientThreadHandler implements Runnable {

    private final Socket socket;
    private final DataInputStream input;
    private final DataInputStream onlineInput;
    public static boolean isOnline = false;

    public ClientThreadHandler(Socket socket) throws IOException {
        this.socket = socket;
        input = new DataInputStream(socket.getInputStream());
        onlineInput = new DataInputStream(socket.getInputStream());
    }

    public void receiveMassage() {
        while (isOnline) {
            try {
                if(onlineInput.readUTF().equals("Online")) {
                    return;
                }
                else {
                    isOnline = false;
                }
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
                String json = input.readUTF();
                receiveMassage();
                // doTask in TaskManager
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
