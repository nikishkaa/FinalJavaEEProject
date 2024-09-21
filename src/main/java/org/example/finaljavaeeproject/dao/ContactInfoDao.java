package org.example.finaljavaeeproject.dao;

import org.example.finaljavaeeproject.dao.interfacedao.ContactInfoDaoI;
import org.example.finaljavaeeproject.db.AbstractJpaDAO;
import org.example.finaljavaeeproject.entity.ContactInfo;

public class ContactInfoDao extends AbstractJpaDAO<Integer, ContactInfo> implements ContactInfoDaoI {
}
