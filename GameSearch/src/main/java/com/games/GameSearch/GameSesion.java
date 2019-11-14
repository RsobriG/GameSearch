package com.games.GameSearch;

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
	private Date timeStamp;
	
	public enum Relation{PLAYER,ADMIN,MASTER,ADMINMASTER,APPLICANT,GUEST,REMOVED};
	@Column(name="relation")
	private Relation relation;
	
	//Constructores
	
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
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public Relation getRelation() {
		return relation;
	}
	public void setRelation(Relation relation) {
		this.relation = relation;
	}
	
}
