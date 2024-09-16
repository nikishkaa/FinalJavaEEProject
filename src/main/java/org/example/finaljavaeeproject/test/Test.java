package org.example.finaljavaeeproject.test;

import org.example.finaljavaeeproject.dao.RoleDao;
import org.example.finaljavaeeproject.dao.UserDao;
import org.example.finaljavaeeproject.db.JPAService;
import org.example.finaljavaeeproject.db.config.JpaConfiguration;
import org.example.finaljavaeeproject.entity.User;

public class Test {
    public static void main(String[] args) {
        JpaConfiguration configuration = new JpaConfiguration();
        configuration.setUserName("root");
        configuration.setPassword("");
        configuration.setDriver("com.mysql.jdbc.Driver");
        configuration.setUrl("jdbc:mysql://localhost:3308/final_project_db");
        configuration.setPersistentUnit("User");


        JPAService.initialize();
        UserDao userDao = new UserDao();
        RoleDao roleDao = new RoleDao();

        User user = new User();
        user.setName("bob");
        user.setEmail("fffsdffdsds");
        user.setPassword("123");
        user.setActive(false);
        user.setRole(roleDao.findById(3));

        userDao.create(user);
        System.out.println(userDao);

    }
}
