package Local;

import TCPDataConnection.DataConnector;
import binding.Sender;
import binding.SenderImpl;
import exception.FileException;

import java.io.*;

public class LocalImpl implements Local {
    DataConnector connection;
    Sender sender;

    public LocalImpl(String hostName, int port) throws IOException {
        connection = new DataConnector(hostName, port, false);
    }

    public LocalImpl() {
    }

    @Override
    public void createFile(String fileName, String insideText) throws FileException, IOException {
        File file = new File("LocalFolder/"+fileName);
        if(file.exists()){
            throw new FileException("File already exists");
        }

        FileOutputStream fos = new FileOutputStream(file);

        byte[] b = insideText.getBytes();
        fos.write(b);
        fos.close();
    }

    @Override
    public void initTCP() throws IOException {
        this.sender = new SenderImpl(connection.getDataOutputStream());
    }

    @Override
    public void createOnRemote(String fileName, String input) throws IOException {
        sender.sendCreateFile(fileName, input);
    }

    @Override
    public void deleteOnRemote(String fileName) throws IOException {
        sender.sendDeleteFile(fileName);
    }
}
