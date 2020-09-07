package accountServer;

public class AccountServerImpl implements AccountServer {
    private int usersLimit;

    public AccountServerImpl(int usersLimit)
    {
        this.usersLimit = usersLimit;
    }
    public int getUsersLimit() {
        return usersLimit;
    }

    public void setUsersLimit(int usersLimit) {
        this.usersLimit = usersLimit;
    }
}
