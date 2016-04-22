package com.ooadproject.kja.checkers.models;

public class JumpMove {
	private boolean forwardLeft = false;
	private boolean forwardRight = false;
	private boolean backLeft = false;
	private boolean backRight = false;
	
	public JumpMove(){
	}
	
	public boolean isForwardLeft() {
		return forwardLeft;
	}
	public void setForwardLeft(boolean forwardLeft) {
		this.forwardLeft = forwardLeft;
	}
	public boolean isForwardRight() {
		return forwardRight;
	}
	public void setForwardRight(boolean forwardRight) {
		this.forwardRight = forwardRight;
	}
	public boolean isBackLeft() {
		return backLeft;
	}
	public void setBackLeft(boolean backLeft) {
		this.backLeft = backLeft;
	}
	public boolean isBackRight() {
		return backRight;
	}
	public void setBackRight(boolean backRight) {
		this.backRight = backRight;
	}
}
