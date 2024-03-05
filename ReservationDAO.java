package com.RailwayManagementSystem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ReservationDAO {

    private final SessionFactory sessionFactory;

    public ReservationDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addReservation(Reservation reservation) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(reservation);
            transaction.commit();
        }
    }

    public Reservation getReservationById(Long reservationId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Reservation.class, reservationId);
        }
    }

    public void updateReservation(Reservation reservation) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(reservation);
            transaction.commit();
        }
    }

    public void deleteReservation(Long reservationId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Reservation reservation = session.get(Reservation.class, reservationId);
            if (reservation != null) {
                session.delete(reservation);
            }
            transaction.commit();
        }
    }
}