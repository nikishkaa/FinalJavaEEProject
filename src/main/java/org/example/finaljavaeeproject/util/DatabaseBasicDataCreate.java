package org.example.finaljavaeeproject.util;

import org.example.finaljavaeeproject.dao.RoleDao;
import org.example.finaljavaeeproject.dao.UserDao;
import org.example.finaljavaeeproject.entity.Role;
import org.example.finaljavaeeproject.entity.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseBasicDataCreate {
    private static UserDao userDao;
    private static RoleDao roleDao;

    static {
        userDao = new UserDao();
        roleDao = new RoleDao();
    }

    public static void main(String[] args) {
        createData();
        System.out.println("Data Created");

        //TODO Заменить логи
    }

    public static void createData() {
        createRoles();
        createUsers();
    }

    public static void createUsers() {
        User user = new User();
        user.setName("bob");
        user.setEmail("bob@gmail.com");
        user.setPassword(EncryptDecryptUtils.encrypt("123"));
        user.setActive(false);
        user.setRole(roleDao.findById(3));

        userDao.create(user);

        System.out.println(userDao);
    }

    public static void createRoles() {
    //Create default Roles
        Role adminRole = new Role();
        adminRole.setName("ADMIN");

        Role managerRole = new Role();
        managerRole.setName("MANAGER");

        Role basicUserRole = new Role();
        basicUserRole.setName("BASIC_USER");

        List<Role> roles = new ArrayList<>();
        roles.add(adminRole);
        roles.add(managerRole);
        roles.add(basicUserRole);

        roleDao.createAll(roles);
    }
}
