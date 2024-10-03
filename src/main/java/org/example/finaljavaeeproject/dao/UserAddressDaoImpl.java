package org.example.finaljavaeeproject.dao;

import org.example.finaljavaeeproject.dao.interfacedao.UserAddressDao;
import org.example.finaljavaeeproject.db.AbstractJpaDAO;
import org.example.finaljavaeeproject.entity.user.UserAddress;

public class UserAddressDaoImpl extends AbstractJpaDAO<Integer, UserAddress> implements UserAddressDao {
}
