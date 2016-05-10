package com.gk.event;

import java.util.Date;

public class Event {
	String eventName;
	String eventPlace;
	Date eventDate;
	String description;

	public Event(String eventName, String eventPlace, Date eventDate, String description) {
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.eventPlace = eventPlace;
		this.description = description;

	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventPlace() {
		return eventPlace;
	}

	public void setEventPlace(String eventPlace) {
		this.eventPlace = eventPlace;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
