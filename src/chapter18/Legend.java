package chapter18;

public class Legend implements SingerSongWriter {

	@Override
	public void sing(String song) {
		System.out.println("I sing a " + song);
	}

	@Override
	public String compose() {
		return "Monster Dance";
	}

	@Override
	public void strum() {
		System.out.println("I play a guitar");
	}
}
