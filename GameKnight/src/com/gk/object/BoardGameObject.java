package com.gk.object;

import java.util.ArrayList;

public class BoardGameObject {
	private int idNumber;
	private String name;
	private ArrayList<String> mechanics;

	public BoardGameObject(int idNumber, String name, ArrayList<String> mechanics) {
		this.idNumber = idNumber;
		this.name = name;
		this.mechanics = mechanics;
	}

	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getMechanics() {
		return mechanics;
	}

	public void setMechanics(ArrayList<String> mechanics) {
		this.mechanics = mechanics;
	}
}
