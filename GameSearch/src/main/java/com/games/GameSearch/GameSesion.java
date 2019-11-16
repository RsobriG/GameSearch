package com.games.GameSearch;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gamesesions")
public class GameSesion {
	@Id
	private long sesionId;
	@Column(name="userid")
	private String userid;
	@Column(name="gameid")
	private long gameId;
	@Column(name="timestamp")
	private Timestamp timeStamp;
	
	public enum GRelation{PLAYER,ADMIN,MASTER,ADMINMASTER,APPLICANT,GUEST,REMOVED};
	@Column(name="relation")
	private GRelation grelation;
	
	//Constructores
	
	public GameSesion(long gameid, String userid, GRelation grelation) {
		super();
		this.gameId = gameid;
		this.userid =userid;
		this.grelation = grelation;
		this.timeStamp = new Timestamp(System.currentTimeMillis());
	}
	
	public GameSesion() {
		super();
	}
	
	
	//Getters and Setters
	
	public long getSesionId() {
		return sesionId;
	}
	public void setSesionId(long sesionId) {
		this.sesionId = sesionId;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public long getGameId() {
		return gameId;
	}
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	public GRelation getRelation() {
		return grelation;
	}
	public void setRelation(GRelation relation) {
		this.grelation = relation;
	}
	
}
