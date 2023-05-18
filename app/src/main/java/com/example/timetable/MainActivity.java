package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ListView ttlistview;
    TextView txt;
    private Button button;


    public void allotroom(int num)
    {
        ArrayList<String> Monday = new ArrayList<String>(
                Arrays.asList("B-406: PDC","B-406: COA","B-406: AFL","B-304: DBMS","WL-101: DBMS[L]","WL-101: DBMS[L]"));
        ArrayList<String> Tuesday = new ArrayList<String>(
                Arrays.asList("A-LH-009: AFL","A-LH-009: OS","A-LH-009: DBMS","B-302: COA","B-302: BC[L]","B-302: BC[L]"));
        ArrayList<String> Wednesday = new ArrayList<String>(
                Arrays.asList("B-206: OS","A-DL-108: OS[L]","A-DL-108: OS[L]","B-304: COA","B-304: WT","B-304: PDC"));
        ArrayList<String> Thursday = new ArrayList<String>(
                Arrays.asList("B-406: OS","B-406: COA","B-406: DBMS","B-305: AFL","B-305: PDC","B-305: WT"));
        ArrayList<String> Friday = new ArrayList<String>(
                Arrays.asList("B-204: WT","A-DL-002: WT[L]","A-DL-002: WT[L]","B-303: PDC","B-303: DBMS","B-303: AFL"));
/*
        ArrayList<String> Monday = new ArrayList<String>(
                Arrays.asList("1-2 PM: A-LH-203 ( IT-4 )"));
        ArrayList<String> Tuesday = new ArrayList<String>(
                Arrays.asList("8-9 AM: B-206 ( CSE-14 )","11-12 PM: A-LH-107 ( IT-4 )"));
        ArrayList<String> Wednesday = new ArrayList<String>(
                Arrays.asList("9-10 AM: B-206 ( CSE-14 )","1-2PM: A-LH-204 ( IT-4 )"));
        ArrayList<String> Thursday = new ArrayList<String>(
                Arrays.asList("12-1 PM: B-403 ( CSE-14 )"));
        ArrayList<String> Friday = new ArrayList<String>(
                Arrays.asList("9-10 AM: B-206 ( CSE-14 )","10-11 AM: A-LH-107 ( IT-4 )"));*/

/*      ArrayList<String> Monday = new ArrayList<String>(
                Arrays.asList("9-10 AM: A-LH-004 ( CSE-30 )","11-12 PM: B-201 ( CSE-12 )","12-1 PM: A-DL-008 [L] ( CSE-12 )","1-2 PM: A-DL-008 [L] ( CSE-12 )"));
        ArrayList<String> Wednesday = new ArrayList<String>(
                Arrays.asList("12-1 PM: A-LH-105 ( CSE-30 )","4-5 PM: B-304 ( CSE-21 )"));
        ArrayList<String> Thursday = new ArrayList<String>(
                Arrays.asList("11-12 PM: B-303 ( CSE-30 )","12-1PM: B-401 ( CSE-12 )","5-6 PM: B-305 ( CSE-21 )"));
        ArrayList<String>  Friday= new ArrayList<String>(
                Arrays.asList("8-9 AM: B-205 ( CSE-12 )","11-12 PM: B-204 ( CSE-21 )","12-1 PM: A-DL-002 [L] ( CSE-21 )","1-2 PM: A-DL-002 [L] ( CSE-21 )"));*/

        if (num==0)
        {
            ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Monday);
            ttlistview.setAdapter(adapt);
        }
        if (num==1)
        {
            ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Tuesday);
            ttlistview.setAdapter(adapt);
        }
        if (num==2)
        {
            ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Wednesday);
            ttlistview.setAdapter(adapt);
        }
        if (num==3)
        {
            ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Thursday);
            ttlistview.setAdapter(adapt);
        }
        if (num==4) {
            ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Friday);
            ttlistview.setAdapter(adapt);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.buttend);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAttendanceCalc();
            }
        });

        Date fulltime = Calendar.getInstance().getTime();
        String dayextract = DateFormat.getDateInstance(DateFormat.FULL).format(fulltime);
        String[] todayspl = dayextract.split(",");
        String[] daysofw = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        String today = todayspl[0];
        String[] todate = todayspl[1].split(" ");
        SeekBar ttseek = findViewById(R.id.ttseek);
        txt = findViewById(R.id.txt);

        ttlistview = findViewById(R.id.ttlistview);

        if (today.equals("Saturday")||today.equals("Sunday"))
            txt.setText("Holiday");
        ttseek.setMax(4);
        for (int k = 0; k < 5; k++) {
            if (today.equals(daysofw[k]))
            {
                ttseek.setProgress(k);
                txt.setText(daysofw[k]);
                allotroom(k);
                break;
            }

        }




        ttseek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                txt.setText(daysofw[i]);
                allotroom(i);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    void openAttendanceCalc()
    {
        Intent intent = new Intent(MainActivity.this, AttendanceCalc.class);
        startActivity(intent);
    }
}