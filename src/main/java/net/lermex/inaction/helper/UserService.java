package net.lermex.inaction.helper;

import net.lermex.inaction.model.entity.User;

import java.util.List;

public interface UserService {

    void addUser(User user);
    List<User> getAll();

    //User addUser(User user);
    //void delete(long id);
    //User getByName(String name);
    //User editUser(User user);

}
