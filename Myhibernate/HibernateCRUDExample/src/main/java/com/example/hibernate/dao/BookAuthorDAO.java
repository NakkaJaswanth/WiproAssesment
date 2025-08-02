package com.example.hibernate.dao;

import com.example.hibernate.model.Author;
import com.example.hibernate.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class BookAuthorDAO {

    private SessionFactory sessionFactory;

    public BookAuthorDAO() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Author.class)
                .buildSessionFactory();
    }

    public void addBookWithAuthors(String bookTitle, List<String> authorNames) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Book book = new Book(bookTitle);

        for (String authorName : authorNames) {
            Author author = findOrCreateAuthor(session, authorName);
            book.addAuthor(author);
        }

        session.persist(book);
        tx.commit();
        session.close();

        System.out.println("Book and authors saved.");
    }

    private Author findOrCreateAuthor(Session session, String name) {
        Query<Author> query = session.createQuery("from Author where name = :name", Author.class);
        query.setParameter("name", name);
        Author author = query.uniqueResult();
        if (author == null) {
            author = new Author(name);
            session.persist(author);
        }
        return author;
    }

    public void viewAllBooks() {
        Session session = sessionFactory.openSession();
        List<Book> books = session.createQuery("from Book", Book.class).list();

        for (Book book : books) {
            System.out.println("Book ID: " + book.getId() + ", Title: " + book.getTitle());
            for (Author author : book.getAuthors()) {
                System.out.println("  - Author ID: " + author.getId() + ", Name: " + author.getName());
            }
        }

        session.close();
    }

    public void deleteBook(long bookId) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Book book = session.get(Book.class, bookId);
        if (book != null) {
            for (Author author : book.getAuthors()) {
                author.getBooks().remove(book);
            }
            book.getAuthors().clear();

            session.delete(book);
            System.out.println("Book deleted.");
        } else {
            System.out.println("Book not found.");
        }

        tx.commit();
        session.close();
    }

    public void closeFactory() {
        if (sessionFactory != null) sessionFactory.close();
    }
}
