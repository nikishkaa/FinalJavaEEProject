package org.example.finaljavaeeproject.dao;

import org.example.finaljavaeeproject.dao.interfacedao.StablesDaoI;
import org.example.finaljavaeeproject.db.AbstractJpaDAO;
import org.example.finaljavaeeproject.entity.Stables;

public class StablesDao extends AbstractJpaDAO<Integer, Stables> implements StablesDaoI {
}
