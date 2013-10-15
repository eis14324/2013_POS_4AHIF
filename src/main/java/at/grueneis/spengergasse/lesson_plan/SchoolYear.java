package at.grueneis.spengergasse.lesson_plan;

import java.util.Date;

public class SchoolYear {
	private String name;
	private Date start;
	private Date end;

	public String getName() {
		return name;
	}

	public Date getStart() {
		return (Date) start.clone();
	}
}
