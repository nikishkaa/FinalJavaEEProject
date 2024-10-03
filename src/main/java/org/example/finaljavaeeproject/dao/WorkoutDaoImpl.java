package org.example.finaljavaeeproject.dao;

import org.example.finaljavaeeproject.dao.interfacedao.WorkoutDao;
import org.example.finaljavaeeproject.db.AbstractJpaDAO;
import org.example.finaljavaeeproject.entity.workout.Workout;

public class WorkoutDaoImpl extends AbstractJpaDAO<Integer, Workout> implements WorkoutDao {
}
