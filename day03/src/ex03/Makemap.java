import java.util.*;
import java.io.*;

public class Makemap {

    private Map<String, String> mapa;

    public Makemap()
    {
        mapa = new HashMap<>();
    }

    public void parse(String path)
    {
        try (FileInputStream fin = new FileInputStream(path)) {
            byte[] buffer = new byte[fin.available()];

            fin.read(buffer, 0, fin.available());
            String s = new String(buffer);
            String [] strings = s.split("\\n");
            String [] keys;

            for (int i = 0; i < strings.length; i++)
            {
                keys = strings[i].split(" ");
                mapa.put(keys[0], keys[1]);
            }

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public Map<String, String> get_map()
    {
        return (mapa);
    }

}
