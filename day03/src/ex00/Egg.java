public class Egg implements Runnable
{
    private int count;

    public Egg(int n)
    {
        count = n;
    }

    public void run()
    {
        for (int i = 0; i < count; i++)
            System.out.println("Egg");
    }
}
