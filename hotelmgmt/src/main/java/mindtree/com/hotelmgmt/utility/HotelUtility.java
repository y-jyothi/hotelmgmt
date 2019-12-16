package mindtree.com.hotelmgmt.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class HotelUtility {
	private static final String URL="jdbc:mysql://localhost:3306/hotelmgmt";
	private static final String user="root";
	private static final String password="Welcome123";
		
			public static Connection connect()
			{
				Connection con=null;
				
				try
				{
					//Class.forName("com.mysql.jdbc.Driver").newInstance();
					con=DriverManager.getConnection(URL, user, password);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				return con;
				
			}

		}





