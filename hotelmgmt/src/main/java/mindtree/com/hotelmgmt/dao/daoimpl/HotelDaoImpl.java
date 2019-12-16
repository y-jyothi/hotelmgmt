package mindtree.com.hotelmgmt.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.CallableStatement;

import mindtree.com.hotelmgmt.dao.HotelDao;
import mindtree.com.hotelmgmt.entity.Rooms;
import mindtree.com.hotelmgmt.exceptions.daoexceptions.DaoException;
import mindtree.com.hotelmgmt.utility.HotelUtility;

public class HotelDaoImpl  implements HotelDao{

	public boolean insert(int hotelId, String hotelName, String location, List<Rooms> room) throws DaoException {
		String query1="insert into hotel values(?,?,?)";
		String query2 = "insert into rooms values(?,?,?,?,?)";
		
	

		
		try {
			Connection con = HotelUtility.connect();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(query1);
			
			ps.setInt(1, hotelId);
			ps.setString(2,hotelName );
			ps.setString(3, location);
			int i=ps.executeUpdate();
//			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(query1);
			PreparedStatement pstmt=null;int j=0;
			//insertProject(projects);
			for (Rooms rooms: room) {
				pstmt = (PreparedStatement) con.prepareStatement(query2);
				//Project projects1=new Project();
				int roomId=rooms.getRoomId();
				String roomName=rooms.getRoomName();
				int cost=rooms.getCost();
				boolean isBooked=rooms.isBooked();
				int hotelid=hotelId;
				
				
				    pstmt.setInt(1, roomId);
					pstmt.setString(2,roomName);
					pstmt.setInt(3, cost);
					pstmt.setBoolean(4,isBooked);
					pstmt.setInt(5,hotelId);
					j=pstmt.executeUpdate();
											

			}

			if(i==1&&j==1)
				return true;

		} catch (SQLException e) {
			throw new DaoException("SQL Exception", e);
		}
		
		return false;
	
	
	}

	public List<Rooms> getRooms(int hotelId) throws DaoException {
		List<Rooms> room1=new ArrayList<Rooms>();
		String query = "select * from rooms where hotelId='"+hotelId+"' and isBooked=false";
		Connection con =null;
		PreparedStatement ps=null;

		try {
		 con = HotelUtility.connect();
		 ps = (PreparedStatement) con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Rooms room=new Rooms();
				room.setRoomId(rs.getInt(1));
				room.setRoomName(rs.getString(2));
				room.setCost(rs.getInt(3));
				room1.add(room);

			}
		} catch (SQLException e) {
			throw new DaoException("SQL Exception", e);
		}

		return room1;
	}
	
	 public boolean hotelexists(int hotelId) throws DaoException{
		 String query = "select * from rooms where hotelId='"+hotelId+"' and isBooked=false";
			Connection con =null;
			PreparedStatement ps=null;

			try {
			 con = HotelUtility.connect();
			 ps = (PreparedStatement) con.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					return true;
				}
			} catch (SQLException e) {
				throw new DaoException("SQL Exception", e);
			}

		return false;
		 
	 }

	public boolean bookRoom(int rId) throws DaoException {
		Connection con =null;
		CallableStatement ps=null;

		String query = "call updateRoom{rID}";
		try {
			 con = HotelUtility.connect();
			ps = (CallableStatement) con.prepareCall(query);
			
			int i=ps.executeUpdate();
			if(i==1)
				return true;

		} catch (SQLException e) {
			throw new DaoException("SQL Exception", e);
		}
		return false;
	}

	public boolean roomNameExists(String roomName) throws DaoException {
		 String query = "select * from rooms where roomName='"+roomName+"'";
			Connection con =null;
			PreparedStatement ps=null;

			try {
			 con = HotelUtility.connect();
			 ps = (PreparedStatement) con.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					return true;
				}
			} catch (SQLException e) {
				throw new DaoException("SQL Exception", e);
			}

		return false;
	}

	public boolean updateRoomName(String roomName, String newName) throws DaoException {
		Connection con =null;
		PreparedStatement ps=null;

		String query = "   update rooms set roomName='"+newName+"' where roomName='"+roomName+"'";
		try {
			 con = HotelUtility.connect();
			ps = (PreparedStatement) con.prepareStatement(query);
			
			int i=ps.executeUpdate();
			if(i==1)
				return true;

		} catch (SQLException e) {
			throw new DaoException("SQL Exception", e);
		}

				return false;
	}

	public List<Rooms> showAllRooms(int hotelId) throws DaoException {
		List<Rooms> room1=new ArrayList<Rooms>();
		String query = "select * from rooms where hotelId='"+hotelId+"'";
		Connection con =null;
		PreparedStatement ps=null;

		try {
		 con = HotelUtility.connect();
		 ps = (PreparedStatement) con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Rooms room=new Rooms();
				room.setRoomId(rs.getInt(1));
				room.setRoomName(rs.getString(2));
				room.setCost(rs.getInt(3));
				room1.add(room);

			}
		} catch (SQLException e) {
			throw new DaoException("SQL Exception", e);
		}

		return room1;	
		}

	public boolean deleteRoom(int hotelId, String roomName) throws DaoException {
		
			Connection con =null;
			PreparedStatement ps=null;

			String query = " delete from rooms where hotelId='"+hotelId+"' and roomName='"+roomName+"'";
			try {
				con = HotelUtility.connect();
				 ps = (PreparedStatement) con.prepareStatement(query);
				
				int i=ps.executeUpdate();
				if(i==1)
					return true;

			} catch (SQLException e) {
				throw new DaoException("SQL Exception", e);
			}
		return false;
	}

	

	
}
