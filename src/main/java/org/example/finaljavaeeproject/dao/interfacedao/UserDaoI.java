package org.example.finaljavaeeproject.dao.interfacedao;

import org.example.finaljavaeeproject.entity.User;

public interface UserDaoI {
    User findByEmail(String email);
}
