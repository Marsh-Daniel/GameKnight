package com.gk.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class BoardGameDAO {
	public static void main(String[] args) throws Exception {
		addGamesToDatabase(1);
	}

	public static void addGamesToDatabase(int gameID) throws Exception {

		StringBuilder preJson = new StringBuilder();
		URLConnection connection = null;
		URL boardGameGeeksID = null;
		BufferedReader in = null;

		try {
			boardGameGeeksID = new URL("https://bgg-json.azurewebsites.net/thing/" + gameID);
			connection = boardGameGeeksID.openConnection();
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

		} catch (Exception e) {
			addGamesToDatabase(gameID + 1);
		}
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			preJson.append(inputLine);
		in.close();

		String boardgameInfo = preJson.toString();

		JSONObject object = new JSONObject(boardgameInfo);
		JSONArray mechanics = object.getJSONArray("mechanics");
		String idNumber = object.getString("name");

		System.out.println(gameID);
		System.out.println(idNumber);
		addGamesToDatabase(gameID + 1);

	}

}
