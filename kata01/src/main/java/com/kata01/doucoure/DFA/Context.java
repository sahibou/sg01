package com.kata01.doucoure.DFA;

import java.util.Observable;
import java.util.Observer;

public abstract class Context extends Observable implements Observer {

	// A context always needs :
	protected DFA referenceDFA;
	protected State activeState;
	protected boolean isEndState;

	/**
	 * 
	 * @return true if the DFA is in its end state (and context should be reloaded)
	 */
	public boolean isEndState() {
		return isEndState;
	}
	
	
	/**
	 * Set active state after transition
	 * @param activeState
	 */
	public void setActiveState(State activeState) {
		this.activeState = activeState;
	}



	/**
	 * (for the current state) Changes current context if a transition is opened
	 * according to the context
	 * 
	 * @param event
	 */
	protected void acceptEvent(ContextEvent event) {
		//Look for a transaction to execute and change context accordingly
		for (Transition t : activeState.getTransitions())
			if (t.isOpenedByContext(this))
				t.executeTranstion(this, event);
						
		//When state is updated then notify observers
		setChanged();
		notifyObservers(this);
		
		//Restart the context if the automata is over (auto restart the automata)
		if(activeState.getLevel()==StateLevel.finalstate)
			reinitContext();
	}

	public abstract void reinitContext();
}
