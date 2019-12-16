package mindtree.com.hotelmgmt.entity;

public class Rooms {
	private int roomId;
	private String roomName;
	private int cost;
	private boolean isBooked;
	public Rooms() {
		super();
	
	}
	public Rooms(int roomId, String roomName, int cost, boolean isBooked) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
		this.cost = cost;
		this.isBooked = isBooked;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public boolean isBooked() {
		return isBooked;
	}
	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}
	@Override
	public String toString() {
		return "Rooms [roomId=" + roomId + ", roomName=" + roomName + ", cost=" + cost + ", isBooked=" + isBooked + "]";
	}
	

}
