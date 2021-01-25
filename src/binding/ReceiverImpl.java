package binding;

import exception.FileException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReceiverImpl extends Thread implements Receiver {
    DataInputStream dis;
    InputStream is;
    Reader reader;

    public ReceiverImpl(DataInputStream dis, Reader reader){
        this.dis = dis;
        this.reader = reader;
        this.start();
    }

    @Override
    public void receiveCreateFile(String fileName, InputStream is) throws IOException, FileException {
        reader.readCreateFile(fileName, is);
    }

    @Override
    public void receiveDeleteFile(String fileName) {
        reader.readDeleteFile(fileName);
    }

    public void run(){

        boolean running = true;
        System.out.println("Running...");

        try {
            if (running) {
                int command = 0;
                command = dis.readInt();

                if (command == ActionID.CREATE_FILE) {
                    String fileName = dis.readUTF();
                    receiveCreateFile(fileName, dis);
                }

                else if (command == ActionID.DELETE_FILE) {
                    String fileName = dis.readUTF();
                    receiveDeleteFile(fileName);
                }

                else{
                    running = false;
                }
            }
        } catch (IOException | FileException io) {
            System.out.println("error occurred");
        }

    }
}
