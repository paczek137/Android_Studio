package com.example.paczek.paczek;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {

    private static String[] voivodeships;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        voivodeships = getResources().getStringArray(R.array.voivodeships);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                //android.R.layout.simple_list_item_1, voivodeships);
                R.layout.simple_list_item_1_white,voivodeships);
        final ListView listView = (ListView) findViewById(R.id.listView);

        TextView header = new TextView(this);
        header.setTextSize(25);
        header.setTextColor(Color.parseColor("#975a5a"));
        //header.setTextColor(0xff975a5a); // the same result as above
        header.setText("List of voivodeships");
        header.setTypeface(header.getTypeface(), Typeface.BOLD);

        listView.addHeaderView(header);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object listItem = parent.getItemAtPosition(position);
                if (listItem != null) {
                    Toast.makeText(getBaseContext(), id + 1 + ". " + listItem.toString(),
                            Toast.LENGTH_SHORT).show();
                }
/*
                if (position != 0) {
                    TextView textView = (TextView) view;
                    Toast.makeText(getBaseContext(), id + 1 + ". " + textView.getText(),
                            Toast.LENGTH_SHORT).show();
                }
                */ // the same as above
            }
        });
    }
}
