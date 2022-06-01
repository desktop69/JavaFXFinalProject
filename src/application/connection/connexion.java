package application.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connexion {
static Connection con = null ;
static {
	try{
	String db_url="jdbc:mysql://localhost:3306/finaljavafxdatabase";
	
	String userName="root";
	String password="";
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection(db_url,userName,password);
	System.out.println("connected fuckk ");
	
	}catch(ClassNotFoundException | SQLException e){
		
	}
}
public static Connection getCon(){
	return con ;

	
	
}
}

