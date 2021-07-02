package edu.school21.numbers;

import edu.school21.numbers.NumberWorker.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberWorkerTest {

    @ParameterizedTest
    @ValueSource(ints = {13, 19, 17})
    public void isPrimeForPrimes(int num)
    {
        NumberWorker test = new NumberWorker();
        Assertions.assertEquals(true, test.isPrime(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {24, 6, 12})
    public void isPrimeForNotPrimes(int num)
    {
        NumberWorker test = new NumberWorker();
        Assertions.assertEquals(false, test.isPrime(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    public  void isPrimeForIncorrectNumbers(int num)
    {
        NumberWorker test = new NumberWorker();
        Assertions.assertThrows(IllegalNumberException.class ,()->  {test.isPrime(num);});
    }

    @ParameterizedTest
    @CsvFileSource (resources = {"/data.csv"}, delimiter = ',')
    public void isSumForDigitsSum(int first, int second)
    {
        NumberWorker test = new NumberWorker();
        Assertions.assertEquals(second, test.digitsSum(first));
    }
}
