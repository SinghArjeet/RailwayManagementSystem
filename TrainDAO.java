package com.RailwayManagementSystem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TrainDAO {
    private SessionFactory sessionFactory;

    // Constructor
    public TrainDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Method to get a Train entity by ID
    public Train getTrainById(Long trainId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Train.class, trainId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Other CRUD operations

    public void addTrain(Train train) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(train);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTrain(Train train) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(train);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTrain(Long trainId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Train train = session.get(Train.class, trainId);
            if (train != null) {
                session.delete(train);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public String getTrainId1() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTrainId() {
		// TODO Auto-generated method stub
		return null;
	}
}