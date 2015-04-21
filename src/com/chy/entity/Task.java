package com.chy.entity;

import java.util.Date;

public class Task {

	private Long id;
	private User employer;
	private User employee;
	private Byte type;
	private Double corpus;
	private Double reward;
	private Date releaseDate;
	private Date endDate;
	private String params;
	private Byte dealState;
	private Byte payState;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getEmployer() {
		return employer;
	}

	public void setEmployer(User employer) {
		this.employer = employer;
	}

	public User getEmployee() {
		return employee;
	}

	public void setEmployee(User employee) {
		this.employee = employee;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public Double getCorpus() {
		return corpus;
	}

	public void setCorpus(Double corpus) {
		this.corpus = corpus;
	}

	public Double getReward() {
		return reward;
	}

	public void setReward(Double reward) {
		this.reward = reward;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public Byte getDealState() {
		return dealState;
	}

	public void setDealState(Byte dealState) {
		this.dealState = dealState;
	}

	public Byte getPayState() {
		return payState;
	}

	public void setPayState(Byte payState) {
		this.payState = payState;
	}

}
