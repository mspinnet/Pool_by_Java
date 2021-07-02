public class User
{
    private int     Identifier;
    private int     Balance;
    private String  Name;

    public User(String name, int identifire, int balance)
    {
        Name = name;
        Identifier = identifire;
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