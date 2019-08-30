package com.example.project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBSQLiteHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "sample_database";

    public DBSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DB.Deviation.CREATE_TABLE);
        sqLiteDatabase.execSQL("INSERT INTO deviation VALUES ('Нарушаются требования безопасности труда и промышленной санитарии', '29.08.2019');");
        sqLiteDatabase.execSQL("INSERT INTO deviation VALUES ('Не документированы (не выполняются) процедуры погрузочно-разгрузочных работ, " +
                "хранения, упаковки, консервации и поставок', '05.08.2019');");
        sqLiteDatabase.execSQL("INSERT INTO deviation VALUES ('Не осуществляются корректирующие и предупреждающие мероприятия по " +
                "результатам проведения внутренних проверок', '01.08.2019');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB.Deviation.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
