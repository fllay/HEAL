package com.example.heal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ekn.gruzer.gaugelibrary.HalfGauge;
import com.ekn.gruzer.gaugelibrary.Range;

public class appMainActivity extends AppCompatActivity {

    private HalfGauge halfGauge;
    private Button logoutBt;
    private Button healthHistory;
    private Button mainResultBT;
    public static final String mypreference = "mypref";
    public static final String Firsname = "Firsname";
    public static final String Lastname = "Lastname";
    public static final String Email = "Email";
    public static final String Telnumber = "Telnumber";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_main);

        final SharedPreferences sharedpreferences;
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        Log.i("INFO", sharedpreferences.getString(Firsname, ""));
        Log.i("INFO", sharedpreferences.getString(Lastname, ""));
        Log.i("INFO", sharedpreferences.getString(Email, ""));
        Log.i("INFO", sharedpreferences.getString(Telnumber, ""));

        halfGauge = (HalfGauge) findViewById(R.id.halfGauge);
        logoutBt = (Button) findViewById(R.id.main_logout);
        healthHistory = (Button) findViewById(R.id.main_healt_history);
        mainResultBT = findViewById(R.id.main_result);


        Range range1 = new Range();
        range1.setColor(Color.parseColor("#9CFF33"));
        range1.setFrom(0.0);
        range1.setTo(2.0);
        Range range2 = new Range();
        range2.setColor(Color.parseColor("#FFF033"));
        range2.setFrom(2.0);
        range2.setTo(4.0);
        Range range3 = new Range();
        range3.setColor(Color.parseColor("#FFCA33"));
        range3.setFrom(4.0);
        range3.setTo(6.0);
        Range range4 = new Range();
        range4.setColor(Color.parseColor("#FFA533"));
        range4.setFrom(6.0);
        range4.setTo(8.0);
        Range range5 = new Range();
        range5.setColor(Color.parseColor("#FF5733"));
        range5.setFrom(8.0);
        range5.setTo(10.0);


        //add color ranges to gauge
        halfGauge.addRange(range1);
        halfGauge.addRange(range2);
        halfGauge.addRange(range3);
        halfGauge.addRange(range4);
        halfGauge.addRange(range5);


        //set min max and current value
        halfGauge.setMinValue(0.0);
        halfGauge.setMaxValue(10.0);
        halfGauge.setValue(5.0);



        logoutBt.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                //do what you want here
                Intent regI = new Intent(appMainActivity.this, MainActivity.class);
                startActivity(regI);
            }
        });


        healthHistory.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                //do what you want here
                Intent regI = new Intent(appMainActivity.this, healthHistoryActivity.class);
                startActivity(regI);
            }
        });

        mainResultBT.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                //do what you want here
                Intent regI = new Intent(appMainActivity.this, evaluationResultsActivity.class);
                startActivity(regI);
            }
        });
    }
}
