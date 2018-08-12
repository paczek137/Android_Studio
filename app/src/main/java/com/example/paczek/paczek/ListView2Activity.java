package com.example.paczek.paczek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListView2Activity extends AppCompatActivity {

    private static String[] voivodeships;
    private static ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);

        voivodeships = getResources().getStringArray(R.array.voivodeships);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_checked, voivodeships);

        listView = (ListView) findViewById(R.id.listView);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setTextFilterEnabled(true);
        listView.setAdapter(adapter);
    }

    public void OnShowSelectedItems(View view) {
        String selectedItems = "Selected items: \n";
        for (int i=0; i<listView.getCount(); i++) {
            if (listView.isItemChecked(i)) {
                selectedItems += listView.getItemAtPosition(i) + "\n";
            }
        }
        Toast.makeText(this, selectedItems, Toast.LENGTH_SHORT).show();
    }
}
