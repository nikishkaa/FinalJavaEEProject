package org.example.finaljavaeeproject.dao;

import org.example.finaljavaeeproject.dao.interfacedao.AddressDaoI;
import org.example.finaljavaeeproject.db.AbstractJpaDAO;
import org.example.finaljavaeeproject.entity.Address;

public class AddressDao extends AbstractJpaDAO<Integer, Address> implements AddressDaoI {
}
