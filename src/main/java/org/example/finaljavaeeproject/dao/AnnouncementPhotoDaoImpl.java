package org.example.finaljavaeeproject.dao;

import org.example.finaljavaeeproject.dao.interfacedao.AnnouncementPhotoDao;
import org.example.finaljavaeeproject.db.AbstractJpaDAO;
import org.example.finaljavaeeproject.entity.announcement.AnnouncementPhoto;

public class AnnouncementPhotoDaoImpl extends AbstractJpaDAO<Integer, AnnouncementPhoto> implements AnnouncementPhotoDao {
}
