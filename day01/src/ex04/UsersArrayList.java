public class UsersArrayList implements UsersList
{
    private int size;
    private int capacity;
    private User[] Array;

    public UsersArrayList()
    {
        size = 0;
        capacity = 10;
        Array = new User[capacity];
    }

    public void addUser(User pers)
    {
        if (size == capacity)
        {
            capacity = capacity * 2;
            User tmp[] = new User[capacity];
            for (int i = 0; i < size; i++)
                tmp[i] = Array[i];
            Array = tmp;
        }
        Array[size] = pers;
        size++;
    }

    public User returnUserById(int id) throws UserNotFoundException
    {
        for (int i = 0; i < size; i++)
        {
            if (Array[i].getIdentifier() == id)
                return Array[i];
        }
        throw new UserNotFoundException();
    }


    public User returnUserByIndex(int index) throws UserNotFoundException
    {
        if (index >= size)
            throw new UserNotFoundException();
        return Array[index];
    }

    public int getNumberUsers()
    {
        return size;
    }
}