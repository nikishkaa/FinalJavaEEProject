package org.example.finaljavaeeproject.dao;

import org.example.finaljavaeeproject.dao.interfacedao.HorsePhotoDao;
import org.example.finaljavaeeproject.db.AbstractJpaDAO;
import org.example.finaljavaeeproject.entity.horse.HorsePhoto;

public class HorsePhotoDaoImpl extends AbstractJpaDAO<Integer, HorsePhoto> implements HorsePhotoDao {
}
