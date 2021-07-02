import java.util.*;
import java.io.*;
public class Synchron {
    private int count;
    private int iter;
    private String tmp = null;

    public Synchron(int countfiles)
    {
        count = countfiles;
        iter = 1;
    }

    public synchronized String take_file()
    {

        if (iter <= count)
        {
            tmp = Integer.toString(iter);
            iter++;
            return (tmp);
        }
        return (null);
    }
}
