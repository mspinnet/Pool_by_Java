package school21.spring.classes;

import school21.spring.interfaces.PreProcessor;

public class PreProcessorToUpperImpl implements PreProcessor {

    public String changeRegistr(String str)
    {
        return str.toUpperCase();
    }
}
