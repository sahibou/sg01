package com.kata01.doucoure.DFA;

import java.util.ArrayList;
import java.util.List;

public abstract class State {

	protected List<Transition> transitions=new ArrayList<>();
	
	private StateLevel level;
	public State(StateLevel statelevel) {
		level=statelevel;
	}
	
	
	public StateLevel getLevel() {
		return level;
	}


	/**
	 * 
	 * @param t new transition
	 * @return this object to be able to chain the calls
	 */
	public State addTransition(Transition t) {
		this.transitions.add(t);
		return this;
	}

	public List<Transition> getTransitions() {
		return transitions;
	}
	
}
