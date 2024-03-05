package com.RailwayManagementSystem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class StationDAO {
    private SessionFactory sessionFactory;

    public StationDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addStation(Station station) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(station);
            transaction.commit();
        }
    }

    public Station getStationById(Long stationId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Station.class, stationId);
        }
    }

    public List<Station> getAllStations() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Station", Station.class).list();
        }
    }

    public void updateStation(Station station) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(station);
            transaction.commit();
        }
    }

    public void deleteStation(Long stationId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Station station = session.get(Station.class, stationId);
            if (station != null) {
                session.delete(station);
            }
            transaction.commit();
        }
    }
}