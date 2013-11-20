/*
 * Joachim Grüneis
 * Copyright (C) 2013
 * All rights reserved.
 */
package at.grueneis.spengergasse.lesson_plan.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * "template pattern"
 */
public abstract class AbstractDatabaseDao<T> implements DatabaseDao<T> {

    private final Connection connection;

    private PreparedStatement findAllStatement;

    private PreparedStatement findByIdStatement;

    public AbstractDatabaseDao(Connection connection) {
        this.connection = connection;
    }

    protected Connection connection() {
        try {
            if (connection == null) {
                throw new IllegalStateException("Connection must not be null");
            }
            if (connection.isClosed()) {
                throw new IllegalStateException("Connection must not be closed");
            }
        } catch (SQLException e) {
            throw new LessonPlanDataAccessException("Failed to validate connection", e);
        }
        return connection;
    }

    private PreparedStatement findAllStatement() {
        try {
            if (findAllStatement == null) {
                StringBuffer statementText = new StringBuffer();
                statementText.append("SELECT ");
                statementText.append(columnList());
                statementText.append(" FROM ");
                statementText.append(tableName());
                findAllStatement = connection().prepareStatement(statementText.toString());
            }
            return findAllStatement;

        } catch (SQLException e) {
            throw new LessonPlanDataAccessException("Failed to create find all statement", e);
        }
    }

    private PreparedStatement findByIdStatement() {
        try {
            if (findByIdStatement == null) {
                StringBuffer statementText = new StringBuffer();
                statementText.append("SELECT ");
                statementText.append(columnList());
                statementText.append(" FROM ");
                statementText.append(tableName());
                statementText.append(" WHERE ");
                statementText.append(idColumneName()).append(" = ? ");
                findByIdStatement = connection().prepareStatement(statementText.toString());
            }
            return findByIdStatement;

        } catch (SQLException e) {
            throw new LessonPlanDataAccessException("Failed to create find by id statement", e);
        }
    }

    protected abstract String idColumneName();

    protected abstract String[] otherColumnNames();

    protected abstract String columnList();

    protected abstract String tableName();

    protected abstract T bind(ResultSet resultSet);

    @Override
    public final List<T> findAll() {
        try {
            List<T> entities = new ArrayList<>();
            PreparedStatement statement = findAllStatement();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                entities.add(bind(resultSet));
            }
            resultSet.close();
            return entities;
        } catch (SQLException e) {
            throw new LessonPlanDataAccessException("Failed to fetch all entities", e);
        }
    }

    @Override
    public final T findById(Long id) {
        try {
            PreparedStatement findByIdStatment = findByIdStatement();
            findByIdStatment.setLong(1, id);
            ResultSet resultSet = findByIdStatment.executeQuery();
            if (!resultSet.next()) {
                throw new LessonPlanDataAccessException("Exact match didn't return data");
            }
            T entity = bind(resultSet);
            if (resultSet.next()) {
                throw new LessonPlanDataAccessException("Exact returned more then one row");
            }
            return entity;
        } catch (SQLException e) {
            throw new LessonPlanDataAccessException("Failed at findById query", e);
        }
    }

    @Override
    public void save(T t) {
        // To change body of implemented methods use File | Settings | File
        // Templates.
    }

    @Override
    public void delete(T t) {
        // To change body of implemented methods use File | Settings | File
        // Templates.
    }

    @Override
    public void delete(Long id) {
        // To change body of implemented methods use File | Settings | File
        // Templates.
    }

    @Override
    public Long count() {
        return null; // To change body of implemented methods use File |
        // Settings | File Templates.
    }
}
