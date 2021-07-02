package school21.spring.classes;

import school21.spring.interfaces.PreProcessor;
import school21.spring.interfaces.Renderer;

public class RendererErrImpl implements Renderer {

    private PreProcessor preproc;

    public RendererErrImpl(PreProcessor obj)
    {
        preproc = obj;
    }

    public void message(String str)
    {
        System.err.println(preproc.changeRegistr(str));
    }
}
