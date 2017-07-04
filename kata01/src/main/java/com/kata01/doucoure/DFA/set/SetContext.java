package com.kata01.doucoure.DFA.set;

import java.util.Observable;

import com.kata01.doucoure.DFA.Context;
import com.kata01.doucoure.DFA.ContextEvent;
import com.kata01.doucoure.DFA.State;
import com.kata01.doucoure.DFA.StateLevel;
import com.kata01.doucoure.DFA.Transition;
import com.kata01.doucoure.DFA.game.GameContext;

public class SetContext extends Context {

	public SetContext() {
		this.referenceDFA = SetDFABuilder.buildDFA();
		// By convention, initial step is the first step added
		for (State s : referenceDFA.getStates())
			if (s.getLevel() == StateLevel.initialstate)
				activeState = s;
	}

	// Additional fields needed
	private int p1score=0;// scored games
	private int p2score=0;// scored games

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

	@Override
	public void update(Observable o, Object arg) {
		GameContext c = (GameContext) o;
		if (c.getP1score() == 4)
			p1scores();
		if (c.getP2score() == 4)
			p2scores();
	}

	@Override
	public String toString() {
		StringBuilder sb01 = new StringBuilder();
		sb01.append("(");
		sb01.append(getP1score());
		sb01.append("-");
		sb01.append(getP2score());
		sb01.append(")");
		return sb01.toString();
	}
}
