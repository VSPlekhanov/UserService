package test.system.dao;

import org.springframework.stereotype.Repository;
import test.system.model.User;

import java.util.Arrays;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    public List<User> getAllUsers(){
        return Arrays.asList(new User(1,"admin", "admin"),
                new User(2,"Vasya", "12345"));
    }
}
