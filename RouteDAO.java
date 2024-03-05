package com.RailwayManagementSystem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class RouteDAO {

    private final SessionFactory sessionFactory;

    public RouteDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addRoute(Route route) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(route);
            transaction.commit();
        }
    }

    public Route getRouteById(Long routeId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Route.class, routeId);
        }
    }

    public void updateRoute(Route route) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(route);
            transaction.commit();
        }
    }

    public void deleteRoute(Long routeId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Route route = session.get(Route.class, routeId);
            if (route != null) {
                session.delete(route);
            }
            transaction.commit();
        }
    }
}