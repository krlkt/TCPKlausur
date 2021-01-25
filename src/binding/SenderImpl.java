package binding;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SenderImpl implements Sender {
    DataOutputStream dos;

    public SenderImpl(DataOutputStream dos){
        this.dos = dos;
    }

    @Override
    public void sendCreateFile(String fileName, String in) throws IOException {
            dos.writeInt(ActionID.CREATE_FILE);
            dos.writeUTF(fileName);
            dos.writeUTF(in);
    }

    @Override
    public void sendDeleteFile(String fileName) throws IOException {
        dos.writeInt(ActionID.DELETE_FILE);
        dos.writeUTF(fileName);
    }

    @Override
    public void sendEnd() {
        try {
            dos.writeInt(99);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
