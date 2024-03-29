package com.app.dao;

import static com.app.utils.DbUtils.fetchDbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.pojo.Book;

public class BookDaoImpl implements IBookDao {

	private Connection cn;
	private PreparedStatement pst1, pst2, pst3;

	public BookDaoImpl() throws SQLException, ClassNotFoundException {

		String sql1 = "select distinct category from dac_books";

		cn = fetchDbConnection();
		pst1 = cn.prepareStatement(sql1);
		pst2 = cn.prepareStatement("select * from dac_books where category=?");
		pst3 = cn.prepareStatement("select * from dac_books where id=?");

		System.out.println("Book Dao Created...");
	}

	@Override
	public List<String> getBookCategory() throws SQLException {

		List<String> cat = new ArrayList<>();

		try (ResultSet rst = pst1.executeQuery()) {

			while (rst.next()) {
				cat.add(rst.getString(1));
			}

		}

		return cat;
	}

	public void cleanUp() throws SQLException {
		if (cn != null) {
			cn.close();
		}
		if (pst1 != null || pst2 != null ||pst3 != null) {
			pst1.close();
			pst2.close();
			pst3.close();
		}
	}

	@Override
	public List<Book> getBooksByCategory(String categoryName) throws SQLException {
		List<Book> lst = new ArrayList<Book>();
		pst2.setString(1, categoryName);

		try (ResultSet rst = pst2.executeQuery()) {
			while (rst.next()) {// int id, String title, String author, String category, double price
				lst.add(new Book(rst.getInt(1), rst.getString(2), rst.getString(3), categoryName, rst.getDouble(5)));
			}

		}

		return lst;
	}

	@Override
	public Book getBookDetById(int bookId) throws SQLException {
		pst3.setInt(1, bookId);

		try (ResultSet rst = pst3.executeQuery()) {

			if (rst.next()) {
				return new Book(bookId, rst.getString(2), rst.getString(3), rst.getString(4), rst.getDouble(5));
			}
		}

		return null;
	}

}
