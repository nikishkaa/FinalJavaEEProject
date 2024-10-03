package org.example.finaljavaeeproject.dao;

import org.example.finaljavaeeproject.dao.interfacedao.HorseAnnouncementDao;
import org.example.finaljavaeeproject.db.AbstractJpaDAO;
import org.example.finaljavaeeproject.entity.announcement.HorseAnnouncement;

public class HorseAnnouncementDaoImpl extends AbstractJpaDAO<Integer, HorseAnnouncement> implements HorseAnnouncementDao {
}
