package com.oop;

import java.util.*;

//Base Room class
class Room {
 protected int roomNumber;
 protected boolean isBooked;

 public Room(int roomNumber) {
     this.roomNumber = roomNumber;
     this.isBooked = false;
 }

 public int getRoomNumber() {
     return roomNumber;
 }

 public boolean isBooked() {
     return isBooked;
 }

 public void bookRoom() {
     if (!isBooked) {
         isBooked = true;
         System.out.println("Room " + roomNumber + " has been booked.");
     } else {
         System.out.println("Room " + roomNumber + " is already booked.");
     }
 }

 public void checkOutRoom() {
     if (isBooked) {
         isBooked = false;
         System.out.println("Room " + roomNumber + " has been checked out.");
     } else {
         System.out.println("Room " + roomNumber + " is not currently booked.");
     }
 }
}

//Standard Room subclass
class StandardRoom extends Room {
 public StandardRoom(int roomNumber) {
     super(roomNumber);
 }

 @Override
 public String toString() {
     return "Standard Room - Room Number: " + roomNumber + ", Booked: " + isBooked;
 }
}

//Deluxe Room subclass
class DeluxeRoom extends Room {
 public DeluxeRoom(int roomNumber) {
     super(roomNumber);
 }

 @Override
 public String toString() {
     return "Deluxe Room - Room Number: " + roomNumber + ", Booked: " + isBooked;
 }
}

//Customerrr class
class Customerrr {
 private String name;
 private String contact;

 public Customerrr(String name, String contact) {
     this.name = name;
     this.contact = contact;
 }

 @Override
 public String toString() {
     return "Customer Name: " + name + ", Contact: " + contact;
 }
}

//Booking class
class Booking {
 private Room room;
 private Customerrr customer;

 public Booking(Room room, Customerrr customer) {
     this.room = room;
     this.customer = customer;
     room.bookRoom();
 }

 @Override
 public String toString() {
     return "Booking Details: " + customer + ", Room: " + room.getRoomNumber();
 }
}

//Main class
public class HotelManagement {
 public static void main(String[] args) {
     // Create rooms
     List<Room> rooms = new ArrayList<>();
     for (int i = 1; i <= 5; i++) {
         rooms.add(new StandardRoom(i));
     }
     for (int i = 6; i <= 10; i++) {
         rooms.add(new DeluxeRoom(i));
     }

     // Simulate booking system
     Scanner scanner = new Scanner(System.in);
     while (true) {
         System.out.println("\nHotel Room Booking System");
         System.out.println("1. View All Rooms");
         System.out.println("2. Book a Room");
         System.out.println("3. Check Out a Room");
         System.out.println("4. Exit");
         System.out.print("Enter your choice: ");
         int choice = scanner.nextInt();

         switch (choice) {
             case 1:
                 System.out.println("\nRoom List:");
                 for (Room room : rooms) {
                     System.out.println(room);
                 }
                 break;
             case 2:
                 System.out.print("Enter Room Number to Book: ");
                 int roomNumberToBook = scanner.nextInt();
                 Room roomToBook = findRoom(rooms, roomNumberToBook);
                 if (roomToBook != null) {
                     System.out.print("Enter Customer Name: ");
                     String name = scanner.next();
                     System.out.print("Enter Customer Contact: ");
                     String contact = scanner.next();
                     Customerrr customer = new Customerrr(name, contact);
                     new Booking(roomToBook, customer);
                 } else {
                     System.out.println("Invalid Room Number!");
                 }
                 break;
             case 3:
                 System.out.print("Enter Room Number to Check Out: ");
                 int roomNumberToCheckOut = scanner.nextInt();
                 Room roomToCheckOut = findRoom(rooms, roomNumberToCheckOut);
                 if (roomToCheckOut != null) {
                     roomToCheckOut.checkOutRoom();
                 } else {
                     System.out.println("Invalid Room Number!");
                 }
                 break;
             case 4:
                 System.out.println("Exiting system. Goodbye!");
                 scanner.close();
                 return;
             default:
                 System.out.println("Invalid choice. Try again.");
         }
     }
 }

 private static Room findRoom(List<Room> rooms, int roomNumber) {
     for (Room room : rooms) {
         if (room.getRoomNumber() == roomNumber) {
             return room;
         }
     }
     return null;
 }
}
