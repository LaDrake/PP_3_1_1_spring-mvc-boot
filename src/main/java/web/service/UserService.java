package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public void save(User user);
    public User findById(int id);
    public void delete(int id);
    public void update(User user);
    public List<User> findAll();
}
