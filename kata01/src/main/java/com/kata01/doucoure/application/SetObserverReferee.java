package com.kata01.doucoure.application;

import java.util.Observable;
import java.util.Observer;

import com.kata01.doucoure.DFA.set.SetContext;

public class SetObserverReferee implements Observer {

	public void zork() {

	}
	private String status;

	public String getStatus() {
		return status;
	}

	@Override
	public void update(Observable o, Object arg) {

		SetContext c = (SetContext) arg;
		status = c.toString();
	}

}
