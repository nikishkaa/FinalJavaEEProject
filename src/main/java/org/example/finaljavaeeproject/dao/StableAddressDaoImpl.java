package org.example.finaljavaeeproject.dao;

import org.example.finaljavaeeproject.dao.interfacedao.StableAddressDao;
import org.example.finaljavaeeproject.db.AbstractJpaDAO;
import org.example.finaljavaeeproject.entity.stable.StableAddress;

public class StableAddressDaoImpl extends AbstractJpaDAO<Integer, StableAddress> implements StableAddressDao {
}
