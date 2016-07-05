package com.pluralsight.model;

import org.hibernate.validator.constraints.Range;

public class Goal {
	@Range(min=10, max=200)
	private int minutes;

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
}
