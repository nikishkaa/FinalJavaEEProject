package org.example.finaljavaeeproject.dao;

import org.example.finaljavaeeproject.dao.interfacedao.HorsesDaoI;
import org.example.finaljavaeeproject.db.AbstractJpaDAO;
import org.example.finaljavaeeproject.entity.Horses;

public class HorsesDao extends AbstractJpaDAO<Integer, Horses> implements HorsesDaoI {
}
