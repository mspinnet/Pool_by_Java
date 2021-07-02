public class UserIdsGenerator
{
    private int Id;
    private static UserIdsGenerator Instance;

    private UserIdsGenerator()
    {
        Id = 0;
    }

    public static UserIdsGenerator getInstance()
    {
        if (Instance == null)
            Instance = new UserIdsGenerator();
        return Instance;
    }

    public int generateId()
    {
        Id++;
        return Id;
    }
}