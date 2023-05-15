package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void saveUser(User user);

    void updateUser(User user);

    User getUser(Integer id);

    void removeUser(Integer id);
}
