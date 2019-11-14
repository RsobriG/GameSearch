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
public @Data class Game{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="gameId", updatable = false, nullable = false)
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

}
