package com.kata01.doucoure.DFA.game;

import java.util.Observable;

import com.kata01.doucoure.DFA.Context;
import com.kata01.doucoure.DFA.ContextEvent;
import com.kata01.doucoure.DFA.State;
import com.kata01.doucoure.DFA.StateLevel;
import com.kata01.doucoure.DFA.Transition;

public class GameContext extends Context {

	public GameContext() {
		this.referenceDFA = GameDFABuilder.buildDFA();
		//By convention, initial step is the first step added
		for(State s : referenceDFA.getStates())
			if(s.getLevel()==StateLevel.initialstate) activeState=s;
	}
	
	//Additional fields needed
	private int p1score=0;
	private int p2score=0;
	private short serviceHolder=1;	
	
	//internal

	public void p1scores() {
		if(serviceHolder==1) {
			p1score++;
			acceptEvent(ContextEvent.p1scoresGame);
		}else {
			serviceHolder=1;
		}
	}
	public void p2scores() {
		if(serviceHolder==2) {
			p2score++;
			acceptEvent(ContextEvent.p2scoresGame);
		}else {
			serviceHolder=2;
		}
	}
	

	@Override
	public void reinitContext() {
		p1score=0;
		p2score=0;
		serviceHolder=1;
		
		for(State s : referenceDFA.getStates())
			if(s.getLevel()==StateLevel.initialstate) activeState=s;
	}
	
	public int getP1score() {
		return p1score;
	}
	public int getP2score() {
		return p2score;
	}
	
	/**
	 * Used if the context is monitoring another context
	 */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub		
	}
	
}
