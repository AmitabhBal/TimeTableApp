package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AttendanceCalc extends AppCompatActivity {
    TextView txt1 ,txt2;
    TextView txt11 ,txt12 ,txt13;
    TextView txt21,txt22 ,txt23 ;
    TextView txt31 ,txt32 ,txt33;
    TextView txt41 ,txt42,txt43 ;

    EditText in1 ,in2 ;

    Button submit;

    int pres = 0,tot = 0; float perc;

    public void puttablevalues()
    {
        txt11.setText(String.valueOf(percent(0,0)));
        txt12.setText(String.valueOf(percent(1,1)));
        txt13.setText(String.valueOf(percent(2,2)));
        txt21.setText(String.valueOf(percent(0,0)));
        txt22.setText(String.valueOf(percent(1,1)));
        txt23.setText(String.valueOf(percent(1,2)));
        txt31.setText(String.valueOf(percent(0,0)));
        txt32.setText(String.valueOf(percent(0,1)));
        txt33.setText(String.valueOf(percent(0,2)));
        txt41.setText(String.valueOf(percent(0,0)));
        txt42.setText(String.valueOf(percent(0,1)));
        txt43.setText(String.valueOf(percent(1,2)));
    }

    public float percent(int i, int j)
    {
        int p=pres,t=tot;
        p+=i;
        t+=j;
        Double d = new Double((p/(t*1.0))*100);
        perc=d.floatValue();
        return perc;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_calc);

        txt1 = findViewById(R.id.textView1);txt2 = findViewById(R.id.textView2);
        txt11 = findViewById(R.id.txt11);txt12 = findViewById(R.id.txt12);txt13 = findViewById(R.id.txt13);
        txt21 = findViewById(R.id.txt21);txt22 = findViewById(R.id.txt22);txt23 = findViewById(R.id.txt23);
        txt31 = findViewById(R.id.txt31);txt32 = findViewById(R.id.txt32);txt33 = findViewById(R.id.txt33);
        txt41 = findViewById(R.id.txt41);txt42 = findViewById(R.id.txt42);txt43 = findViewById(R.id.txt43);

        in1 = findViewById(R.id.edit1);in2 = findViewById(R.id.edit2);

        submit = findViewById(R.id.but1);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pres = Integer.parseInt(in2.getText().toString());
                tot = Integer.parseInt(in1.getText().toString());
                puttablevalues();
            }
        });

        txt1.setText("Total Days:");
        txt2.setText("Days Present:");

    }
}