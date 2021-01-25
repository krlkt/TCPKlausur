package remoteTest;

import Remote.*;
import exception.FileException;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RemoteTest {
    @Test
    public void createAndCopyFile() throws IOException, FileException {
        String mockText = "this is a mock text";
        byte[] b = mockText.getBytes();
        InputStream is = new ByteArrayInputStream(b);

        Remote remote = new RemoteImpl();
        //remote.copyAndCreateFile("testCopyAndCreateFile.txt", is);

    }

    @Test(expected = FileException.class)
    public void alreadyExistTest() throws IOException, FileException {
        String mockText = "this is a mock text";
        byte[] b = mockText.getBytes();
        InputStream is = new ByteArrayInputStream(b);

        Remote remote = new RemoteImpl();
        remote.copyAndCreateFile("alreadyExists.txt", is);

    }

    @Test
    public void erase() throws IOException, FileException {
        String mockText = "this is a mock text";
        byte[] b = mockText.getBytes();
        InputStream is = new ByteArrayInputStream(b);

        Remote remote = new RemoteImpl();
        //remote.copyAndCreateFile("eraseThisFile.txt", is);
        Boolean erased = remote.erase("eraseThisFile.txt");
        //Assert.assertTrue(erased);
        Assert.assertFalse(erased);

    }
}

