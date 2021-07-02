public class Program {
    public static void main(String[] args) {
        int res = 0;
        int number = 123456;

        res += number % 10;
        number = number / 10;
        res += number % 10;
        number = number / 10;
        res += number % 10;
        number = number / 10;
        res += number % 10;
        number = number / 10;
        res += number % 10;
        number = number / 10;
        res += number % 10;
        number = number / 10;
        System.out.println(res);
    }
}