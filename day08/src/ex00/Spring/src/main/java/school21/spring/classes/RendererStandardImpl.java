package school21.spring.classes;

import school21.spring.interfaces.PreProcessor;
import school21.spring.interfaces.Renderer;

public class RendererStandardImpl implements Renderer {

    private PreProcessor preproc;

    public RendererStandardImpl(PreProcessor obj)
    {
        preproc = obj;
    }

    public void message(String str)
    {
        System.out.println(preproc.changeRegistr(str));
    }
}
