import java.util.Scanner;

public class Program
{
    public static void main(String[] args) {
        String week;
        int n = 1;
        long res = 0;
        long reverse = 0;
        int num_tests = 5;
        int tmp = 0;
        int num;
        int i = 0;
        long j = 9;
        int k = 0;
        boolean value;
        Scanner in = new Scanner(System.in);
        while (n <= 18)
        {
            i = 0;
            j = 9;
            tmp = 0;
            week = in.nextLine();
            if (week.equals("42") == true)
                break;
            value = week.equals("Week " + n);
            if (value == false)
            {
                System.err.println("Illegal Argument");
                in.close();
                System.exit(-1);
            }
            else
            {
                while (in.hasNextInt() && tmp < 5)
                {
                    i = in.nextInt();
                    if (i < 1 || i > 9)
                    {
                        System.err.println("Illegal Argument");
                        in.close();
                        System.exit(-1);
                    }
                    if (j >= i)
                        j = i;
                    tmp++;
                }
                res = res * 10 + j;
                in.nextLine();
            }
            n++;
        }
        n = 1;
        while (res != 0)
        {
            reverse = reverse * 10 + res % 10;
            res = res / 10;
        }
        while (reverse != 0 && n <= 18)
        {
            j = reverse % 10;
            reverse = reverse / 10;
            System.err.print("Week " + n);
            System.err.print(" ");
            while (j > 0)
            {
                System.err.print("=");
                j--;
            }
            System.err.println(">");
            n++;
        }
        in.close();
    }
}