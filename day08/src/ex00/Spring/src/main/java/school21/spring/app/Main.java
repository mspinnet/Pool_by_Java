package school21.spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import school21.spring.classes.*;
import school21.spring.interfaces.*;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        PrinterWithPrefixImpl printer = context.getBean("printerWithPrefix", PrinterWithPrefixImpl.class);
        printer.setPrefix("lol");
        printer.print("Hello!");
    }
}
