package chapter33;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 序数インデックスの代わりに EnumMap を使用する
 */
public final class Main {

	// 遷移配列
	private static final BadTransition[][] TRANSITIONS = { { null, BadTransition.MELT, BadTransition.SUBLIME },
			{ BadTransition.FREEZE, null, BadTransition.BOIL },
			{ BadTransition.DEPOSIT, BadTransition.CONDENSE, BadTransition.SUBLIME } };

	public static void main(String[] args) {

		// 配列のインデックスとして Enum の ordinal() を使ってはいけない。
		// 例えば、以下のコードを書いてはいけない。

		// まず、配列とジェネリックスには互換性がない。
		// ジェネリックスの配列を使おうとすると無検査キャストの警告が発生する。
		// 加えて Enum の序数（int 型）でインデックスされているため、型安全性が提供されない。
		// また、配列の要素数以上の int 値を与えると ArrayIndexOutOfBoundsException が発生してしまう。

		// 様々なハーブ
		Herb annualHerb = new Herb("aaa", Herb.Type.Annual);
		Herb biennialHerb = new Herb("bbb", Herb.Type.Biennial);
		Herb perennialHerb = new Herb("ccc", Herb.Type.Perennial);

		// ハーブの配列
		Herb[] herbs = new Herb[] { annualHerb, biennialHerb, perennialHerb };

		// Set の配列を利用。無検査警告が発生する。
		Set<Herb>[] herbsByType = (Set<Herb>[]) new Set[Herb.Type.values().length];
		for (int i = 0; i < herbsByType.length; i++) {
			// ハーブの種類ごとに Set を用意。
			herbsByType[i] = new HashSet<Herb>();
		}

		// ハーブを種類ごとに分類
		for (Herb herb : herbs) {
			// ordinal() を利用して、インデックスに値を追加。
			herbsByType[herb.type.ordinal()].add(herb);
		}

		// 結果を表示。
		for (int i = 0; i < herbsByType.length; i++) {
			Set<Herb> set = herbsByType[i];
			Iterator<Herb> iterator = set.iterator();
			while (iterator.hasNext()) {
				Herb herb = iterator.next();
				System.out.printf("%s: %s%n", Herb.Type.values()[i], herb.name);
			}
		}

		// 配列ではなく、EnumMap を利用する。
		// 本来、ここでは「ハーブの種類の enum からハーブ集合へのマップ」が正しいデータ構造。
		// そのため、配列ではなくマップを利用するべき。
		// Java には Enum をキーとするように設計された非常に高速な Map 実装がある。

		// Herb の配列。
		Herb[] all = new Herb[] { annualHerb, biennialHerb, perennialHerb };

		// EnumMap を利用する。
		Map<Herb.Type, Set<Herb>> map = new EnumMap<>(Herb.Type.class);
		for (Herb.Type type : Herb.Type.values()) {
			// ハーブの種類ごとに Set を用意。
			map.put(type, new HashSet<Herb>());
		}

		// ハーブを種類ごとに分類
		for (Herb herb : all) {
			map.get(herb.type).add(herb);
		}

		// 結果表示。
		for (Entry<Herb.Type, Set<Herb>> entry : map.entrySet()) {
			Herb.Type type = entry.getKey();
			Set<Herb> set = entry.getValue();
			Iterator<Herb> iterator = set.iterator();
			while (iterator.hasNext()) {
				Herb herb = iterator.next();
				System.out.printf("%s: %s%n", type, herb.name);
			}
		}

		// このプログラムはより短く、明瞭で、型安全。
		// EnumMap は内部的には配列を用いて実装されているため、配列バージョンと比較してもパフォーマンス上の遜色はない。
		// EnumMap のコンストラクタはキーの Enum の Class オブジェクトが必要。

		// 表現しようとしている関係が Enum の定数による多次元構造であるなら二重 EnumMap を利用するべき。
		// 物体の状態（気体、液体、固体）と状態変化（凍結、沸騰、など）を関連付ける処理を考えてみる。
		// これを用いて、たとえば「個体」から「気体」になる状態変化を求める。
		BadTransition badTransition = from(Phase.SOLID, Phase.GAS);
		System.out.println(badTransition);

		// これには以下の欠点がある。
		// 1: 定数を追加・削除した際に変更を忘れやすい
		// 2: null のエントリーが増えると空間が無駄になる
		// 3: 表の大きさが Phase の 2 乗になる

		// 以下のように二重の EnumMap として管理するべき。
		Transition transition = Transition.from(Phase.SOLID, Phase.GAS);
		System.out.println(transition);
	}

	private static BadTransition from(Phase src, Phase dst) {
		return TRANSITIONS[src.ordinal()][dst.ordinal()];
	}

}
