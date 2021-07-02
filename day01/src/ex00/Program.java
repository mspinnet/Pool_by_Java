import java.util.UUID;

public class Program
{
    public static void main(String[] args) {

        User user1 = new User("Mike", 1, 1000);
        System.out.print("ID: " + user1.getIdentifier());
        System.out.print("  Name: " + user1.getName());
        System.out.println("  Balance: " + user1.getBalance());
        User user2 = new User("John", 2, 1000);
        System.out.print("ID: " + user2.getIdentifier());
        System.out.print("  Name: " + user2.getName());
        System.out.println("  Balance: " + user2.getBalance());

        System.out.println("Transaction: ");
        UUID id = UUID.randomUUID();
        int tmp = user2.getBalance();
        Transaction tr1 = new Transaction(id, user1, user2, -200);
        if (tmp != user2.getBalance()) {
            Transaction tr2 = new Transaction(id, user1, user2, 200);
            System.out.println(tr1.getSender().getName() + " -> " + tr1.getRecipient().getName()
                    + ", " + tr1.getCategory() + ", transaction ID: " + tr1.getIdentifier());
            System.out.println(tr2.getRecipient().getName() + " -> " + tr2.getSender().getName()
                    + ", " + tr2.getCategory() + ", transaction ID: " + tr2.getIdentifier());
        }
        System.out.println("After Transaction!");
        System.out.print("ID: " + user1.getIdentifier());
        System.out.print("  Name: " + user1.getName());
        System.out.println("  Balance: " + user1.getBalance());
        System.out.print("ID: " + user2.getIdentifier());
        System.out.print("  Name: " + user2.getName());
        System.out.println("  Balance: " + user2.getBalance());
    }
}