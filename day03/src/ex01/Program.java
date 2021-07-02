public class Program {
    public static void main(String[] args) {
        int count;
        String arg = args[0];
        if (arg.regionMatches(0, "--count=", 0, 8) == false || args.length != 1)
        {
            System.err.println("Illegal argument");
            System.exit(-1);
        }
        arg = arg.substring(8);
        try
        {
            count = Integer.parseInt(arg);
            if (count < 1)
            {
                System.err.println("Illegal argument");
                System.exit(-1);
            }
            Sinchron sinch = new Sinchron();
            Hen hen = new Hen(count, sinch);
            Egg egg = new Egg(count, sinch);
            Thread thread_hen = new Thread(hen);
            Thread thread_egg = new Thread(egg);
            thread_egg.start();
            thread_hen.start();
        }
        catch (NumberFormatException nfe)
        {
            System.out.println(nfe.getMessage());
        }
    }
}
