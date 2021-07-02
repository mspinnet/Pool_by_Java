import java.util.UUID;

public class TransactionsService
{
    private UsersArrayList users;
    public TransactionsLinkedList unpaired;

    public TransactionsService()
    {
        users = new UsersArrayList();
        unpaired = new TransactionsLinkedList();
    }

    public void addUser(User obj)
    {
        users.addUser(obj);
    }

    public int getBalanceUserById(int id)
    {
        return users.returnUserById(id).getBalance();
    }

    public int getBalanceUserByIndex(int index)
    {
        return users.returnUserByIndex(index).getBalance();
    }

    public void transfer(int id_rec, int id_send, int amount) throws IllegalTransactionException
    {
        User rec = users.returnUserById(id_rec);
        User send = users.returnUserById(id_send);
        UUID id = UUID.randomUUID();
        if (amount >= 0 && getBalanceUserById(id_send) - amount >= 0)
        {
            Transaction tr1 = new Transaction(id, users.returnUserById(id_rec), users.returnUserById(id_send), -amount);
            Transaction tr2 = new Transaction(id, users.returnUserById(id_rec), users.returnUserById(id_send), amount);
            return;
        }
        else
            throw new IllegalTransactionException();
    }

    public Transaction[] getUserTransactions(int id)
    {
        return users.returnUserById(id).transactions.transformToArray();
    }

    private int other_user(int id_user, UUID id_tran)
    {
        int id = 0;
        Transaction[] tmp = users.returnUserById(id_user).transactions.transformToArray();
        for (int i = 0; i < users.returnUserById(id_user).transactions.getSize(); i++)
        {
            if (tmp[i].getIdentifier().equals(id_tran) == true)
            {
                if (tmp[i].getSender().getIdentifier() == id_user)
                {
                    id = tmp[i].getRecipient().getIdentifier();
                    break;
                }
                else if (tmp[i].getRecipient().getIdentifier() == id_user)
                {
                    id = tmp[i].getSender().getIdentifier();
                    break;
                }
            }
        }
        return id;
    }

    public void removeTransaction(int id_user, UUID id_tran)
    {
        int flag = 0;
        Transaction[] tmp = unpaired.transformToArray();
        if (unpaired.getSize() != 0)
        {
            for (int i = 0; i < unpaired.getSize(); i++)
            {
                if (tmp[i].getIdentifier().equals(id_tran) == true)
                {
                    unpaired.remove(id_tran);
                    flag = 1;
                }
            }
        }
        if (flag == 0)
        {
            int other = other_user(id_user, id_tran);
            Transaction[] tmp1 = users.returnUserById(other).transactions.transformToArray();
            for (int i = 0; i < users.returnUserById(other).transactions.getSize(); i++)
            {
                if (tmp1[i].getIdentifier().equals(id_tran) == true)
                {
                    Transaction qwer = new Transaction(tmp1[i].getIdentifier(), tmp1[i].getRecipient(), tmp1[i].getSender(), tmp1[i].getAmount());
                    unpaired.addTransaction(qwer);
                    users.returnUserById(id_user).transactions.remove(id_tran);
                    return;
                }
            }
        }
    }

    public Transaction[] checkValidityTransactions()
    {
        return unpaired.transformToArray();
    }
}