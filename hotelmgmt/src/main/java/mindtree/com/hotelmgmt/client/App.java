package mindtree.com.hotelmgmt.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mindtree.com.hotelmgmt.entity.Rooms;
import mindtree.com.hotelmgmt.exceptions.serviceexceptions.ServiceException;
import mindtree.com.hotelmgmt.service.HotelService;
import mindtree.com.hotelmgmt.service.serviceimpl.HotelServiceImpl;

public class App {
	static Scanner scan = new Scanner(System.in);
	static HotelService ser = new HotelServiceImpl();

	public static void main(String[] args) {
		String ans = " ";
		do {
			System.out.println("1.insert hotel with rooms\n 2.show rooms which is not booked under a hotel\n "
					+ "3.book a room under particular hotel\n 4.update room under particular hotel name\n 5.delete a particular room\n 6.exit\n");
			System.out.println("enter valid choice");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				insertHotel();
				break;
			case 2:
				roomsAvailable();
				break;
			case 3:
				bookRoom();
				break;
			case 4:
				updateRoomName();
				break;
			case 5:deleteRoom();
			break;
			case 6:System.exit(0);

			}
			System.out.println("do u want to continue");
			ans = scan.next();

		} while (ans.equalsIgnoreCase("yes"));
	}

	private static void deleteRoom() {
		System.out.println("enter hotelid");
		int hotelId=scan.nextInt();
		System.out.println("enter room name");
		String roomName=scan.next();
		try {
			boolean isDeleted=ser.deleteRoom(hotelId, roomName);
			if(isDeleted)
				System.out.println("deleted succesfully");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

	private static void updateRoomName() {
		List<Rooms> room = new ArrayList<Rooms>();
		System.out.println("enter hotel Id");
		int hotelId = scan.nextInt();

		try {
			room = ser.showAllRooms(hotelId);
			for (Rooms rooms : room) {
				System.out.println(rooms);
			}
		} catch (ServiceException e) {

			System.out.println(e.getMessage());
		}
		System.out.println("enter room name");
		String roomName = scan.next();
		System.out.println("enter new room name");
		String newName = scan.next();
		boolean isUpdated=false;

		try {
			isUpdated=ser.updateRoomName(roomName, newName);
			if(isUpdated)
				System.out.println("updated succesfully");
		} catch (ServiceException e) {
			
			System.out.println(e.getMessage());
		}

	}

	private static void bookRoom() {
		List<Rooms> room;
		System.out.println("enter hotelId");
		int hotelId = scan.nextInt();
		try {
			room = ser.getAvailableRooms(hotelId);
			for (Rooms rooms : room) {
				System.out.println(rooms);
			}
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			}
		
		boolean isBooked = false;
		System.out.println("enter roomId to book");
		int roomId = scan.nextInt();
		try {
			isBooked = ser.bookRoom(roomId);
			if (isBooked)
				System.out.println("booked succesfully");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	private static void roomsAvailable() {
		System.out.println("enter hotel id");
		int hotelId = scan.nextInt();
		List<Rooms> room = new ArrayList<Rooms>();
		try {
			room = ser.getAvailableRooms(hotelId);
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
		for (Rooms rooms : room) {
			System.out.println(room);
		}

	}

	private static void insertHotel() {

		System.out.println("enter hotelId");
		int hotelId = scan.nextInt();
		System.out.println("enter hotel name");
		String hotelName = scan.next();
		System.out.println("enter location");
		String location = scan.next();

		System.out.println("enter number of rooms");
		int num = scan.nextInt();
		List<Rooms> room = new ArrayList<Rooms>();
		for (int i = 0; i < num; i++) {

			System.out.println("enter Roomid");
			int roomId = scan.nextInt();
			System.out.println("enter Room Name");
			String roomName = scan.next();
			System.out.println("enter cost");
			int cost = scan.nextInt();
			System.out.println("room isbooked?");
			boolean isBooked = scan.nextBoolean();
			room.add(new Rooms(roomId, roomName, cost, isBooked));
		}

		try {
			boolean isInserted = ser.insertHotelToDao(hotelId, hotelName, location, room);
			if (isInserted) {
				System.out.println("updated successfully");
			}
		} catch (ServiceException e) {
			System.out.println(e.getMessage());

		}

	}
}
