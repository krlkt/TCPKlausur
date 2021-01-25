package binding;

import java.io.IOException;
import java.io.InputStream;

public interface Sender {
    /**
     * method to call create file on remote
     * @param fileName name of file to create
     * @param in String where the data is coming from
     */
    void sendCreateFile(String fileName, String in) throws IOException;

    /**
     * method to call to delete file on remote
     * @param fileName name of file to delete
     */
    void sendDeleteFile(String fileName) throws IOException;

    /**
     * stop sending
     */
    void sendEnd();
}
