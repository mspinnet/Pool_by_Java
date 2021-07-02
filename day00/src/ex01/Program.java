import java.util.Scanner;

public class Program
{
    public static void main(String[] args) {
        int del = 2;
        int i = 1;
        int sqrtmy = 0;
        int n = 1;

        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.close();
        while (n * n <= num) {
            sqrtmy = n;
            n++;
        }
        if (num <= 1) {
            System.err.println("Illegal Argument");
            System.exit(-1);
        }
        else {
            while (del <= sqrtmy) {
                if (num % del != 0)
                    del++;
                else {
                    System.out.println("false " + i);
                    System.exit(0);
                }
                i++;
            }
            System.out.println("true " + i);
        }
    }
}