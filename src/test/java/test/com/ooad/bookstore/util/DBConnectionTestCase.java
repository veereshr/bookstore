package test.com.ooad.bookstore.util;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

import com.ooad.bookstore.util.DBConnection;

import junit.framework.Assert;
import junit.framework.TestCase;

public class DBConnectionTestCase extends TestCase{
	
	public static final String DATABASE_NAME = "bookstore";

	@Test
	public void testGetConnection() throws SQLException, FileNotFoundException {
		
		try {
			Connection connection = DBConnection.getConnection(DATABASE_NAME);
			Assert.assertNotNull(connection);
			Assert.assertTrue(connection.isValid(0));
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
