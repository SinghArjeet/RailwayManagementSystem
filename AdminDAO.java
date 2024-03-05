package com.RailwayManagementSystem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AdminDAO {

    private final SessionFactory sessionFactory;

    public AdminDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addAdmin(Admin admin) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(admin);
            transaction.commit();
        }
    }

    public Admin getAdminById(Long adminId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Admin.class, adminId);
        }
    }

    public void updateAdmin(Admin admin) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(admin);
            transaction.commit();
        }
    }

    public void deleteAdmin(Long adminId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Admin admin = session.get(Admin.class, adminId);
            if (admin != null) {
                session.delete(admin);
            }
            transaction.commit();
        }
    }
}