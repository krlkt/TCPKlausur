package binding;

import exception.FileException;

import java.io.IOException;
import java.io.InputStream;

public interface Receiver {
    /**
     * server will run and receive call on method create file
     * @param fileName
     * @param is
     */
    void receiveCreateFile(String fileName, InputStream is) throws IOException, FileException;

    /**
     * server will run and receive call on method delete
     * @param fileName
     */
    void receiveDeleteFile(String fileName);
}
