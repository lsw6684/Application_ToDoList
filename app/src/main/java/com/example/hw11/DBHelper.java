package com.example.hw11;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db = null;
    private static final String DB_NAME = "todo_db";
    private static final int DB_VERSION = 1;
    private static volatile DBHelper instance;

    private DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        if (db == null) {
            db = getWritableDatabase();
        }
    }

    public static DBHelper getInstance(Context context) {
        if (instance == null) {
            synchronized (DBHelper.class) {
                if (instance == null)
                    instance = new DBHelper(context);
                }
            }

        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Contract.SQL_CREATE_TBL);
    }

    //for DB 버젼을 업데이트 할 때
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Contract.SQL_DROP_TBL);
        onCreate(db);
    }

    public void insert(Todo todo) {
        db = getWritableDatabase();
        db.execSQL(Contract.SQL_INSERT + "(" + '"' + todo.getTodoName() + '"' + ")");
        //INSERT OR REPLACE INTO todo_list VALUES ("something", value)
        db.close(); //close를 지양하는게 좋다. 방법 찾아보기.
    }

    public void delete(String title) {
        db = getWritableDatabase();
        db.execSQL(Contract.SQL_DELETED + '"' + title + '"');
        db.close();
    }

    public ArrayList<Todo> getAll(){
        ArrayList<Todo> tmp = new ArrayList<>();
        db = getReadableDatabase();

        Cursor cursor = db.rawQuery(Contract.SQL_SELECT, null);
        //Table, 커서 밑으로 내려가는 거
        while(cursor.moveToNext()){
            String Name = cursor.getString(0);

            Todo data = new Todo(Name);
            tmp.add(data);
        }
        return tmp;
    }
}

