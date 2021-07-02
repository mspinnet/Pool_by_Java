import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList
{
    private Transaction head;
    private int size;

    public  TransactionsLinkedList()
    {
        head = null;
        size = 0;
    }

    public void addTransaction(Transaction tr)
    {
        if (head == null)
        {
            head = tr;
        }
        else
        {
            Transaction temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = tr;
            tr.prev = temp;
        }
        size++;
    }

    public void remove(UUID id) throws TransactionNotFoundException
    {
        if (size == 0)
            return;
        if (size == 1)
        {
            if (id.equals(head.getIdentifier()) == true)
                head = null;
            else
                throw new TransactionNotFoundException();
            size--;
            return;
        }
        Transaction tmp = head;
        while (tmp != null)
        {
            if (id.equals(tmp.getIdentifier()) == true)
            {
                if (tmp.next == null)
                {
                    tmp.prev.next = null;
                }
                else if (tmp == head)
                {
                    head = tmp.next;
                    tmp.next.prev = null;
                }
                else
                {
                    tmp.prev.next = tmp.next;
                    tmp.next.prev = tmp.prev;
                }
                size--;
                return;
            }
            tmp = tmp.next;
        }
        throw new TransactionNotFoundException();
    }

    public Transaction[] transformToArray()
    {
        if (size == 0)
            return null;
        Transaction[] arr = new Transaction[size];
        Transaction tmp = head;
        for (int i = 0; i < size; i++)
        {
            arr[i] = tmp;
            tmp = tmp.next;
        }
        return arr;
    }

    public int getSize()
    {
        return size;
    }
}