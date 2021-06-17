package com.aky.tables;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> table;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView myList = (ListView) findViewById(R.id.listview);
        EditText num = (EditText) findViewById(R.id.numberView);
        num.setText("2");
        table = new ArrayList<String>();
        tablefxn(2);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, table);
        myList.setAdapter(arrayAdapter);
        SeekBar number = (SeekBar) findViewById(R.id.seekBar);
        number.setMin(1);
        number.setMax(100);
        number.setProgress(2);
        number.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tablefxn(progress);
                num.setText(Integer.toString(progress));
                myList.setAdapter(arrayAdapter);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        num.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (num.getText().toString() != null && !num.getText().toString().equals("") && !num.getText().toString().equals(" ")) {
                    tablefxn(Integer.parseInt(num.getText().toString()));
                    myList.setAdapter(arrayAdapter);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    public void tablefxn(int n) {
        table.clear();
        for (int x = 1; x <= 100; x++) {
            table.add(n + " \t X \t " + x + " \t = \t " + (x * n));
        }
    }
}