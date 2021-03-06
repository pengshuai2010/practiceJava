package trysqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TrySqlite {
	//http://www.tutorialspoint.com/sqlite/sqlite_java.htm
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection c  = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Opened database successfully");
		Statement stmt = null;
		stmt = c.createStatement();
		//drop if exist
		String sql = "DROP  TABLE IF EXISTS `COMPANY`;";
		stmt.executeUpdate(sql);
		//create table
	    sql = "CREATE TABLE COMPANY " +
                  "(ID INT PRIMARY KEY     NOT NULL," +
                  " NAME           TEXT    NOT NULL, " + 
                  " AGE            INT     NOT NULL, " + 
                  " ADDRESS        CHAR(50), " + 
                  " SALARY         REAL)";
	    stmt.executeUpdate(sql);
	    
	    sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                  "VALUES (1, 'Paul', 32, 'California', 20000.00 );"; 
	    stmt.executeUpdate(sql);
	    //insert
	    sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
	    		"VALUES (2, 'Allen', 25, 'Texas', 15000.00 );"; 
	    stmt.executeUpdate(sql);

	    sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
	    		"VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );"; 
	    stmt.executeUpdate(sql);

	    sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
	    		"VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );"; 
	    stmt.executeUpdate(sql);
	    //update
	    sql = "UPDATE COMPANY SET SALARY = 25000.0 WHERE ID = 1";
	    stmt.executeUpdate(sql);
	    //delete
	    sql = "DELETE FROM COMPANY WHERE ID = 2";
	    stmt.executeUpdate(sql);
	    //select
	    ResultSet result = stmt.executeQuery("SELECT * FROM COMPANY;");
	    while(result.next()) {
	    	int id = result.getInt("ID");
	    	String name = result.getString("NAME");
	    	int age = result.getInt("AGE");
	    	String addr = result.getString("ADDRESS");
	    	float salary = result.getFloat("SALARY");
	    	System.out.println("ID\t=\t" + id);
	    	System.out.println("NAME\t=\t" + name);
	    	System.out.println("AGE\t=\t" + age);
	    	System.out.println("SALARY\t=\t" + salary);
	    	System.out.println();
	    }
	    result.close();
	    
	    stmt.close();
//	    c.commit();// only use if not in auto-commit mode
	    c.close();
	}

}
