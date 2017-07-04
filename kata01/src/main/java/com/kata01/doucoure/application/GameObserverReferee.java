package com.kata01.doucoure.application;

import java.util.Observable;
import java.util.Observer;

import com.kata01.doucoure.DFA.game.GameContext;
import com.kata01.doucoure.DFA.game.GameHelper;

public class GameObserverReferee implements Observer {

	private String status;

	public String getStatus() {
		return status;
	}

	@Override
	public void update(Observable o, Object arg) {

		GameContext c = (GameContext) arg;
		if (c.getP1score() == 3 && c.getP2score() == 3) {
			// deuce
			status = "deuce";
		} else {
			// score
			status = GameHelper.NormalGameFormatOf(c.getP1score()) + " "
					+ GameHelper.NormalGameFormatOf(c.getP2score());

		}
	}

}
