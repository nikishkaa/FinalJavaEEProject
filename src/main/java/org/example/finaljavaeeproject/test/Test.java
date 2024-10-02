package org.example.finaljavaeeproject.test;

import org.example.finaljavaeeproject.dao.RoleDaoImpl;
import org.example.finaljavaeeproject.dao.UserDaoImpl;
import org.example.finaljavaeeproject.entity.User;
import org.example.finaljavaeeproject.util.EncryptDecryptUtils;

public class Test {
    //    Test DB function
    public static void main(String[] args) {
//        createUser();
        activateUser();
    }


    public static void createUser() {
        UserDaoImpl userDao = new UserDaoImpl();
        RoleDaoImpl roleDao = new RoleDaoImpl();

        User user = new User();
        user.setName("TestBob1");
        user.setEmail("bob@gmail.com");
        user.setPassword(EncryptDecryptUtils.encrypt("123"));
        user.setActive(false);
        user.setRole(roleDao.findById(3));

        userDao.create(user);

        System.out.println(userDao);
    }

    public static void activateUser() {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.findByEmail("bob@gmail.com");
        user.setActive(true);

        userDao.update(user);
    }
}
