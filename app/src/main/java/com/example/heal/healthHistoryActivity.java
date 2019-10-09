package com.example.heal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class healthHistoryActivity extends AppCompatActivity {
    private Button hasicHelathInfoBt;
    private Button bloodTestVt;
    private Button diceaseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_history);






        hasicHelathInfoBt = (Button) findViewById(R.id.basicHealthBt);

        hasicHelathInfoBt.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                //do what you want here
                Intent ganesh = new Intent(healthHistoryActivity.this, basicHealtInfoActivity.class);
                startActivity(ganesh);
            }
        });

        bloodTestVt = (Button) findViewById(R.id.bloodTestBtn);

        bloodTestVt.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                //do what you want here
                Intent ganesh = new Intent(healthHistoryActivity.this, bloodTestActivity.class);
                startActivity(ganesh);
            }
        });


        diceaseBtn = findViewById(R.id.diceaseBtn);

        diceaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                //do what you want here
                Intent ganesh = new Intent(healthHistoryActivity.this, diceasesHistActivity.class);
                startActivity(ganesh);
            }
        });


    }



}
