package school21.spring.classes;

import school21.spring.interfaces.Printer;
import school21.spring.interfaces.Renderer;


public class PrinterWithPrefixImpl implements Printer {

    private Renderer rend;
    private String prefix = "";

    public PrinterWithPrefixImpl(Renderer obj)
    {
        rend = obj;
    }

    public void setPrefix(String pref)
    {
        prefix = pref + " ";
    }

    public void print(String str) {

        rend.message(prefix + str);
    }
}
