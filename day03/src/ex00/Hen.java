public class Hen implements Runnable
{
    private int count;

    public Hen(int n)
    {
        count = n;
    }

    public void run()
    {
        for (int i = 0; i < count; i++)
        {
            System.out.println("Hen");
        }
    }
}
