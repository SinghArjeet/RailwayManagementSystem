package com.RailwayManagementSystem;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;

public class MainApplication {

    private static final Scanner scanner = new Scanner(System.in);
    private static final SessionFactory sessionFactory1 = HibernateUtil.getSessionFactory();
    //private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        try {
            while (true) {
                System.out.println("==== Main Menu ====");
                System.out.println("1. Manage Routes");
                System.out.println("2. Manage Passengers");
                System.out.println("3. Manage Reservations");
                System.out.println("4. Manage Tickets");
                System.out.println("5. Manage Users");
                System.out.println("6. Manage Admins");
                System.out.println("7. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        manageRoutes();
                        break;
                    case 2:
                        managePassengers();
                        break;
                    case 3:
                        manageReservations();
                        break;
                    case 4:
                        manageTickets();
                        break;
                    case 5:
                        manageUsers();
                        break;
                    case 6:
                        manageAdmins();
                        break;
                    case 7:
                        System.out.println("Exiting program...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } finally {
            sessionFactory1.close();
            scanner.close();
        }
    }
    
    private static void manageRoutes() {
        RouteDAO routeDAO = new RouteDAO(sessionFactory1);

        while (true) {
            System.out.println("==== Route Menu ====");
            System.out.println("1. Add Route");
            System.out.println("2. View Route");
            System.out.println("3. Update Route");
            System.out.println("4. Delete Route");
            System.out.println("5. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addRoute(routeDAO);
                    break;
                case 2:
                    viewRoute(routeDAO);
                    break;
                case 3:
                    updateRoute(routeDAO);
                    break;
                case 4:
                    deleteRoute(routeDAO);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addRoute(RouteDAO routeDAO) {
        System.out.println("==== Add Route ====");
        Route route = new Route();

        System.out.print("Enter Train ID: ");
        Long trainId = scanner.nextLong();
        // Assuming you have a method to get Train entity by ID from the database
        Train train= gettrainId(trainId); 
        route.setTrain(train);

        // Collect other route attributes like source station, destination station, distance, and travel time

        routeDAO.addRoute(route);
        System.out.println("Route added successfully!");
    }

    private static Train gettrainId(Long trainId) {
		// TODO Auto-generated method stub
		return null;
	}

	private static void viewRoute(RouteDAO routeDAO) {
        System.out.println("==== View Route ====");
        System.out.print("Enter Route ID: ");
        Long routeId = scanner.nextLong();
        Route route = routeDAO.getRouteById(routeId);

        if (route != null) {
            // Display route details
            System.out.println("Route ID: " + route.getRouteId());
            System.out.println("Train ID: " + route.getTrain().getTrainId());
            // Display other route attributes
        } else {
            System.out.println("Route not found!");
        }
    }

    private static void updateRoute(RouteDAO routeDAO) {
        System.out.println("==== Update Route ====");
        System.out.print("Enter Route ID: ");
        Long routeId = scanner.nextLong();
        Route route = routeDAO.getRouteById(routeId);

        if (route != null) {
            // Prompt user for updated route attributes
            // Update the route object accordingly
            routeDAO.updateRoute(route);
            System.out.println("Route updated successfully!");
        } else {
            System.out.println("Route not found!");
        }
    }

    private static void deleteRoute(RouteDAO routeDAO) {
        System.out.println("==== Delete Route ====");
        System.out.print("Enter Route ID: ");
        Long routeId = scanner.nextLong();
        Route route = routeDAO.getRouteById(routeId);

        if (route != null) {
            routeDAO.deleteRoute(routeId);
            System.out.println("Route deleted successfully!");
        } else {
            System.out.println("Route not found!");
        }
    }
    
    private static void managePassengers() {
        PassengerDAO passengerDAO = new PassengerDAO(sessionFactory1);

        while (true) {
            System.out.println("==== Passenger Menu ====");
            System.out.println("1. Add Passenger");
            System.out.println("2. View Passenger");
            System.out.println("3. Update Passenger");
            System.out.println("4. Delete Passenger");
            System.out.println("5. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addPassenger(passengerDAO);
                    break;
                case 2:
                    viewPassenger(passengerDAO);
                    break;
                case 3:
                    updatePassenger(passengerDAO);
                    break;
                case 4:
                    deletePassenger(passengerDAO);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addPassenger(PassengerDAO passengerDAO) {
        System.out.println("==== Add Passenger ====");
        Passenger passenger = new Passenger();

        // Collect passenger attributes like first name, last name, age, gender, and contact number
        System.out.print("Enter First Name: ");
        passenger.setFirstName(scanner.next());

        // Collect other passenger attributes

        passengerDAO.addPassenger(passenger);
        System.out.println("Passenger added successfully!");
    }

    private static void viewPassenger(PassengerDAO passengerDAO) {
        System.out.println("==== View Passenger ====");
        System.out.print("Enter Passenger ID: ");
        Long passengerId = scanner.nextLong();
        Passenger passenger = passengerDAO.getPassengerById(passengerId);

        if (passenger != null) {
            // Display passenger details
            System.out.println("Passenger ID: " + passenger.getPassengerId());
            System.out.println("First Name: " + passenger.getFirstName());
            // Display other passenger attributes
        } else {
            System.out.println("Passenger not found!");
        }
    }

    private static void updatePassenger(PassengerDAO passengerDAO) {
        System.out.println("==== Update Passenger ====");
        System.out.print("Enter Passenger ID: ");
        Long passengerId = scanner.nextLong();
        Passenger passenger = passengerDAO.getPassengerById(passengerId);

        if (passenger != null) {
            // Prompt user for updated passenger attributes
            // Update the passenger object accordingly
            passengerDAO.updatePassenger(passenger);
            System.out.println("Passenger updated successfully!");
        } else {
            System.out.println("Passenger not found!");
        }
    }

    private static void deletePassenger(PassengerDAO passengerDAO) {
        System.out.println("==== Delete Passenger ====");
        System.out.print("Enter Passenger ID: ");
        Long passengerId = scanner.nextLong();
        Passenger passenger = passengerDAO.getPassengerById(passengerId);

        if (passenger != null) {
            passengerDAO.deletePassenger(passengerId);
            System.out.println("Passenger deleted successfully!");
        } else {
            System.out.println("Passenger not found!");
        }
    }
    
    private static void manageReservations() {
        ReservationDAO reservationDAO = new ReservationDAO(sessionFactory1);

        while (true) {
            System.out.println("==== Reservation Menu ====");
            System.out.println("1. Add Reservation");
            System.out.println("2. View Reservation");
            System.out.println("3. Update Reservation");
            System.out.println("4. Delete Reservation");
            System.out.println("5. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addReservation(reservationDAO);
                    break;
                case 2:
                    viewReservation(reservationDAO);
                    break;
                case 3:
                    updateReservation(reservationDAO);
                    break;
                case 4:
                    deleteReservation(reservationDAO);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addReservation(ReservationDAO reservationDAO) {
        System.out.println("==== Add Reservation ====");
        Reservation reservation = new Reservation();

        // Collect reservation attributes like train, route, passenger, seat number, reservation date, and status
        System.out.print("Enter Train ID: ");
        Long trainId = scanner.nextLong();
        // Assuming you have a method to get Train entity by ID from the database
        Train train = gettrainId(trainId);
        reservation.setTrain(train);

        // Collect other reservation attributes

        reservationDAO.addReservation(reservation);
        System.out.println("Reservation added successfully!");
    }

    private static void viewReservation(ReservationDAO reservationDAO) {
        System.out.println("==== View Reservation ====");
        System.out.print("Enter Reservation ID: ");
        Long reservationId = scanner.nextLong();
        Reservation reservation = reservationDAO.getReservationById(reservationId);

        if (reservation != null) {
            // Display reservation details
            System.out.println("Reservation ID: " + reservation.getReservationId());
            System.out.println("Train ID: " + reservation.getTrain().getTrainId());
            // Display other reservation attributes
        } else {
            System.out.println("Reservation not found!");
        }
    }

    private static void updateReservation(ReservationDAO reservationDAO) {
        System.out.println("==== Update Reservation ====");
        System.out.print("Enter Reservation ID: ");
        Long reservationId = scanner.nextLong();
        Reservation reservation = reservationDAO.getReservationById(reservationId);

        if (reservation != null) {
            // Prompt user for updated reservation attributes
            // Update the reservation object accordingly
            reservationDAO.updateReservation(reservation);
            System.out.println("Reservation updated successfully!");
        } else {
            System.out.println("Reservation not found!");
        }
    }

    private static void deleteReservation(ReservationDAO reservationDAO) {
        System.out.println("==== Delete Reservation ====");
        System.out.print("Enter Reservation ID: ");
        Long reservationId = scanner.nextLong();
        Reservation reservation = reservationDAO.getReservationById(reservationId);

        if (reservation != null) {
            reservationDAO.deleteReservation(reservationId);
            System.out.println("Reservation deleted successfully!");
        } else {
            System.out.println("Reservation not found!");
        }
    }
    
    private static void manageTickets() {
        TicketDAO ticketDAO = new TicketDAO(sessionFactory1);

        while (true) {
            System.out.println("==== Ticket Menu ====");
            System.out.println("1. Add Ticket");
            System.out.println("2. View Ticket");
            System.out.println("3. Update Ticket");
            System.out.println("4. Delete Ticket");
            System.out.println("5. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTicket(ticketDAO);
                    break;
                case 2:
                    viewTicket(ticketDAO);
                    break;
                case 3:
                    updateTicket(ticketDAO);
                    break;
                case 4:
                    deleteTicket(ticketDAO);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addTicket(TicketDAO ticketDAO) {
        System.out.println("==== Add Ticket ====");
        Ticket ticket = new Ticket();

        // Collect ticket attributes like reservation, ticket number, issue date, and fare
        System.out.print("Enter Reservation ID: ");
        Long reservationId = scanner.nextLong();
        // Assuming you have a method to get Reservation entity by ID from the database
        Reservation reservation = getReservationById(reservationId);
        ticket.setReservation(reservation);

        // Collect other ticket attributes

        ticketDAO.addTicket(ticket);
        System.out.println("Ticket added successfully!");
    }

    private static void updateTicket(TicketDAO ticketDAO) {
        System.out.println("==== Update Ticket ====");
        System.out.print("Enter Ticket ID: ");
        Long ticketId = scanner.nextLong();
        Ticket ticket = ticketDAO.getTicketById(ticketId);

        if (ticket != null) {
            // Prompt user for updated ticket attributes
            // Update the ticket object accordingly
            // Example: Assuming you want to update the fare
            System.out.print("Enter new Fare: ");
            double newFare = scanner.nextDouble();
            ticket.setFare(newFare);

            ticketDAO.updateTicket(ticket);
            System.out.println("Ticket updated successfully!");
        } else {
            System.out.println("Ticket not found!");
        }
    }

    private static void deleteTicket(TicketDAO ticketDAO) {
        System.out.println("==== Delete Ticket ====");
        System.out.print("Enter Ticket ID: ");
        Long ticketId = scanner.nextLong();
        Ticket ticket = ticketDAO.getTicketById(ticketId);

        if (ticket != null) {
            ticketDAO.deleteTicket(ticketId);
            System.out.println("Ticket deleted successfully!");
        } else {
            System.out.println("Ticket not found!");
        }
    }
    
    private static Reservation getReservationById(Long reservationId) {
		// TODO Auto-generated method stub
		return null;
	}

	private static void viewTicket(TicketDAO ticketDAO) {
        System.out.println("==== View Ticket ====");
        System.out.print("Enter Ticket ID: ");
        Long ticketId = scanner.nextLong();
        Ticket ticket = ticketDAO.getTicketById(ticketId);

        if (ticket != null) {
            // Display ticket details
            System.out.println("Ticket ID: " + ticket.getTicketId());
            System.out.println("Reservation ID: " + ticket.getReservation().getReservationId());
            // Display other ticket attributes
        } else {
            System.out.println("Ticket not found!");
        }
    }
    
    private static void manageUsers() {
        UserDAO userDAO = new UserDAO(sessionFactory1);

        while (true) {
            System.out.println("==== User Menu ====");
            System.out.println("1. Add User");
            System.out.println("2. View User");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addUser(userDAO);
                    break;
                case 2:
                    viewUser(userDAO);
                    break;
                case 3:
                    updateUser(userDAO);
                    break;
                case 4:
                    deleteUser(userDAO);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addUser(UserDAO userDAO) {
        System.out.println("==== Add User ====");
        User user = new User();

        // Collect user attributes like username, password, first name, last name, email, and contact number
        System.out.print("Enter Username: ");
        user.setUsername(scanner.next());

        // Collect other user attributes

        userDAO.addUser(user);
        System.out.println("User added successfully!");
    }

    private static void viewUser(UserDAO userDAO) {
        System.out.println("==== View User ====");
        System.out.print("Enter User ID: ");
        Long userId = scanner.nextLong();
        User user = userDAO.getUserById(userId);

        if (user != null) {
            // Display user details
            System.out.println("User ID: " + user.getUserId());
            System.out.println("Username: " + user.getUsername());
            // Display other user attributes
        } else {
            System.out.println("User not found!");
        }
    }

    private static void updateUser(UserDAO userDAO) {
        System.out.println("==== Update User ====");
        System.out.print("Enter User ID: ");
        Long userId = scanner.nextLong();
        User user = userDAO.getUserById(userId);

        if (user != null) {
            // Prompt user for updated user attributes
            // Update the user object accordingly
            userDAO.updateUser(user);
            System.out.println("User updated successfully!");
        } else {
            System.out.println("User not found!");
        }
    }

    private static void deleteUser(UserDAO userDAO) {
        System.out.println("==== Delete User ====");
        System.out.print("Enter User ID: ");
        Long userId = scanner.nextLong();
        User user = userDAO.getUserById(userId);

        if (user != null) {
            userDAO.deleteUser(userId);
            System.out.println("User deleted successfully!");
        } else {
            System.out.println("User not found!");
        }
    }
    
    private static void manageAdmins() {
        AdminDAO adminDAO = new AdminDAO(sessionFactory1);

        while (true) {
            System.out.println("==== Admin Menu ====");
            System.out.println("1. Add Admin");
            System.out.println("2. View Admin");
            System.out.println("3. Update Admin");
            System.out.println("4. Delete Admin");
            System.out.println("5. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addAdmin(adminDAO);
                    break;
                case 2:
                    viewAdmin(adminDAO);
                    break;
                case 3:
                    updateAdmin(adminDAO);
                    break;
                case 4:
                    deleteAdmin(adminDAO);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addAdmin(AdminDAO adminDAO) {
        System.out.println("==== Add Admin ====");
        Admin admin = new Admin();

        // Collect admin attributes like username, password, first name, last name, email, and contact number
        System.out.print("Enter Username: ");
        admin.setUsername(scanner.next());

        // Collect other admin attributes

        adminDAO.addAdmin(admin);
        System.out.println("Admin added successfully!");
    }

    private static void viewAdmin(AdminDAO adminDAO) {
        System.out.println("==== View Admin ====");
        System.out.print("Enter Admin ID: ");
        Long adminId = scanner.nextLong();
        Admin admin = adminDAO.getAdminById(adminId);

        if (admin != null) {
            // Display admin details
            System.out.println("Admin ID: " + admin.getAdminId());
            System.out.println("Username: " + admin.getUsername());
            // Display other admin attributes
        } else {
            System.out.println("Admin not found!");
        }
    }

    private static void updateAdmin(AdminDAO adminDAO) {
        System.out.println("==== Update Admin ====");
        System.out.print("Enter Admin ID: ");
        Long adminId = scanner.nextLong();
        Admin admin = adminDAO.getAdminById(adminId);

        if (admin != null) {
            // Prompt user for updated admin attributes
            // Update the admin object accordingly
            adminDAO.updateAdmin(admin);
            System.out.println("Admin updated successfully!");
        } else {
            System.out.println("Admin not found!");
        }
    }

    private static void deleteAdmin(AdminDAO adminDAO) {
        System.out.println("==== Delete Admin ====");
        System.out.print("Enter Admin ID: ");
        Long adminId = scanner.nextLong();
        Admin admin = adminDAO.getAdminById(adminId);

        if (admin != null) {
            adminDAO.deleteAdmin(adminId);
            System.out.println("Admin deleted successfully!");
        } else {
            System.out.println("Admin not found!");
        }
    }
}