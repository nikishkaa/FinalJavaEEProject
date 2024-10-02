package org.example.finaljavaeeproject.dao;

import org.example.finaljavaeeproject.dao.interfacedao.HorsesDao;
import org.example.finaljavaeeproject.db.AbstractJpaDAO;
import org.example.finaljavaeeproject.entity.Horses;

public class HorsesDaoImpl extends AbstractJpaDAO<Integer, Horses> implements HorsesDao {
}
