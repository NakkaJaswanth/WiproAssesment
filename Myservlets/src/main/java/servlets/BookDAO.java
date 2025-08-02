package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	 private String jdbcURL = "jdbc:mysql://localhost:3306/bookstore";
	    private String jdbcUsername = "root";
	    private String jdbcPassword = "";

	    private static final String INSERT_SQL = "INSERT INTO books (title, author, price) VALUES (?, ?, ?)";
	    private static final String SELECT_ALL = "SELECT * FROM books";
	    private static final String DELETE_SQL = "DELETE FROM books WHERE id = ?";
	    private static final String SELECT_BY_ID = "SELECT * FROM books WHERE id = ?";
	    private static final String UPDATE_SQL = "UPDATE books SET title = ?, author = ?, price = ? WHERE id = ?";

	    protected Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	    }

	    public void insertBook(Book book) throws SQLException {
	        try (Connection con = getConnection();
	             PreparedStatement ps = con.prepareStatement(INSERT_SQL)) {
	            ps.setString(1, book.getTitle());
	            ps.setString(2, book.getAuthor());
	            ps.setDouble(3, book.getPrice());
	            ps.executeUpdate();
	        }
	    }

	    public List<Book> selectAllBooks() throws SQLException {
	        List<Book> books = new ArrayList<>();
	        try (Connection con = getConnection();
	             PreparedStatement ps = con.prepareStatement(SELECT_ALL)) {
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                books.add(new Book(rs.getInt("id"), rs.getString("title"),
	                                   rs.getString("author"), rs.getDouble("price")));
	            }
	        }
	        return books;
	    }

	    public Book selectBook(int id) throws SQLException {
	        Book book = null;
	        try (Connection con = getConnection();
	             PreparedStatement ps = con.prepareStatement(SELECT_BY_ID)) {
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                book = new Book(id, rs.getString("title"), rs.getString("author"), rs.getDouble("price"));
	            }
	        }
	        return book;
	    }

	    public void deleteBook(int id) throws SQLException {
	        try (Connection con = getConnection();
	             PreparedStatement ps = con.prepareStatement(DELETE_SQL)) {
	            ps.setInt(1, id);
	            ps.executeUpdate();
	        }
	    }

	    public void updateBook(Book book) throws SQLException {
	        try (Connection con = getConnection();
	             PreparedStatement ps = con.prepareStatement(UPDATE_SQL)) {
	            ps.setString(1, book.getTitle());
	            ps.setString(2, book.getAuthor());
	            ps.setDouble(3, book.getPrice());
	            ps.setInt(4, book.getId());
	            ps.executeUpdate();
	        }
	    }
	}



