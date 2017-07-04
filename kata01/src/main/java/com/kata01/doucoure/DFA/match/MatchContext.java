package com.kata01.doucoure.DFA.match;

import java.util.Observable;

import com.kata01.doucoure.DFA.Context;
import com.kata01.doucoure.DFA.ContextEvent;
import com.kata01.doucoure.DFA.State;
import com.kata01.doucoure.DFA.StateLevel;
import com.kata01.doucoure.DFA.set.SetContext;

public class MatchContext extends Context {

	public MatchContext() {
		this.referenceDFA = MatchDFABuilder.buildDFA();
		// By convention, initial step is the first step added
		for (State s : referenceDFA.getStates())
			if (s.getLevel() == StateLevel.initialstate)
				activeState = s;
	}

	// Additional fields needed
	private int p1score;// scored games
	private int p2score;// scored games

	private String matchCurrentResultHolder=new String();
	
	public void p1scores() {
		p1score++;
		acceptEvent(ContextEvent.p1scoresGame);
	}

	public void p2scores() {
		p2score++;
		acceptEvent(ContextEvent.p2scoresGame);
	}

	@Override
	public void reinitContext() {
		p1score = 0;
		p2score = 0;
		matchCurrentResultHolder=new String();
		
		for (State s : referenceDFA.getStates())
			if (s.getLevel() == StateLevel.initialstate)
				activeState = s;
	}

	public int getP1score() {
		return p1score;
	}

	public int getP2score() {
		return p2score;
	}

	/**
	 * MqtchContext is only observing SetContexts..
	 */
	@Override
	public void update(Observable o, Object arg) {
		SetContext s = (SetContext) o;
		if (s.getP1score() == 6)
			p1scores();
		if (s.getP2score() == 6)
			p2scores();
		
		if(s.getP1score() == 6 || s.getP2score() == 6) {
			matchCurrentResultHolder=s.toString().concat(matchCurrentResultHolder);//SetContext toString is the Set result
			setChanged();
			notifyObservers(this); //notify observer for change in the "resultname"
		}
	}

	@Override
	public String toString() {
		return matchCurrentResultHolder;
	}
	
	/**
	 * Only match publishes its finale step to allow EOMatch behavior
	 * @return
	 */
	public State getActiveState() {
		return activeState;
	}

}
