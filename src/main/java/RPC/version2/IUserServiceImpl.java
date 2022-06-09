package RPC.version2;

import RPC.common.IUserService;
import RPC.common.User;

public class IUserServiceImpl
        implements IUserService
{
    @Override
    public User findUserById(Integer id)
    {
        return new User(id, "alice");
    }
}
