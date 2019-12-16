package mindtree.com.hotelmgmt.entity;

import java.util.List;

public class Hotel {
	private int hotelId;
	private String name;
	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", name=" + name + ", location=" + location + ", rooms=" + rooms + "]";
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Rooms> getRooms() {
		return rooms;
	}
	public void setRooms(List<Rooms> rooms) {
		this.rooms = rooms;
	}
	public Hotel(int hotelId, String name, String location, List<Rooms> rooms) {
		super();
		this.hotelId = hotelId;
		this.name = name;
		this.location = location;
		this.rooms = rooms;
	}
	private String location;
	private  List<Rooms> rooms;
	public Hotel() {
		super();
			}

}
