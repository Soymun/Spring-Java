package com.edu.ulab.app.SQL;

public final class BookSQL {

    public static final String INSERT_SQL = "INSERT INTO BOOK(TITLE, AUTHOR, PAGE_COUNT, USER_ID) VALUES (?,?,?,?)";
    public static final String UPDATE_SQL = "UPDATE BOOK SET title = ?, author=?, page_count=?, user_id=? WHERE id=?";
    public static final String SELECT_SQL = "SELECT * FROM book WHERE id=?";
    public static final String SELECT_USER_ID_SQL = "SELECT * FROM book WHERE user_id=?";
    public static final String DELETE_SQL = "DELETE FROM BOOK WHERE id = ?";
}
