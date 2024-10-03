package org.example.finaljavaeeproject.dao;

import org.example.finaljavaeeproject.dao.interfacedao.WorkoutTypeDao;
import org.example.finaljavaeeproject.db.AbstractJpaDAO;
import org.example.finaljavaeeproject.entity.workout.WorkoutType;

public class WorkoutTypeDaoImpl extends AbstractJpaDAO<Integer, WorkoutType> implements WorkoutTypeDao {
}
