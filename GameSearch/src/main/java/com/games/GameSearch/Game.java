package com.games.GameSearch;



import java.sql.Date;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name="games")
public class Game{



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="gameId", updatable = true, nullable = false)
	private long gameId;

	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;

	@Column(name="date")
	private Date date;
	
	@Column(name="timeGame")
	private Calendar timeGame;

	@Column(name="maxplayers")
	private int maxPlayers;

	@Column(name="latitude")
	private double latitude;

	@Column(name="longitude")
	private double longitude;

	@Column(name="address")
	private String address;

	@Column(name="place")
	private String place;

	public enum GameType{TABLE,ROL};
	@Column(name="gameType")
	private GameType gametype;

	public enum GameState{PUBLIC,HIDDEN,CLOSED,EXPIRED};
	@Column(name="gameState")
	private GameState gamestate;

	//Constructor
    
	public Game() {
		super();
	}
	
	public Game(String name) {
		super();
		this.name = name;
		
	}
	
	//Getter and Setters
	
	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Calendar getTimeGame() {
		return timeGame;
	}

	public void setTimeGame(Calendar timeGame) {
		this.timeGame = timeGame;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public GameType getGametype() {
		return gametype;
	}

	public void setGametype(GameType gametype) {
		this.gametype = gametype;
	}

	public GameState getGamestate() {
		return gamestate;
	}

	public void setGamestate(GameState gamestate) {
		this.gamestate = gamestate;
	}


}
