import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.Map;

public class DownloadFile extends Thread {

    private String url;
    private int name;
    private Synchron sync;
    private Map<String, String> mapa;

    public DownloadFile(Synchron obj, int name1, Map<String, String> map)
    {
        sync = obj;
        name = name1;
        mapa = map;
    }

    public void run()
    {

        while ((url = sync.take_file()) != null)
        {
            System.out.println("Thread-" + name + " start download file number " + url);
            try (BufferedInputStream in = new BufferedInputStream(new URL(mapa.get(url)).openStream());
                 FileOutputStream fileOutputStream = new FileOutputStream("./src/ex03/" + mapa.get(url).substring(mapa.get(url).length() - 10))) {
                byte dataBuffer[] = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                }
            } catch (IOException e) {
                System.out.println("Except");
                System.exit(1);
            }
            System.out.println("Thread-" + name + " finish download file number " + url);
        }



    }

}
