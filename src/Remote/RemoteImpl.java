package Remote;

import TCPDataConnection.DataConnection;
import TCPDataConnection.DataConnector;
import binding.Reader;
import binding.Receiver;
import binding.ReceiverImpl;
import exception.FileException;

import java.io.*;

public class RemoteImpl implements Remote, Reader {
    DataConnection connection;
    Receiver receiver;

    public RemoteImpl(int port) throws IOException {
        connection = new DataConnector(null, port, true);
    }

    public RemoteImpl() {
    }

    @Override
    public void copyAndCreateFile(String fileName, InputStream is) throws IOException, FileException {
        File file = new File("RemoteFolder/"+fileName);
        if(file.exists()){
            throw new FileException("File already exists");
        }

        FileOutputStream fos = new FileOutputStream(file);

        int read= 0;
        do{
            read = is.read();
            if(read != -1){
                fos.write(read);
            }
        }while(read != -1);

    }

    @Override
    public boolean erase(String fileName) {
        File file = new File("RemoteFolder/"+fileName);
        if(!file.exists()){
            System.out.println("Nothing to delete");
            return false;
        } else{
            file.delete();
            return true;
        }
    }

    @Override
    public void initTCP() throws IOException {
        this.receiver = new ReceiverImpl(connection.getDataInputStream(), this);
    }

    @Override
    public void readCreateFile(String fileName, InputStream is) throws IOException, FileException {
        this.copyAndCreateFile(fileName, is);
    }

    @Override
    public void readDeleteFile(String fileName) {
        this.erase(fileName);
    }
}
