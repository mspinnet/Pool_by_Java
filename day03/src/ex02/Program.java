public class Program {
    public static void main(String[] args) {
        int size;
        int thred;
        int sum = 0;
        int start = 0;
        SumRange sumr;
        Summa sumbythreads = new Summa();
        String arrSize = args[0];
        String thr = args[1];
        if (arrSize.regionMatches(0, "--arraySize=", 0, 12) == false ||
                thr.regionMatches(0, "--threadsCount=", 0, 15) == false || args.length != 2)
        {
            System.err.println("Illegal argument");
            System.exit(-1);
        }
        arrSize = arrSize.substring(12);
        thr = thr.substring(15);
        try
        {
            size = Integer.parseInt(arrSize);
            thred = Integer.parseInt(thr);
            if (size < 1 || thred < 1 || size > 2000000 || thred > 2000000)
            {
                System.err.println("Illegal argument");
                System.exit(-1);
            }
            int[] arr = new int[size];
            int range = size / thred;
            int last = range + size % thred;
            for (int i = 0; i < size; i++) {
                arr[i] = (int)(Math.random() * (1000 - 1) + 1);
                sum += arr[i];
            }
            System.out.println("Sum: " + sum);
            for (int i = 1; i < thred; i++)
            {
                sumr = new SumRange(start, (start += range), arr, i, sumbythreads);
                new Thread(sumr).start();
            }
            sumr = new SumRange(start, (start += last), arr, thred, sumbythreads);
            Thread posl = new Thread(sumr);
            posl.start();
            try
            {
                posl.join();
            }
            catch(InterruptedException e){
                System.out.printf("Potok has been interrupted");
                System.exit(1);
            }
            System.out.println("Sum by threads: " + sumbythreads.getSum());
        }
        catch (NumberFormatException nfe)
        {
            System.out.println(nfe.getMessage());
        }
    }
}
