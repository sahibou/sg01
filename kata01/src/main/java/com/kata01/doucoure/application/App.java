package com.kata01.doucoure.application;

import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import com.kata01.doucoure.DFA.StateLevel;
import com.kata01.doucoure.DFA.game.GameContext;
import com.kata01.doucoure.DFA.match.MatchContext;
import com.kata01.doucoure.DFA.set.SetContext;

import jline.console.ConsoleReader;

public class App {

	public static void main(String args[]) throws IOException {

		ConsoleReader consolereader = new ConsoleReader();

		GameContext c = new GameContext();
		SetContext s = new SetContext();
		MatchContext m = new MatchContext();

		GameObserverReferee gameObsRobot = new GameObserverReferee();
		SetObserverReferee setObsRobot = new SetObserverReferee();
		MatchObserverReferee matchObsRobot = new MatchObserverReferee();

		c.addObserver(gameObsRobot);
		c.addObserver(s);

		s.addObserver(setObsRobot);
		s.addObserver(m);

		m.addObserver(matchObsRobot);

		Scanner inputReader = new Scanner(System.in);

		System.out.println("Please first  player's name");
		String mario = inputReader.nextLine();
		System.out.println("Please second player's name");
		String luigi = inputReader.nextLine();

		while (m.getP1score() != 3 && m.getP2score() != 3
				//m.getActiveState().getLevel()!=StateLevel.finalstate
				) {
			String scorer = inputReader.nextLine();
			if (scorer.equals("a"))
				c.p1scores();
			if (scorer.equals("b"))
				c.p2scores();

			consolereader.clearScreen();
			consolereader.flush();

			System.out.println("Player 1 : " + mario);
			System.out.println("Player 2 : " + luigi);
			System.out.println("Current game  status:" + gameObsRobot.getStatus());
			System.out.println("Current match status:" + matchObsRobot.getStatus()+" "+setObsRobot.getStatus());

		}

	}
}
