package com.example.akshay.svitbonafide;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Spinner MrMiss,HeShe,FeSete,dept,year;
    Button submit,dateOfDay;
    EditText StudName,purpose;

    String Prefix,StudentName,Gender,CurrentYear,Department,Year,reason,Date;


    int day,month,yar;
    //String number[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"};
    String gender[] = {"Gender","He","She"};
    String prefix[] = {"Mr.","Miss."};
    String fese[] = {"FE","SE","TE","BE"};
    String department[] = {"Computer","Chemical","Electrical","ETC","IT","MBA","Mechanical"};
    String learning_year[] = {"2015 - 2016","2016 - 2017","2017 - 2018","2018 - 2019","2019 - 2020"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MrMiss = findViewById(R.id.MrMissSpinner);
        HeShe = findViewById(R.id.heSheSpinner);
        FeSete = findViewById(R.id.FeSeTeYear);
        dept = findViewById(R.id.deptSpinner);
        year = findViewById(R.id.yearSpinner);

        submit = findViewById(R.id.submitbuttn);
        dateOfDay = findViewById(R.id.getDatebutton);
        StudName = findViewById(R.id.studentNameEdit);
        purpose = findViewById(R.id.purposeEditText);



        ArrayAdapter<String> mrMiss = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,prefix);
        MrMiss.setAdapter(mrMiss);

        ArrayAdapter<String> genderAdapetr = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,gender);
        HeShe.setAdapter(genderAdapetr);

        ArrayAdapter<String> fesete = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,fese);
        FeSete.setAdapter(fesete);

        ArrayAdapter<String> Depart = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,department);
        dept.setAdapter(Depart);

        ArrayAdapter<String> yearAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,learning_year);
        year.setAdapter(yearAdapter);



        dateOfDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDate();
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Prefix = MrMiss.getSelectedItem().toString();
               StudentName = StudName.getText().toString();
               Gender = HeShe.getSelectedItem().toString();
               CurrentYear = FeSete.getSelectedItem().toString();
               Department = dept.getSelectedItem().toString();
               Year = year.getSelectedItem().toString();
               reason = purpose.getText().toString();
               Date = dateOfDay.getText().toString();



                Intent i = new Intent(MainActivity.this,DisplayBonafide.class);
                i.putExtra("PREFIX",Prefix);
                i.putExtra("NAME",StudentName);
                i.putExtra("GENDER",Gender);
                i.putExtra("C_YEAR",CurrentYear);
                i.putExtra("DEPARTMENT",Department);
                i.putExtra("YEAR",Year);
                i.putExtra("REASON",reason);
                i.putExtra("DATE",Date);
                startActivity(i);

            }
        });

    }

    public void getDate()
    {

        Calendar c = Calendar.getInstance();
        day = c.get(Calendar.DAY_OF_MONTH);
        month = c.get(Calendar.MONTH);
        yar = c.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dateOfDay.setText(day+" / "+(month+1)+" / "+yar);
            }
        },day,month,yar);
        datePickerDialog.show();

    }
}
