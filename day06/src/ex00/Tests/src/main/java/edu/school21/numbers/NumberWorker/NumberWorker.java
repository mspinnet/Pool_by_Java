package edu.school21.numbers.NumberWorker;

public class NumberWorker {

    public boolean isPrime(int number) throws IllegalNumberException
    {
        int del = 2;
        int i = 1;
        int sqrtmy = 0;
        int n = 1;

        while (n * n <= number) {
            sqrtmy = n;
            n++;
        }
        if (number <= 1) {
            throw new IllegalNumberException();
        }
        else {
            while (del <= sqrtmy) {
                if (number % del != 0)
                    del++;
                else {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public int digitsSum(int number)
    {
        int sum = 0;
        while (number != 0)
        {
            sum += number % 10;
            number = number / 10;
        }
        return sum;
    }
}
