package com.aplose.smooss.model;

import java.time.Instant;

public class Comment {
	private String comment;
	private Instant date;
	private Instant hour;
	private User author;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public Instant getHour() {
		return date;
	}

	public void setHour(Instant hour) {
		this.hour = hour;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

}
