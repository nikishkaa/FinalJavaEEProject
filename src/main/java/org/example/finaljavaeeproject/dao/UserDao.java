package org.example.finaljavaeeproject.dao;

import org.example.finaljavaeeproject.dao.interfacedao.UserDaoI;
import org.example.finaljavaeeproject.db.AbstractJpaDAO;
import org.example.finaljavaeeproject.entity.User;


public class UserDao extends AbstractJpaDAO<Integer, User> implements UserDaoI {
    @Override
    public User findByEmail(String email) {
        return findFirst(String.format("email = '%s'", email));
    }
}
