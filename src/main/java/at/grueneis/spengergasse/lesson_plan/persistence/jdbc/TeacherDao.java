/*
 * Joachim Grüneis
 * Copyright (C) 2013
 * All rights reserved.
 */
package at.grueneis.spengergasse.lesson_plan.persistence.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import at.grueneis.spengergasse.lesson_plan.domain.Teacher;

/**
 *
 */
public class TeacherDao extends AbstractDatabaseDao<Teacher> {

    public TeacherDao(Connection connection) {
        super(connection);
    }

    @Override
    protected String idColumneName() {
        return "id";
    }

    @Override
    protected String[] otherColumnNames() {
        return new String[0]; // To change body of implemented methods use File
                              // | Settings | File Templates.
    }

    @Override
    protected String columnList() {
        return "id, firstname, lastname";
    }

    @Override
    protected String tableName() {
        return "teachers";
    }

    @Override
    protected Teacher bind(ResultSet resultSet) {
        try {
            Long id = resultSet.getLong("id");
            String firstname = resultSet.getString("firstname");
            if (resultSet.wasNull()) {
                /// firstname was null
            }
            String lastname = resultSet.getString("lastname");
            if (resultSet.wasNull()) {
                /// lastname was null
            }
            return new Teacher(id, firstname, lastname, null, null);
        } catch (SQLException e) {
            throw new LessonPlanDataAccessException(
                    "Failed at binding teacher", e);
        }
    }
}
