package com.RailwayManagementSystem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TicketDAO {

    private final SessionFactory sessionFactory;

    public TicketDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addTicket(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
        }
    }

    public Ticket getTicketById(Long ticketId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Ticket.class, ticketId);
        }
    }

    public void updateTicket(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(ticket);
            transaction.commit();
        }
    }

    public void deleteTicket(Long ticketId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, ticketId);
            if (ticket != null) {
                session.delete(ticket);
            }
            transaction.commit();
        }
    }
}