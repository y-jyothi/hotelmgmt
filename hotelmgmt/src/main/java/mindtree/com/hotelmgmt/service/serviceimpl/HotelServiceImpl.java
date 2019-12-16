package mindtree.com.hotelmgmt.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import mindtree.com.hotelmgmt.dao.HotelDao;
import mindtree.com.hotelmgmt.dao.daoimpl.HotelDaoImpl;
import mindtree.com.hotelmgmt.entity.Rooms;
import mindtree.com.hotelmgmt.exceptions.daoexceptions.DaoException;
import mindtree.com.hotelmgmt.exceptions.serviceexceptions.NoSuchHotelExistsException;
import mindtree.com.hotelmgmt.exceptions.serviceexceptions.NoSuchRoomExists;
import mindtree.com.hotelmgmt.exceptions.serviceexceptions.ServiceException;
import mindtree.com.hotelmgmt.service.HotelService;

public class HotelServiceImpl implements HotelService {
	static HotelDao dao=new HotelDaoImpl();

	public boolean insertHotelToDao(int hotelId, String hotelName, String location, List<Rooms> room)throws ServiceException {
	
		try {
			boolean isInserted=dao.insert(hotelId, hotelName, location, room);
			if(isInserted)
				return true;
		} catch (DaoException e) {
					throw new ServiceException(e.getMessage(),e);	
		}
		return false;
	}

	public List<Rooms> getAvailableRooms(int hotelId) throws ServiceException {
		List<Rooms> rooms=new ArrayList<Rooms>();
	try {
		boolean hotelExists=dao.hotelexists(hotelId);
		if(!(hotelExists))
			throw new NoSuchHotelExistsException("no such hotel exists");
		rooms=dao.getRooms(hotelId);
		
	} catch (DaoException e) {
		throw new ServiceException(e.getMessage(),e);	

		
	}
		return rooms;
	}

	public boolean bookRoom(int roomId) throws ServiceException {
		boolean isUpdated=false;
		try {
			isUpdated=dao.bookRoom(roomId);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e);	

		}
		return isUpdated;
	}

	public boolean updateRoomName(String roomName, String newName) throws ServiceException {
		boolean isUpdated=false;
		try {
			isUpdated=dao.updateRoomName(roomName, newName);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e);	

		}
		return isUpdated;
	
	}

	public List<Rooms> showAllRooms(int hotelId) throws ServiceException {
		List<Rooms> rooms=new ArrayList<Rooms>();
		try {
//			boolean hotelExists=dao.hotelexists(hotelId);
//			if(!(hotelExists))
//				throw new NoSuchHotelExistsException("no such hotel exists");
			rooms=dao.showAllRooms(hotelId);
			for (Rooms rooms2 : rooms) {
				System.out.println(rooms2);
			}
			
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e);	

			
		}
			return rooms;
		}

	public boolean deleteRoom(int hotelId, String roomName) throws ServiceException {
		//boolean updated=false;
		try {
			boolean roomExists=dao.roomNameExists(roomName);
			if(!(roomExists))
				throw new NoSuchRoomExists("no such room exists");
			
			}catch (DaoException e) {
			throw new ServiceException(e.getMessage(),e);	

		}
		try {
			boolean updated=dao.deleteRoom(hotelId, roomName);
		 if(updated)
			 return true;
		}catch(DaoException e) {
			throw new ServiceException(e.getMessage(),e);	
		}

		return false;
	}

		
	

	
	

}
