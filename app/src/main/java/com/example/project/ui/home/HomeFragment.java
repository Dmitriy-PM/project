package com.example.project.ui.home;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.project.DBSQLiteHelper;
import com.example.project.R;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.employer_list, container, false);

        SQLiteDatabase db = new DBSQLiteHelper(inflater.getContext()).getReadableDatabase();

        Cursor query = db.rawQuery("select * from deviation;", null);
        TextView textViewDeviation = view.findViewById(R.id.descLabel);
        if (query.moveToFirst()){
            do {
                String deviation = query.getString(0);
                String date = query.getString(1);

                textViewDeviation.append(date + " " + deviation + "\n\n");
            }
            while(query.moveToNext());
        }
        query.close();
        db.close();

        return view;
    }
}