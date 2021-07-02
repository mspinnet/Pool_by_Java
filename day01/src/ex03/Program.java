import java.util.UUID;

public class Program
{
    public static void main(String[] args) {

        User user1 = new User("Mike", 1000);
        User user2 = new User("John", 1000);
        User user3 = new User("Emma", 600);

        UUID id = UUID.randomUUID();
        int tmp = user2.getBalance();
        Transaction tr2 = null;
        Transaction tr1 = new Transaction(id, user1, user2, -200);
        if (tmp != user2.getBalance()) {
            tr2  = new Transaction(id, user1, user2, 200);
        }
        id = UUID.randomUUID();
        tmp = user3.getBalance();
        Transaction tr4 = null;
        Transaction tr3 = new Transaction(id, user1, user3, -300);
        if (tmp != user3.getBalance()) {
            tr4 = new Transaction(id, user1, user3, 300);
        }
        Transaction[] arr = user1.transactions.transformToArray();
        for (int i = 0; i < user1.transactions.getSize(); i++)
            System.out.println(arr[i].getSender().getName() + " -> " + arr[i].getRecipient().getName()
                    + ", " + arr[i].getCategory() + ", transaction ID: " + arr[i].getIdentifier());
    }
}