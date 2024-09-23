package org.example.finaljavaeeproject.dao;

import org.example.finaljavaeeproject.dao.interfacedao.HorseStatusDaoI;
import org.example.finaljavaeeproject.db.AbstractJpaDAO;
import org.example.finaljavaeeproject.entity.HorseStatus;

public class HorseStatusDao extends AbstractJpaDAO<Integer, HorseStatus> implements HorseStatusDaoI {
}
