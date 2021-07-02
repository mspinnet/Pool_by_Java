import java.util.Scanner;

public class Program
{
    public static void main(String[] args) {
        int i = 0;
        int sum = 0;
        int num = 0;
        int sqrtmy = 0;
        int del = 0;
        int tmp = 0;
        int flag = 0;
        Scanner in = new Scanner(System.in);
        while ((num = in.nextInt()) != 42)
        {
            del = 2;
            sqrtmy = 1;
            flag = 0;
            sum = 0;
            tmp = num;
            while (tmp != 0)
            {
                sum += tmp % 10;
                tmp = tmp / 10;
            }
            while (sqrtmy * sqrtmy <= sum)
                sqrtmy++;
            while (del <= sqrtmy)
            {
                if (sum % del != 0)
                    del++;
                else {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0)
                i++;
        }
        in.close();
        System.out.println("Count of coffee-request – " + i);
    }
}