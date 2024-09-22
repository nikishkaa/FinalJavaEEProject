package org.example.finaljavaeeproject.test;

import org.example.finaljavaeeproject.dao.RoleDao;
import org.example.finaljavaeeproject.dao.UserDao;
import org.example.finaljavaeeproject.entity.User;
import org.example.finaljavaeeproject.util.EncryptDecryptUtils;

public class Test {
    //    Test DB function
    public static void main(String[] args) {
//        createUser();
        activateUser();
    }


    public static void createUser() {
        UserDao userDao = new UserDao();
        RoleDao roleDao = new RoleDao();

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
        UserDao userDao = new UserDao();
        User user = userDao.findByEmail("bob@gmail.com");
        user.setActive(true);

        userDao.update(user);
    }
}
