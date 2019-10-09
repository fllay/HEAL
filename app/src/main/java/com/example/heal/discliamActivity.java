package com.example.heal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class discliamActivity extends AppCompatActivity {
    private Button cancelBt;
    private Button okBt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discliam);

        cancelBt = (Button) findViewById(R.id.disclaim_cancel);;

        cancelBt.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                //do what you want here
                Intent ganesh = new Intent(discliamActivity.this, MainActivity.class);
                startActivity(ganesh);
            }
        });


        okBt = (Button) findViewById(R.id.disclaim_ok);;

        okBt.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                //do what you want here
                Intent regI = new Intent(discliamActivity.this, createNewAccountActivity.class);
                startActivity(regI);
            }
        });


    }
}
