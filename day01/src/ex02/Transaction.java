import java.util.UUID;

public class Transaction {
    private UUID    Identifier;
    private User    Recipient;
    private User    Sender;
    private String  Category;
    private int     Amount;

    public Transaction(UUID identifier, User recip, User sender, int amount)
    {
        int tmp;
        Identifier = identifier;
        Recipient = recip;
        Sender = sender;
        Amount = amount;
        if (amount < 0)
        {
            Category = Amount + ", OUTCOME";
            tmp = sender.getBalance();
            if (tmp != sender.getBalance() + Amount)
                sender.setBalance(tmp + Amount);
        }
        else
        {
            Category = "+" + Amount + ", INCOME";
            tmp = recip.getBalance();
            recip.setBalance(tmp + Amount);
        }
    }

    public String getCategory() {
        return Category;
    }

    public User getRecipient()
    {
        return Recipient;
    }

    public User getSender()
    {
        return Sender;
    }

    public UUID getIdentifier()
    {
        return Identifier;
    }
}