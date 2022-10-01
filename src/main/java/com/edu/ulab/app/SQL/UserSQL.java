package com.edu.ulab.app.SQL;

public final class UserSQL {

    public static final String INSERT_SQL = "INSERT INTO PERSON(FULL_NAME, TITLE, AGE) VALUES (?,?,?)";
    public static final String UPDATE_SQL = "UPDATE PERSON SET full_name = ?, title=?, age=? WHERE id=?";
    public static final String SELECT_SQL = "SELECT * FROM person WHERE id=?";
    public static final String DELETE_SQL = "DELETE FROM person WHERE id = ?";
}
