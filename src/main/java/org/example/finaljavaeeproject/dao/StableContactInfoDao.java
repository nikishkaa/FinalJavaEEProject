package org.example.finaljavaeeproject.dao;

import org.example.finaljavaeeproject.dao.interfacedao.ContactInfoDaoI;
import org.example.finaljavaeeproject.db.AbstractJpaDAO;
import org.example.finaljavaeeproject.entity.StableContactInfo;

public class StableContactInfoDao extends AbstractJpaDAO<Integer, StableContactInfo> implements ContactInfoDaoI {
}
