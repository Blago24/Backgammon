package com.backgammon.models;

public class Checkers {

	private float xPosition;
	private float yPosition;
	private boolean isAlive;
	private boolean isWhite;
	public Checkers(float xPosition, float yPosition, boolean isAlive, boolean isWhite) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.isAlive = isAlive;
		this.isWhite = isWhite;
	}
	public float getxPosition() {
		return xPosition;
	}
	public void setxPosition(float xPosition) {
		this.xPosition = xPosition;
	}
	public float getyPosition() {
		return yPosition;
	}
	public void setyPosition(float yPosition) {
		this.yPosition = yPosition;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	public boolean isWhite() {
		return isWhite;
	}
	public void setWhite(boolean isWhite) {
		this.isWhite = isWhite;
	}
	
	
}
