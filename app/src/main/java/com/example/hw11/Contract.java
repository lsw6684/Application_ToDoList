package com.example.hw11;

public class Contract {
    private Contract() {
    }

    public static final String TABLE_NAME = "todo_list";
    public static final String COL_LEC_NAME = "todo_name";

    public static final String SQL_CREATE_TBL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " " +
            "(" +
            COL_LEC_NAME +      " CHAR(20) PRIMARY KEY)" +
            ")";    //=CREATE TABLE IF NOT EXISTS todo_list (todo_name CHAR(20) PRIMARY KEY) >> for 유지보수

    public static final String SQL_DROP_TBL = "DROP TABLE IF EXISTS " + TABLE_NAME;
    public static final String SQL_SELECT = "SELECT * FROM " + TABLE_NAME;

    public static final String SQL_INSERT = "INSERT OR REPLACE INTO " + TABLE_NAME + " " +
            "(" + COL_LEC_NAME + ") VALUES ";
    public static final String SQL_DELETED = "DELETE FROM " + TABLE_NAME + " WHERE " + COL_LEC_NAME + " = ";

}
