package Local;

import TCPDataConnection.DataConnector;
import exception.FileException;

import java.io.IOException;
import java.io.InputStream;

public interface Local {
    /**
     * create file and write insideText into the file
     * @param fileName name of the fileName to create
     * @param insideText String text to write into the file
     */
    void createFile(String fileName, String insideText) throws FileException, IOException;

    /**
     * initialize TCP Connection to remote
     * @param host String hostname
     * @param port int port
     */
    void initTCP() throws IOException;

    void createOnRemote(String fileName, String input) throws IOException;

    void deleteOnRemote(String fileName) throws IOException;


}
