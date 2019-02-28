package com.example.akshay.svitbonafide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DisplayBonafide extends AppCompatActivity {

    TextView txt1,txt2;
    String statement1,statement2;

    Button dateB;

    String MrMiss,Fname,Gender,CYear,Dept,Year,Reason,Date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_bonafide);

        txt1 = findViewById(R.id.displayText);
        txt2 = findViewById(R.id.nextText);

        dateB = findViewById(R.id.Datebutton);

        Intent i = getIntent();
        MrMiss = i.getStringExtra("PREFIX");
        Fname = i.getStringExtra("NAME");
        Gender = i.getStringExtra("GENDER");
        CYear = i.getStringExtra("C_YEAR");
        Dept = i.getStringExtra("DEPARTMENT");
        Year = i.getStringExtra("YEAR");
        Reason = i.getStringExtra("REASON");
        Date = i.getStringExtra("DATE");


        statement1 = "This is to certify that "+MrMiss+" "+Fname+" is a bonafide student of this college. "+Gender+"" +
                " studying in "+CYear+" Course in "+Dept+" Engineering during the year "+Year+".";


        statement2 = "This certificate is issue on own request for purpose of "+Reason+".";

        dateB.setText(Date);
        txt1.setText(statement1);
        txt2.setText(statement2);

    }
}
