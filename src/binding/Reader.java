package binding;

import exception.FileException;

import java.io.IOException;
import java.io.InputStream;

public interface Reader {
    void readCreateFile(String fileName, InputStream is) throws IOException, FileException;

    void readDeleteFile(String fileName);
}
