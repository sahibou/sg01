package com.kata01.doucoure.application;

import java.util.Observable;
import java.util.Observer;

import com.kata01.doucoure.DFA.StateLevel;
import com.kata01.doucoure.DFA.match.MatchContext;

public class MatchObserverReferee implements Observer {

	private String status;

	public String getStatus() {
		return status;
	}

	@Override
	public void update(Observable o, Object arg) {

		MatchContext c = (MatchContext) arg;
		status = c.toString();
//		if(c.getActiveState().getLevel().equals(StateLevel.finalstate))
//			status="MatchOver";
	}

}
