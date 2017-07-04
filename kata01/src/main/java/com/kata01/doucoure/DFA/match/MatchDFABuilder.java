package com.kata01.doucoure.DFA.match;

import com.kata01.doucoure.DFA.Context;
import com.kata01.doucoure.DFA.ContextEvent;
import com.kata01.doucoure.DFA.DFA;
import com.kata01.doucoure.DFA.State;
import com.kata01.doucoure.DFA.StateLevel;
import com.kata01.doucoure.DFA.Transition;

public class MatchDFABuilder {
	public static DFA buildDFA() {
		DFA dfa = new DFA();
		// states
		State ongo = new MatchState(StateLevel.initialstate);
		State p1wm = new MatchState(StateLevel.finalstate);
		State p2wm = new MatchState(StateLevel.finalstate);

		Transition t_ongo_p1wm = new Transition(p1wm) {
			@Override
			public boolean isOpenedByContext(Context context) {
				MatchContext ctx = (MatchContext) context;// TODO replace
				return ctx.getP1score() == 3;
			}

			@Override
			public State executeTranstion(Context context, ContextEvent event) {
				context.setActiveState(this.getTargetState());/// TODO Auto-generated method stub
				System.err.println("TRANSITION : ONGO > P1WM");
				return this.getTargetState();
			}
		};

		Transition t_ongo_p2wm = new Transition(p2wm) {
			@Override
			public boolean isOpenedByContext(Context context) {
				MatchContext ctx = (MatchContext) context;// TODO replace
				return ctx.getP2score() == 3;
			}

			@Override
			public State executeTranstion(Context context, ContextEvent event) {
				context.setActiveState(this.getTargetState());/// TODO Auto-generated method stub
				System.err.println("TRANSITION : ONGO > P2WM");
				return this.getTargetState();
			}
		};

		ongo.addTransition(t_ongo_p1wm).addTransition(t_ongo_p2wm);

		dfa.addState(ongo).addState(p1wm).addState(p2wm);

		return dfa;
	}
}