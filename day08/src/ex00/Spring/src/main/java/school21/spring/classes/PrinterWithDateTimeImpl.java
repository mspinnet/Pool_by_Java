package school21.spring.classes;

import school21.spring.interfaces.Printer;
import school21.spring.interfaces.Renderer;

import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer {

    private Renderer rend;

    public PrinterWithDateTimeImpl(Renderer obj)
    {
        rend = obj;
    }

    public void print(String str) {

        rend.message(str + " " + LocalDateTime.now());
    }
}
