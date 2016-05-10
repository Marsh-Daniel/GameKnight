import java.util.ArrayList;

public class Event {
	
	String eventName;
	String datetime;
	String address;
	String description;
	ArrayList<String> listOfGames;
	
	
	public Event(String gamename, String datetime, String address, String description){
		this.eventName = gamename;
		this.datetime = datetime;
		this.address = address;
		this.description = description;
	}
	
	public String getGamename() {
		return eventName;
	}
	public void setGamename(String gamename) {
		this.eventName = gamename;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public ArrayList<String> getListOfGames() {
		return listOfGames;
	}

	public void setListOfGames(ArrayList<String> listOfGames) {
		this.listOfGames = listOfGames;
	}
	

}
