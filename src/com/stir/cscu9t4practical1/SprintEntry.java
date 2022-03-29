package com.stir.cscu9t4practical1;

public class SprintEntry extends Entry{
	protected int repetitions = 0;
	protected int recovery = 0;

	public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float km, int repetitions, int recovery) {
		super(n, d, m, y, h, min, s, km);
		this.repetitions = repetitions;
		this.recovery = recovery;
		// TODO Auto-generated constructor stub
	}
	
	//fix getEntry
	public String getEntry () {
		String result = getName()+" sprinted " + getRepetitions() + "x" + Math.round(getDistance()) + "m in "
				+getHour()+":"+getMin()+":"+ getSec() + " with " + getRecovery() + " minutes recovery on "
				+getDay()+"/"+getMonth()+"/"+getYear()+"\n";
		return result;
	} //getEntry
	
	public int getRepetitions() {
		return repetitions;
	}

	public void setRepetitions(int repetitions) {
		this.repetitions = repetitions;
	}

	public int getRecovery() {
		return recovery;
	}

	public void setRecovery(int recovery) {
		this.recovery = recovery;
	}

}
