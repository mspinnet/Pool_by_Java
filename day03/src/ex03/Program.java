import java.util.*;
import java.io.*;
public class Program {
    public static void main(String[] args) {
        int countthreads;
        String arg = args[0];
        if (arg.regionMatches(0, "--threadsCount=", 0, 15) == false || args.length != 1)
        {
            System.err.println("Illegal argument");
            System.exit(-1);
        }
        arg = arg.substring(15);
        try
        {
            countthreads = Integer.parseInt(arg);
            if (countthreads < 1)
            {
                System.err.println("Illegal argument");
                System.exit(-1);
            }
            Synchron sync;
            Makemap make = new Makemap();
            make.parse("./src/ex03/urls.txt");
            Map<String, String> mapa = new HashMap<>();
            mapa = make.get_map();
            sync = new Synchron(mapa.size());
            for (int i = 1; i <= countthreads; i++)
            {
                new Thread(new DownloadFile(sync, i, mapa)).start();
            }
        }
        catch (NumberFormatException nfe)
        {
            System.out.println(nfe.getMessage());
        }
    }
}
