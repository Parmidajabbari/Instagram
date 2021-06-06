package app;

import java.io.IOException;

public class ClientMain {

    public static void main(String[] args) throws IOException {
        try {
            Client client = new Client();
            client.setConnection();
        }
       catch (IOException e) {
            e.printStackTrace();
       }
    }
}
