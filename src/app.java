import Local.*;
import Remote.*;

import java.io.IOException;

public class app {
    public static void main(String[] args) throws IOException {
        Remote remote = new RemoteImpl(9999);
        Local local = new LocalImpl("localhost", 9999);
    }
}
