package org.example.finaljavaeeproject.dao;

import org.example.finaljavaeeproject.dao.interfacedao.HorseStatusDao;
import org.example.finaljavaeeproject.db.AbstractJpaDAO;
import org.example.finaljavaeeproject.entity.horse.HorseStatus;

public class HorseStatusDaoImpl extends AbstractJpaDAO<Integer, HorseStatus> implements HorseStatusDao {
}
