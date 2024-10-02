package org.example.finaljavaeeproject.dao;

import org.example.finaljavaeeproject.dao.interfacedao.AddressDao;
import org.example.finaljavaeeproject.db.AbstractJpaDAO;
import org.example.finaljavaeeproject.entity.stable.StableAddress;

public class AddressDaoImpl extends AbstractJpaDAO<Integer, StableAddress> implements AddressDao {
}
