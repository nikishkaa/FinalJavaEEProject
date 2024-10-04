package org.example.finaljavaeeproject.util;

import org.example.finaljavaeeproject.dao.impl.userdaoimpl.RoleDaoImpl;
import org.example.finaljavaeeproject.dao.impl.userdaoimpl.UserDaoImpl;
import org.example.finaljavaeeproject.entity.user.Role;
import org.example.finaljavaeeproject.entity.user.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseBasicDataCreate {
    private static final UserDaoImpl userDao;
    private static final RoleDaoImpl roleDao;

    static {
        userDao = new UserDaoImpl();
        roleDao = new RoleDaoImpl();
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
        String email = "bob@gmail.com";
        if (userDao.findByEmail(email) == null) {
            user.setName("TestBob");
            user.setEmail(email);
            user.setPassword(EncryptDecryptUtils.encrypt("123"));
            user.setActive(false);
            user.setRole(roleDao.findById(3));

            userDao.create(user);

            System.out.println(userDao);
        } else {
            System.out.println("User with such email already exists");
        }
    }

    public static void createRoles() {
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
        System.out.println("Roles Created");
    }
}
