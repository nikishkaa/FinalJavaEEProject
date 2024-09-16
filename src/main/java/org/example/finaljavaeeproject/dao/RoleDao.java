package org.example.finaljavaeeproject.dao;

import org.example.finaljavaeeproject.dao.interfacedao.RoleDaoI;
import org.example.finaljavaeeproject.db.AbstractJpaDAO;
import org.example.finaljavaeeproject.entity.Role;

public class RoleDao extends AbstractJpaDAO<Integer, Role> implements RoleDaoI {
}
