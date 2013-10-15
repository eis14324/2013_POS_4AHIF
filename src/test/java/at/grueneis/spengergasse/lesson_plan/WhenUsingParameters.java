package at.grueneis.spengergasse.lesson_plan;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;

@RunWith(JUnitParamsRunner.class)
public class WhenUsingParameters {
	@Test(expected = IllegalArgumentException.class)
	@Parameters
	public void testMe(String firstName, String lastName) {
		new Person(firstName, lastName);
	}

	@SuppressWarnings("unused")
	private Object[] parametersForTestMe() {
		return $(//
				$(null, "Meier"), //
				$("Franz", null));
	}
}

class Person {
	private String firstName;
	private String lastName;

	public Person(String firstName, String lastName) {
		if (firstName == null)
			throw new IllegalArgumentException();
		if (lastName == null)
			throw new IllegalArgumentException();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
