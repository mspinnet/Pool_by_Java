public class Egg implements Runnable
{
    private int count;
    private Sinchron sinch;

    public Egg(int n, Sinchron obj)
    {
        count = n;
        sinch = obj;
    }

    public void run()
    {
        for (int i = 0; i < count; i++)
        {
            synchronized (sinch){
                sinch.get();
            }
        }
    }
}
