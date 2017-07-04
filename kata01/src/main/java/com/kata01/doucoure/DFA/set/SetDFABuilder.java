package com.kata01.doucoure.DFA.set;

import com.kata01.doucoure.DFA.Context;
import com.kata01.doucoure.DFA.ContextEvent;
import com.kata01.doucoure.DFA.DFA;
import com.kata01.doucoure.DFA.State;
import com.kata01.doucoure.DFA.StateLevel;
import com.kata01.doucoure.DFA.Transition;

public class SetDFABuilder {
	public static DFA buildDFA() {
		DFA dfa = new DFA();
		// states
		State ongo = new SetState(StateLevel.initialstate);
		State p1ws = new SetState(StateLevel.finalstate);
		State p2ws = new SetState(StateLevel.finalstate);

		Transition t_ongo_p1ws = new Transition(p1ws) {
			@Override
			public boolean isOpenedByContext(Context context) {
				SetContext ctx = (SetContext) context;// TODO replace
				return ctx.getP1score() >= 6 && ctx.getP1score() > ctx.getP2score() +1;
			}

			@Override
			public State executeTranstion(Context context, ContextEvent event) {
				context.setActiveState(this.getTargetState());/// TODO Auto-generated method stub
				System.err.println("TRANSITION : ONGO > P1WS");
				return this.getTargetState();
			}
		};

		Transition t_ongo_p2ws = new Transition(p2ws) {
			@Override
			public boolean isOpenedByContext(Context context) {
				SetContext ctx = (SetContext) context;// TODO replace
				return ctx.getP2score() >= 6 && ctx.getP2score() > ctx.getP1score() +1;
			}

			@Override
			public State executeTranstion(Context context, ContextEvent event) {
				context.setActiveState(this.getTargetState());/// TODO Auto-generated method stub
				System.err.println("TRANSITION : ONGO > P2WS");
				return this.getTargetState();
			}
		};

		ongo.addTransition(t_ongo_p1ws).addTransition(t_ongo_p2ws);

		dfa.addState(ongo).addState(p1ws).addState(p2ws);

		return dfa;
	}
}