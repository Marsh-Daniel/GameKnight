package com.gk.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BoardGame {
	public static void main(String[] args) throws Exception {
		addGamesToDatabase(28552);
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
			System.out.println("Game number " + gameID + " not found...");
			addGamesToDatabase(gameID + 1);
		}
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			preJson.append(inputLine);
		in.close();

		String boardgameInfo = preJson.toString();
		StringBuilder mechanicsList = new StringBuilder();

		JSONObject object = new JSONObject(boardgameInfo);
		JSONArray mechanics = object.getJSONArray("mechanics");
		String gameName = object.getString("name");
		boolean isExpansion = object.getBoolean("isExpansion");
		isExpansion = expansionCheck(object);
		if (isExpansion) {
			System.out.println("Game number " + gameID + " is an Expansion. Adding to Expansion table.");
			addExpansionToDatabase(object);
		} else {
			int length = mechanics.length();
			for (int i = 0; i < length; i++) {
				mechanicsList.append(mechanics.getString(i) + ",");
			}
			DAO.addGameToDatabase(gameName, mechanicsList.toString());
		}
		System.out.println("adding game " + gameID + "...");
		addGamesToDatabase(gameID + 1);
	}

	public static void addExpansionToDatabase(JSONObject expansionPack) throws Exception {
		JSONArray listOfGames = expansionPack.getJSONArray("expands");
		String expansionName = expansionPack.getString("name");
		JSONArray mechanics = expansionPack.getJSONArray("mechanics");
		StringBuilder expansionMechanics = new StringBuilder();
		int length = mechanics.length();
		for (int i = 0; i < length; i++) {
			expansionMechanics.append(mechanics.get(i) + ",");
		}
		JSONObject originalGame = listOfGames.getJSONObject(0);
		String originalGameName = originalGame.getString("name");
		int gameID = DAO.getIDFromDatabase(originalGameName);
		DAO.addExpansionToDatabase(gameID, originalGameName, expansionName, expansionMechanics.toString());
	}

	public static boolean expansionCheck(JSONObject expansionPack) {
		try {
			expansionPack.getJSONArray("expands");
		} catch (JSONException e) {
			return false;
		}
		return true;
	}

}
