package TCPDataConnection;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class DataConnector extends Thread implements DataConnection {
    Socket socket;
    ServerSocket srvSocket;
    String hostName;
    int port;
    Boolean asServer;

    /**
     * Constructor client and server side
     * Create client side - open connection to address / port
     * Create server side - open port on this port and wait for one client
     * @param host
     * @param port
     * @param asServer
     * @throws IOException
     */
    public DataConnector(String host, int port, boolean asServer) throws IOException {
        //this is a server
        if(asServer){
            this.port = port;
            this.asServer = true;
            this.start();
        }
        //this is a client
        else{
            this.hostName = host;
            this.port = port;
            this.asServer = false;

            socket = new Socket(hostName, this.port);
            System.out.println("connecting socket to server");
        }
    }

    @Override
    public DataOutputStream getDataOutputStream() throws IOException {
        return new DataOutputStream(socket.getOutputStream()) ;
    }

    @Override
    public DataInputStream getDataInputStream() throws IOException {
        return new DataInputStream(socket.getInputStream());
    }

    public void run(){
        if(asServer) {
            try {
                srvSocket = new ServerSocket(port);
                System.out.println("server socket created, waiting for client");

                socket = srvSocket.accept();
                System.out.println("client connected");
            } catch (IOException e) {
                System.out.println("something unexpected occurred");
            }
        }

    }
}
