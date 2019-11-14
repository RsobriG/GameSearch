package com.games.GameSearch;

import java.sql.Timestamp;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userrelations")
public class UserRelation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userrelationid", updatable = true, nullable = false)
	private long userRelationId;
	@Column(name="userid")
	private String userId;
	@Column(name="usertargetid")
	private String userTargetId;
	@Column(name="timestamp")
	private Timestamp tStamp;
	
	public enum Friendship{FRIEND,APPLICANT,REJECTED,BLOCKED};
	@Column(name="friendship")
	private Friendship friendship;

	public UserRelation() {
		super();
	}
	
	public UserRelation(String user, String target, Friendship state) {
		super();
		this.userId = user;
		this.userTargetId = target;
		this.friendship = state;
		this.tStamp = new Timestamp(System.currentTimeMillis());
	}

	public long getUserRelationId() {
		return userRelationId;
	}

	public void setUserRelationId(long userRelationId) {
		this.userRelationId = userRelationId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserTargetId() {
		return userTargetId;
	}

	public void setUserTargetId(String userTargetId) {
		this.userTargetId = userTargetId;
	}

	public Timestamp gettStamp() {
		return tStamp;
	}

	public void settStamp(Timestamp tStamp) {
		this.tStamp = tStamp;
	}

	public Friendship getFriendship() {
		return friendship;
	}

	public void setFriendship(Friendship friendship) {
		this.friendship = friendship;
	}
	
	
}
