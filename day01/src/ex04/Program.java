import java.util.UUID;

public class Program
{
    public static void main(String[] args) {

        TransactionsService serv = new TransactionsService();
        User user1 = new User("Mike", 1000);
        User user2 = new User("John", 1000);
        User user3 = new User("Emma", 600);
        serv.addUser(user1);
        serv.addUser(user2);
        serv.addUser(user3);
        serv.transfer(user1.getIdentifier(), user2.getIdentifier(), 300);
        serv.transfer(user2.getIdentifier(), user3.getIdentifier(), 400);
        serv.transfer(user3.getIdentifier(), user1.getIdentifier(), 500);
        serv.transfer(user1.getIdentifier(), user3.getIdentifier(), 100);
        serv.transfer(user1.getIdentifier(), user2.getIdentifier(), 100);
        Transaction[] arr_user1 = serv.getUserTransactions(user1.getIdentifier());
        for (int i = 0; i < user1.transactions.getSize(); i++)
            System.out.println(arr_user1[i].getSender().getName() + " -> " + arr_user1[i].getRecipient().getName()
                    + ", " + arr_user1[i].getCategory() + ", transaction ID: " + arr_user1[i].getIdentifier());
        System.out.println();
        Transaction[] arr_user2 = serv.getUserTransactions(user2.getIdentifier());
        for (int i = 0; i < user2.transactions.getSize(); i++)
            System.out.println(arr_user2[i].getSender().getName() + " -> " + arr_user2[i].getRecipient().getName()
                    + ", " + arr_user2[i].getCategory() + ", transaction ID: " + arr_user2[i].getIdentifier());
        System.out.println();
        Transaction[] arr_user3 = serv.getUserTransactions(user3.getIdentifier());
        for (int i = 0; i < user3.transactions.getSize(); i++)
            System.out.println(arr_user3[i].getSender().getName() + " -> " + arr_user3[i].getRecipient().getName()
                    + ", " + arr_user3[i].getCategory() + ", transaction ID: " + arr_user3[i].getIdentifier());
        System.out.println();
        serv.removeTransaction(user1.getIdentifier(), arr_user1[1].getIdentifier());
        serv.removeTransaction(user2.getIdentifier(), arr_user2[1].getIdentifier());
        serv.removeTransaction(user2.getIdentifier(), arr_user2[0].getIdentifier());
        Transaction[] res = serv.checkValidityTransactions();
        for (int i = 0; i < serv.unpaired.getSize(); i++)
            System.out.println(res[i].getSender().getName() + " -> " + res[i].getRecipient().getName()
                    + ", " + res[i].getCategory() + ", transaction ID: " + res[i].getIdentifier());
    }
}