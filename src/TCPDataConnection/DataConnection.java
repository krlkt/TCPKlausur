package TCPDataConnection;

import java.io.*;

public interface DataConnection {

    DataOutputStream getDataOutputStream() throws IOException;

    DataInputStream getDataInputStream() throws IOException;

}
