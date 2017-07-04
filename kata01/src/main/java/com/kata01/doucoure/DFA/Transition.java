package com.kata01.doucoure.DFA;

public abstract class Transition {

	private State targetState;
	public Transition(State s) {
		this.targetState = s;
	}
	
	public abstract boolean isOpenedByContext(Context context);
	public abstract State executeTranstion(Context context, ContextEvent event);

	
	public State getTargetState() {
		return targetState;
	}
	
}
