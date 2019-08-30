package com.example.project;

import android.provider.BaseColumns;

public class DB {
    private DB() {
    }

    public static class Deviation implements BaseColumns {
        public static final String TABLE_NAME = "deviation";
        public static final String COLUMN_FOUNDED_DATE = "date";
        public static final String COLUMN_DESCRIPTION = "description";

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_FOUNDED_DATE + " TEXT" + ")";
    }
}
