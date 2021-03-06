package com.stir.cscu9t4practical1;

public class SwimEntry extends Entry{
	
	protected String location = "";

	public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String location) {
		super(n, d, m, y, h, min, s, dist);
		this.location = location;
		// TODO Auto-generated constructor stub
	}
	
	
	// We need to override the getEntry() as that says "ran" in it
	public String getEntry () {
		String result = getName()+" swam " + getDistance() +" km " +getWhere()+ " in "
				+getHour()+":"+getMin()+":"+ getSec() + " on "
				+getDay()+"/"+getMonth()+"/"+getYear()+"\n";
		return result;
	} //getEntry

	public String getWhere() {
		return location;
	}//getWhere
  
	public void setWhere(String loc) {
		this.location = loc;
	}//setWhere
}