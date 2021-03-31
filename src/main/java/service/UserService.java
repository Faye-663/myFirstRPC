package service;

import pojo.User;

/**
 * @author faye
 */
public interface UserService {
    User getUserByName(String name);
    boolean addUser(String name,int id);
}
