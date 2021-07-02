import java.util.UUID;

public class Transaction {
    private UUID    Identifier;
    private User    Recipient;
    private User    Sender;
    private String  Category;
    private int     Amount;
    public Transaction next;
    public Transaction prev;

    public Transaction(UUID id, User recip, User sender, int amount)
    {
        int tmp;
        next = null;
        prev = null;
        Identifier = id;
        Recipient = recip;
        Sender = sender;
        Amount = amount;
        if (amount < 0)
        {
            Category = Amount + ", OUTCOME";
            tmp = sender.getBalance();
            if (tmp != sender.getBalance() + Amount)
                sender.setBalance(tmp + Amount);
            sender.transactions.addTransaction(this);
        }
        else
        {
            Category = "+" + Amount + ", INCOME";
            tmp = recip.getBalance();
            recip.setBalance(tmp + Amount);
            recip.transactions.addTransaction(this);
        }
    }

    public String setCategory(String str)
    {
        return Category = str;
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

    public int getAmount() {
        return Amount;
    }
}