package com.aky.tables;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List <Integer> table;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView myList =(ListView)findViewById(R.id.listview);
        table=new ArrayList<Integer>();
        tablefxn(2);
        ArrayAdapter<Integer>arrayAdapter=new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1,table);
        myList.setAdapter(arrayAdapter);
        SeekBar number=(SeekBar)findViewById(R.id.seekBar);
        number.setMin(1);
        number.setMax(1000);
        number.setProgress(2);
        number.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tablefxn(progress);
                myList.setAdapter(arrayAdapter);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
    public void tablefxn(int n){
        table.clear();
        for(int x=1;x<=10;x++){
            table.add(x*n);
        }
    }
}