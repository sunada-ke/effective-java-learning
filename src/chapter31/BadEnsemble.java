package chapter31;

public enum BadEnsemble {
	SOLO, DUET, TRIO, QUARTET, QUINTET, SEXTET, SEPTET, OCTET, NONET, DECTET;

	// グループのメンバーの数を返す
	public int numberOfMusicians() {
		return ordinal() + 1;
	}
}