public class TransactionNotFoundException extends RuntimeException
{
    public TransactionNotFoundException()
    {
        super("Transaction ID not found");
    }
}