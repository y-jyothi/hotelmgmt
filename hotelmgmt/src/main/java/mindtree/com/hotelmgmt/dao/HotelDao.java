package mindtree.com.hotelmgmt.dao;

import java.util.List;

import mindtree.com.hotelmgmt.entity.Rooms;
import mindtree.com.hotelmgmt.exceptions.daoexceptions.DaoException;

public interface HotelDao {
	public boolean insert(int hotelId,String hotelName,String location,List<Rooms> room)throws DaoException ;
    public List<Rooms> getRooms(int hotelId) throws DaoException;
    public boolean hotelexists(int hotelId) throws DaoException;
    public boolean roomNameExists(String roomName) throws DaoException;
    public boolean bookRoom(int roomId)throws DaoException;
   public List<Rooms> showAllRooms(int hotelId) throws DaoException;
    public boolean updateRoomName(String roomName,String newName)throws DaoException;
    public boolean deleteRoom(int hotelId,String roomName)throws DaoException;
    
}
