import java.util.UUID;

public class Program
{
    public static void main(String[] args) {

        User user1 = new User("Mike", 1000);
        User user2 = new User("John", 1000);
        User user3 = new User("Emma", 200);
        UsersArrayList arr = new UsersArrayList();
        arr.addUser(user1);
        arr.addUser(user2);
        arr.addUser(user3);
        for (int i = 0; i < arr.getNumberUsers(); i++)
        {
            System.out.print("ID: " + arr.returnUserByIndex(i).getIdentifier());
            System.out.print("  Name: " + arr.returnUserByIndex(i).getName());
            System.out.println("  Balance: " + arr.returnUserByIndex(i).getBalance());
        }
        System.out.println("Return by ID:");
        System.out.print("ID: " + arr.returnUserById(2).getIdentifier());
        System.out.print("  Name: " + arr.returnUserById(2).getName());
        System.out.println("  Balance: " + arr.returnUserById(2).getBalance());
    }
}