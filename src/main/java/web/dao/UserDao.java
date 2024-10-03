package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public void save(User user);

    User findById(long id);

    void delete(long id);
    public void update(User user);
    public List<User> findAll();
}
