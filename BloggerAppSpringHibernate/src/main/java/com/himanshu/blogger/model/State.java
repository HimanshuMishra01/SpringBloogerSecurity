package com.himanshu.blogger.model;

public enum State {

	ACTIVE(1), INACTIVE(2), LOCKED(3), DELETED(4);

	private int state;

	private State(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	@Override
    public String toString(){
        return this.name();
    }
 
    public String getName(){
        return this.name();
    }

}
