package com.example.android.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class main extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    Button pilih;
    private int day, month, year;
    private String currentDateString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pilih = (Button)findViewById(R.id.choose);
        pilih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go=new Intent(main.this,halamandetail.class);
                go.putExtra("currentDateString",currentDateString);
                go.putExtra("day",day);
                go.putExtra("month",month);
                go.putExtra("year",year);
                startActivity(go);
            }
        });
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        //Toast.makeText(this, dayOfMonth+"-"+month+"-"+year, Toast.LENGTH_SHORT).show();
        this.day = dayOfMonth;
        this.month = month;
        this.year = year;
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(currentDateString);
    }
}
