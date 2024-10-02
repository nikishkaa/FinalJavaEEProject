package org.example.finaljavaeeproject.dao;

import org.example.finaljavaeeproject.dao.interfacedao.UserDao;
import org.example.finaljavaeeproject.db.AbstractJpaDAO;
import org.example.finaljavaeeproject.entity.user.User;


public class UserDaoImpl extends AbstractJpaDAO<Integer, User> implements UserDao {
    @Override
    public User findByEmail(String email) {
        return findFirst(String.format("email = '%s'", email));
    }
}
