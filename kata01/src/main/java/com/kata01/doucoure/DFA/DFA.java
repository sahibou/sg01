package com.kata01.doucoure.DFA;

import java.util.ArrayList;
import java.util.List;

//No behavior > no interface
public class DFA {

	protected List<State> states=new ArrayList<>();

	/**
	 * 
	 * @param s new state (first step added is the initial step)
	 * @return this object to be able to chain the calls
	 */
	public DFA addState(State s) {
		states.add(s);
		return this;
	}

	/**
	 * By convention, first step added is initial step
	 * @return State list
	 */
	public List<State> getStates() {
		return states;
	}
	
	
}
