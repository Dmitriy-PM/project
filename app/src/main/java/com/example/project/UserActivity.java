package com.example.project;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project_new.R;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        db.execSQL("create table if not exists users (name TEXT, age INTEGER)");
        db.execSQL("insert into users values ('Tom Smith', 23);");
        db.execSQL("insert into users values ('Tom Smith', 23);");
        db.execSQL("insert into users values ('Tom Smith', 23);");
        db.execSQL("insert into users values ('Tom Smith', 23);");

        Cursor query = db.rawQuery("select * from users;", null);
        TextView textView = findViewById(R.id.textView);
        if (query.moveToFirst()) {
            do {
                String name = query.getString(0);
                int age = query.getInt(1);
                textView.append("Имя: " + name + " Возраст: " + age + "\n");
            }
            while(query.moveToNext());
        }
        query.close();
        db.close();
    }
}
