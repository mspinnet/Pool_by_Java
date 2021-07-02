import java.util.UUID;

public interface TransactionsList
{
    void addTransaction(Transaction tr);
    void remove(UUID id);
    Transaction[] transformToArray();
}