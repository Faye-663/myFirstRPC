package service;

import pojo.User;

/**
 * @author faye
 */
public class UserServiceImpl implements UserService {
    @Override
    public User getUserByName(String name) {
        System.out.println("client: get user "+name);
        return new User(name);
    }

    @Override
    public boolean addUser(String name, int id) {
        System.out.println("client: add user "+name+","+id);
        return true;
    }
}
