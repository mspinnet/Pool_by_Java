import java.util.UUID;

public class Program
{
    public static void main(String[] args) {

        User user1 = new User("Mike", 1000);
        System.out.print("ID: " + user1.getIdentifier());
        System.out.print("  Name: " + user1.getName());
        System.out.println("  Balance: " + user1.getBalance());
        User user2 = new User("John", 1000);
        System.out.print("ID: " + user2.getIdentifier());
        System.out.print("  Name: " + user2.getName());
        System.out.println("  Balance: " + user2.getBalance());
        User user3 = new User("Emma", 200);
        System.out.print("ID: " + user3.getIdentifier());
        System.out.print("  Name: " + user3.getName());
        System.out.println("  Balance: " + user3.getBalance());
    }
}