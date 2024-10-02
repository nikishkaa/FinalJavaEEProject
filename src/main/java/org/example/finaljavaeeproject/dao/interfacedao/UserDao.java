package org.example.finaljavaeeproject.dao.interfacedao;

import org.example.finaljavaeeproject.entity.User;

public interface UserDao {
    User findByEmail(String email);
}
