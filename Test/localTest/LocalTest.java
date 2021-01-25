package localTest;

import Local.Local;
import Local.LocalImpl;
import Remote.Remote;
import exception.FileException;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LocalTest {

//    @Test
//    public void createLocalFile() throws IOException, FileException {
//            Local local = new LocalImpl();
//            local.createFile("testLocalFile.txt", "mock text");
//    }

    @Test(expected = FileException.class)
    public void fileExists() throws IOException, FileException {
        Local local = new LocalImpl();
        local.createFile("testLocalFile.txt", "mock text");
    }
}
