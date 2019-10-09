package com.example.heal;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class bloodTestActivity extends AppCompatActivity {
    static EditText bloodUpper;
    static EditText bloodLower;
    static EditText serumLipidProfile;
    static EditText choresterol;
    static EditText LDL;
    static EditText HDL;
    static EditText TG;
    static EditText fastingBloodGlucose;
    static EditText uricAcid;

    static SharedPreferences sharedpreferences;

    public static final String mypreference = "mypref";
    public static final String s_bloodUpper = "bloodUpper";
    public static final String s_bloodLower = "bloodLower";
    public static final String s_serumLipidProfile = "serumLipidProfile";

    public static final String s_choresterol = "choresterol";
    public static final String s_LDL = "LDL";
    public static final String s_HDL = "HDL";

    public static final String s_TG = "TG";
    public static final String s_fastingBloodGlucose = "fastingBloodGlucose";
    public static final String s_uricAcid = "uricAcid";

    private dataScheme dd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_test);
        dd = new dataScheme(bloodTestActivity.this);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        bloodUpper = findViewById(R.id.bloodPressureUpper);
        bloodLower = findViewById(R.id.bloodPressureLower);
        serumLipidProfile = findViewById(R.id.serumLipidProfile);
        choresterol = findViewById(R.id.choresterol);
        LDL = findViewById(R.id.ldl);
        HDL = findViewById(R.id.hdl);
        TG = findViewById(R.id.tg);
        fastingBloodGlucose = findViewById(R.id.fastBloodGlucose);
        uricAcid = findViewById(R.id.uricAcid);



        bloodUpper.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                try {
                Log.i("INFO", s.toString());
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putFloat(s_bloodUpper, Float.parseFloat(s.toString()));
                editor.commit();
            }
                 catch (NumberFormatException e) {

            }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }
        });


        bloodLower.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                Log.i("INFO", s.toString());
                try {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putFloat(s_bloodLower, Float.parseFloat(s.toString()));
                editor.commit();
            }
                 catch (NumberFormatException e) {

            }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }
        });


        serumLipidProfile.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                try{
                Log.i("INFO", s.toString());
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putFloat(s_serumLipidProfile, Float.parseFloat(s.toString()));
                editor.commit();
            }
                 catch (NumberFormatException e) {

            }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }
        });

        choresterol.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                Log.i("INFO", s.toString());
                try {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putFloat(s_choresterol, Float.parseFloat(s.toString()));
                editor.commit();
                }
                catch (NumberFormatException e) {

                }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }
        });

        LDL.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                Log.i("INFO", s.toString());
                try {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putFloat(s_LDL, Float.parseFloat(s.toString()));
                editor.commit();
                }
                catch (NumberFormatException e) {

                }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }
        });

        HDL.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                Log.i("INFO", s.toString());
                try {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putFloat(s_HDL, Float.parseFloat(s.toString()));
                editor.commit();
                }
                catch (NumberFormatException e) {

                }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }
        });

        TG.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                Log.i("INFO", s.toString());
                try {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putFloat(s_TG, Float.parseFloat(s.toString()));
                editor.commit();
                }
                catch (NumberFormatException e) {

                }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }
        });


        fastingBloodGlucose.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                Log.i("INFO", s.toString());
                try {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putFloat(s_fastingBloodGlucose, Float.parseFloat(s.toString()));
                editor.commit();
                }
                catch (NumberFormatException e) {

                }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }
        });

        uricAcid.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                Log.i("INFO", s.toString());
                try {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putFloat(s_uricAcid, Float.parseFloat(s.toString()));
                editor.commit();
                }
                catch (NumberFormatException e) {

                }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }
        });


        if(sharedpreferences.contains(s_bloodUpper)) {
            bloodUpper.setText(String.valueOf(sharedpreferences.getFloat(s_bloodUpper,0)));
        }

        if(sharedpreferences.contains(s_bloodLower)) {
            bloodLower.setText(String.valueOf(sharedpreferences.getFloat(s_bloodLower,0)));
        }

        if(sharedpreferences.contains(s_serumLipidProfile)) {
            serumLipidProfile.setText(String.valueOf(sharedpreferences.getFloat(s_serumLipidProfile,0)));
        }

        if(sharedpreferences.contains(s_choresterol)) {
            choresterol.setText(String.valueOf(sharedpreferences.getFloat(s_choresterol,0)));
        }

        if(sharedpreferences.contains(s_LDL)) {
            LDL.setText(String.valueOf(sharedpreferences.getFloat(s_LDL,0)));
        }

        if(sharedpreferences.contains(s_HDL)) {
            HDL.setText(String.valueOf(sharedpreferences.getFloat(s_HDL,0)));
        }

        if(sharedpreferences.contains(s_TG)) {
            TG.setText(String.valueOf(sharedpreferences.getFloat(s_TG,0)));
        }

        if(sharedpreferences.contains(s_fastingBloodGlucose)) {
            fastingBloodGlucose.setText(String.valueOf(sharedpreferences.getFloat(s_fastingBloodGlucose,0)));
        }

        if(sharedpreferences.contains(s_uricAcid)) {
            uricAcid.setText(String.valueOf(sharedpreferences.getFloat(s_uricAcid,0)));
        }



    }

    @Override
    public void onBackPressed() {
        // Write your code here
        dd.upload();
        super.onBackPressed();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
