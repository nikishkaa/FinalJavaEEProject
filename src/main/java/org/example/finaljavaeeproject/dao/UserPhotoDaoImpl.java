package org.example.finaljavaeeproject.dao;

import org.example.finaljavaeeproject.dao.interfacedao.UserPhotoDao;
import org.example.finaljavaeeproject.db.AbstractJpaDAO;
import org.example.finaljavaeeproject.entity.user.UserPhoto;

public class UserPhotoDaoImpl extends AbstractJpaDAO<Integer, UserPhoto> implements UserPhotoDao {
}
