package com.kata01.doucoure.DFA.game;

import com.kata01.doucoure.DFA.Context;
import com.kata01.doucoure.DFA.ContextEvent;
import com.kata01.doucoure.DFA.DFA;
import com.kata01.doucoure.DFA.State;
import com.kata01.doucoure.DFA.StateLevel;
import com.kata01.doucoure.DFA.Transition;

public class GameDFABuilder {
	public static DFA buildDFA() {
		DFA dfa = new DFA();
		// states
		State ongo = new GameState(StateLevel.initialstate);
		State deus = new GameState(StateLevel.intermediatestate);
		State p1wg = new GameState(StateLevel.finalstate);
		State p2wg = new GameState(StateLevel.finalstate);

		Transition t_ongo_p1wg = new Transition(p1wg) {
			@Override
			public boolean isOpenedByContext(Context context) {
				GameContext ctx = (GameContext) context;// TODO replace
				return ctx.getP1score() == 4 && ctx.getP2score() < 3;
			}

			@Override
			public State executeTranstion(Context context, ContextEvent event) {
				context.setActiveState(this.getTargetState());/// TODO Auto-generated method stub
				System.err.println("TRANSITION : ONGO > P1WG");
				return this.getTargetState();
			}
		};

		Transition t_ongo_p2wg = new Transition(p2wg) {
			@Override
			public boolean isOpenedByContext(Context context) {
				GameContext ctx = (GameContext) context;// TODO replace
				return ctx.getP2score() == 4 && ctx.getP1score() < 3;
			}

			@Override
			public State executeTranstion(Context context, ContextEvent event) {
				context.setActiveState(this.getTargetState());/// TODO Auto-generated method stub
				System.err.println("TRANSITION : ONGO > P2WG");
				return this.getTargetState();
			}
		};

		Transition t_ongo_deus = new Transition(deus) {
			@Override
			public boolean isOpenedByContext(Context context) {
				GameContext ctx = (GameContext) context;// TODO replace
				return ctx.getP2score() == 3 && ctx.getP1score() == 3;
			}

			@Override
			public State executeTranstion(Context context, ContextEvent event) {
				context.setActiveState(this.getTargetState());/// TODO Auto-generated method stub
				System.err.println("TRANSITION : ONGO > DEUS");
				return this.getTargetState();
			}
		};

		Transition t_deus_p1wg = new Transition(p1wg) {
			@Override
			public boolean isOpenedByContext(Context context) {
				GameContext ctx = (GameContext) context;// TODO replace
				return ctx.getP2score() + 2 == ctx.getP1score();
			}

			@Override
			public State executeTranstion(Context context, ContextEvent event) {
				context.setActiveState(this.getTargetState());/// TODO Auto-generated method stub
				System.err.println("TRANSITION : DEUS > P1WG");
				return this.getTargetState();
			}
		};

		Transition t_deus_p2wg = new Transition(p2wg) {
			@Override
			public boolean isOpenedByContext(Context context) {
				GameContext ctx = (GameContext) context;// TODO replace
				return ctx.getP2score() == ctx.getP1score() + 2;
			}

			@Override
			public State executeTranstion(Context context, ContextEvent event) {
				context.setActiveState(this.getTargetState());/// TODO Auto-generated method stub
				System.err.println("TRANSITION : DEUS > P2WG");
				return this.getTargetState();
			}
		};

		ongo.addTransition(t_ongo_deus).addTransition(t_ongo_p1wg).addTransition(t_ongo_p2wg);

		deus.addTransition(t_deus_p1wg).addTransition(t_deus_p2wg);

		dfa.addState(ongo).addState(deus).addState(p1wg).addState(p2wg);

		return dfa;
	}
}