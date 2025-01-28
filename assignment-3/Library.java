package com.oop;

import java.io.*;
import java.util.*;

class Book implements Serializable {
    private int id;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Issued: " + isIssued;
    }
}

class Member implements Serializable {
    private int id;
    private String name;

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Member ID: " + id + ", Name: " + name;
    }
}

class Transaction implements Serializable {
    private int bookId;
    private int memberId;
    private Date issueDate;
    private Date returnDate;

    public Transaction(int bookId, int memberId, Date issueDate) {
        this.bookId = bookId;
        this.memberId = memberId;
        this.issueDate = issueDate;
    }

    public int getBookId() {
        return bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Member ID: " + memberId + ", Issue Date: " + issueDate + ", Return Date: " + (returnDate == null ? "Not Returned" : returnDate);
    }
}

public class Library {
    private static final String BOOKS_FILE = "books.dat";
    private static final String MEMBERS_FILE = "members.dat";
    private static final String TRANSACTIONS_FILE = "transactions.dat";

    private List<Book> books;
    private List<Member> members;
    private List<Transaction> transactions;

    public Library() {
        books = loadData(BOOKS_FILE);
        members = loadData(MEMBERS_FILE);
        transactions = loadData(TRANSACTIONS_FILE);
    }

    @SuppressWarnings("unchecked")
    private <T> List<T> loadData(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    private <T> void saveData(String filename, List<T> data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(data);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public void addBook(int id, String title, String author) {
        books.add(new Book(id, title, author));
        saveData(BOOKS_FILE, books);
    }

    public void addMember(int id, String name) {
        members.add(new Member(id, name));
        saveData(MEMBERS_FILE, members);
    }

    public void issueBook(int bookId, int memberId) {
        Optional<Book> book = books.stream().filter(b -> b.getId() == bookId && !b.isIssued()).findFirst();
        if (book.isPresent()) {
            book.get().setIssued(true);
            transactions.add(new Transaction(bookId, memberId, new Date()));
            saveData(BOOKS_FILE, books);
            saveData(TRANSACTIONS_FILE, transactions);
        } else {
            System.out.println("Book is not available.");
        }
    }

    public void returnBook(int bookId) {
        Optional<Transaction> transaction = transactions.stream().filter(t -> t.getBookId() == bookId && t.getReturnDate() == null).findFirst();
        if (transaction.isPresent()) {
            transaction.get().setReturnDate(new Date());
            books.stream().filter(b -> b.getId() == bookId).findFirst().ifPresent(b -> b.setIssued(false));
            saveData(BOOKS_FILE, books);
            saveData(TRANSACTIONS_FILE, transactions);
        } else {
            System.out.println("No ongoing transaction found for the book.");
        }
    }

    public void displayBooks() {
        books.forEach(System.out::println);
    }

    public void displayMembers() {
        members.forEach(System.out::println);
    }

    public void displayTransactions() {
        transactions.forEach(System.out::println);
    }
    public static void main(String[] args) {
        Library system = new Library();
        system.addBook(1, "Java Programming", "Author A");
        system.addBook(2, "Data Structures", "Author B");
        system.addMember(1, "Alice");
        system.addMember(2, "Bob");

        system.issueBook(1, 1);
        system.returnBook(1);

        System.out.println("Books:");
        system.displayBooks();

        System.out.println("Members:");
        system.displayMembers();

        System.out.println("Transactions:");
        system.displayTransactions();
    }
}