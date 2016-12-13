package chapter33;

import java.util.EnumMap;
import java.util.Map;

public enum Transition {
	MELT(Phase.SOLID, Phase.LIQUID), FREEZE(Phase.LIQUID, Phase.SOLID), BOIL(Phase.LIQUID, Phase.GAS), CONDENSE(
			Phase.GAS, Phase.LIQUID), SUBLIME(Phase.SOLID, Phase.GAS), DEPOSIT(Phase.GAS, Phase.SOLID);

	private final Phase src;
	private final Phase dst;

	Transition(Phase src, Phase dst) {
		this.src = src;
		this.dst = dst;
	}

	// 二重 Map
	private static final Map<Phase, Map<Phase, Transition>> MAP = new EnumMap<>(Phase.class);

	// static 初期化。
	static {
		for (Phase phase : Phase.values()) {
			// まずは、Phase の列挙値(SOLID,LIQUID,GAS)を全て put。
			MAP.put(phase, new EnumMap<>(Phase.class));
		}
		for (Transition transition : Transition.values()) {
			// Phase に対する遷移先の Phase と Transition の EnumMap を put。
			// 例えば、SOLID に対して、遷移先の LIQUID と状態の MELT の EnumMap を put。
			Phase phase = transition.src;
			Map<Phase, Transition> map = MAP.get(phase);
			map.put(transition.dst, transition);
		}
	}

	public static Transition from(Phase src, Phase dst) {
		// 例: src: SOLID, dst: LIQUID => MELT
		return MAP.get(src).get(dst);
	}
}
