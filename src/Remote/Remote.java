package Remote;

import TCPDataConnection.DataConnector;
import exception.FileException;

import java.io.IOException;
import java.io.InputStream;

public interface Remote {
    /**
     * create a new file and write into the new file from Input stream
     * @param fileName name of the file to create and write into
     * @param is InputStream to read from
     */
    void copyAndCreateFile(String fileName, InputStream is) throws IOException, FileException;

    /**
     * erase file
     * @param fileName name of the wanted file to erase
     * @return true if successfully erased, else false
     */
    boolean erase(String fileName);


    void initTCP() throws IOException;

}
