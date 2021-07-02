public class User
{
    private int     Identifier;
    private int     Balance;
    private String  Name;
    public TransactionsLinkedList transactions;

    public User(String name, int balance)
    {
        Name = name;
        Identifier = UserIdsGenerator.getInstance().generateId();
        transactions = new TransactionsLinkedList();
        if (balance < 0)
            Balance = 0;
        else
            Balance = balance;
    }

    public int getBalance()
    {
        return Balance;
    }

    public int getIdentifier()
    {
        return Identifier;
    }

    public String getName()
    {
        return Name;
    }

    public void setBalance(int balance)
    {
        if (balance >= 0)
            Balance = balance;
    }
}