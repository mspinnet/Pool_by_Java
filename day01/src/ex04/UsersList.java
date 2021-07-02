public interface UsersList
{
    void    addUser(User pers);
    User    returnUserById(int id);
    User    returnUserByIndex(int index);
    int     getNumberUsers();
}