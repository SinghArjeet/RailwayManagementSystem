package com.RailwayManagementSystem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PassengerDAO {

    private final SessionFactory sessionFactory;

    public PassengerDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addPassenger(Passenger passenger) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(passenger);
            transaction.commit();
        }
    }

    public Passenger getPassengerById(Long passengerId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Passenger.class, passengerId);
        }
    }

    public void updatePassenger(Passenger passenger) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(passenger);
            transaction.commit();
        }
    }

    public void deletePassenger(Long passengerId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Passenger passenger = session.get(Passenger.class, passengerId);
            if (passenger != null) {
                session.delete(passenger);
            }
            transaction.commit();
        }
    }
}