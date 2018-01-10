package test.system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.system.dao.UserDao;
import test.system.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
