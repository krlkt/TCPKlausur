package ConnectionTest;

import Local.*;
import Remote.*;
import exception.FileException;
import org.junit.Test;

import java.io.IOException;

public class ConnectionTest {
    @Test
    public void connectionTest() throws IOException, FileException {
        Remote remote = new RemoteImpl(9999);
        Local local = new LocalImpl("localhost", 9999);
        remote.initTCP();
        local.initTCP();

        local.createOnRemote("createOnRemote.txt", "test");
        local.createFile("createOnLocal.txt", "test");

    }
}
