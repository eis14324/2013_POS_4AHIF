/*
 * Joachim Grüneis
 * Copyright (C) 2013
 * All rights reserved.
 */
package at.grueneis.spengergasse.lesson_plan.domain;

import java.io.Serializable;
import java.util.Date;

public class Teacher extends BasePersistable implements Serializable {
    private static final long serialVersionUID = 2052070897330839212L;

    private final String firstName;
    private final String lastname;
    private final Date birthdate;
    private final String email;

    public Teacher(Long id, String firstName, String lastname, Date birthdate,
            String email) {
        this.setId(id);
        this.firstName = firstName;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.email = email;
    }

    public Teacher(String firstName, String lastname, Date birthdate,
            String email) {
        this(null, firstName, lastname, birthdate, email);
    }

    public String getName() {
        return String.format("%s %s", firstName, lastname);
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[id=" + getId() + "firstName="
                + firstName + ", lastname=" + lastname + ", birthdate="
                + birthdate + ", email=" + email + "]";
    }
}
