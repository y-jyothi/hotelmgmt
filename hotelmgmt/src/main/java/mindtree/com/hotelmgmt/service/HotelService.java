package mindtree.com.hotelmgmt.service;

import java.util.List;

import mindtree.com.hotelmgmt.entity.Rooms;
import mindtree.com.hotelmgmt.exceptions.serviceexceptions.ServiceException;

public interface HotelService {
	public boolean insertHotelToDao(int hotelId,String hotelName,String location,List<Rooms> room)throws ServiceException;
	public List<Rooms> getAvailableRooms(int hotelId )throws ServiceException;
	public boolean bookRoom(int roomId) throws ServiceException;
	public boolean  updateRoomName(String roomName,String newName) throws ServiceException;
	public List<Rooms> showAllRooms(int hotelId)throws ServiceException;
	public boolean deleteRoom(int hotelId,String roomName) throws ServiceException;
}
