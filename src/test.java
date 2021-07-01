import controllers.NewPostController;

import java.io.File;
import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        File file = new File("sbu.png");
        System.out.println(NewPostController.encodeFileToBase64Binary(file));
    }
}
