package dao.inter;

import entity.User;
import java.util.List;

public interface UserDaoInter {

    public User findByUsernameAndPassword(String username, String password);

    public List<User> getUsers();

    public User getUserById(int id);

    public boolean updateUser(User u);

    public boolean insertUser(User u);

    public boolean removeUser(int id);
}
