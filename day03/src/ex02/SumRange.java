public class SumRange implements Runnable
{
    private int start;
    private int finish;
    private int[] arr;
    private int _id;
    private int sum;
    private Summa summa;

    public SumRange(int first, int last, int[] arr1, int id, Summa obj)
    {
        start = first;
        finish = last;
        arr = arr1;
        _id = id;
        sum = 0;
        summa = obj;
    }

    public void run()
    {
        for (int i = start; i < finish; i++)
        {
            sum += arr[i];
            summa.sumplus(arr[i]);
        }
        finish--;
        System.out.println("Thread " + _id + ": from " + start + " to " + finish + " sum is " + sum);
    }
}
