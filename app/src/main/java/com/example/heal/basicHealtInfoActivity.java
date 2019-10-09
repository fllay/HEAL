package com.example.heal;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class basicHealtInfoActivity extends AppCompatActivity {
    static EditText birthDayText;
    static EditText weightText;
    static EditText heightText;
    static EditText waistText;
    static RadioGroup sex;
    static RadioButton MaleR;
    static RadioButton FemaleR;
    final Calendar myCalendar = Calendar.getInstance();
    private int mYear, mMonth, mDay, mHour, mMinute;
    public static final String mypreference = "mypref";
    public static final String Sex = "Sex";
    public static final String Age = "Age";
    public static final String DOB = "DOB";
    public static final String Height = "Height";
    public static final String Weight = "Weight";
    public static final String Waist = "Waist";

    static SharedPreferences sharedpreferences;
    private dataScheme dd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_healt_info);

        dd = new dataScheme(basicHealtInfoActivity.this);

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        weightText = findViewById(R.id.basic_weight);
        heightText = findViewById(R.id.basic_height);
        waistText = findViewById(R.id.basic_waist);

        MaleR = (RadioButton)findViewById(R.id.basic_male);
        FemaleR = (RadioButton)findViewById(R.id.basic_female);

        weightText.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                Log.i("INFO", s.toString());
                try {
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putFloat(Weight, Float.parseFloat(s.toString()));
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


        heightText.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                Log.i("INFO", s.toString());
                try{
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putFloat(Height, Float.parseFloat(s.toString()));
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


        waistText.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                Log.i("INFO", s.toString());
                try{
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putFloat(Waist, Float.parseFloat(s.toString()));
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


        sex = (RadioGroup) this.findViewById ( R.id.basic_sex );
        sex.setOnCheckedChangeListener ( new RadioGroup.OnCheckedChangeListener () {
            public void onCheckedChanged ( RadioGroup group, int checkedId )
            {
                RadioButton checkedRadio = (RadioButton) basicHealtInfoActivity.this.findViewById ( checkedId );


                String checkedText = checkedRadio.getText ( ).toString ( );
                String ss = "Male";
                if( checkedText.equals("ชาย")){
                    ss = "Male";
                }else if(checkedText.equals("หญิง")){
                    ss = "Female";
                }
                Log.i("INFO", checkedText);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(Sex, ss);
                editor.commit();
                //Toast toast = Toast.makeText ( basicHealtInfoActivity.this, "Checked " + ss, Toast.LENGTH_LONG );

                //toast.show ( );
            }
        });

        birthDayText = findViewById(R.id.basicHealthInfoBirthDay);

        birthDayText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTruitonDatePickerDialog(v);
            }
        });


        /*saveBt.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                //do what you want here
                SharedPreferences.Editor editor = sharedpreferences.edit();

                try {
                    editor.putFloat(Weight, Float.parseFloat(weightText.getText().toString()));

                    editor.putFloat(Height, Float.parseFloat(heightText.getText().toString()));
                    editor.putFloat(Waist, Float.parseFloat(waistText.getText().toString()));
                } catch (Exception e) {

                }
                editor.commit();
                Intent regI = new Intent(basicHealtInfoActivity.this, appMainActivity.class);
                startActivity(regI);
            }
        });*/



        if(sharedpreferences.contains(Height)){
            heightText.setText(String.valueOf(sharedpreferences.getFloat(Height,0)));
        }

        if(sharedpreferences.contains(Weight)){
            weightText.setText(String.valueOf(sharedpreferences.getFloat(Weight,0)));
        }

        if(sharedpreferences.contains(Waist)){
            waistText.setText(String.valueOf(sharedpreferences.getFloat(Waist,0)));
        }

        if(sharedpreferences.contains(DOB)){
            birthDayText.setText(sharedpreferences.getString(DOB,"MM/dd/yy"));
        }


        if(sharedpreferences.contains(Sex)){
            String ss = sharedpreferences.getString(Sex,"Male");



            if( ss.equals("Male")){
                MaleR.setChecked(true);
                FemaleR.setChecked(false);

            }else if(ss.equals("Female")){
                FemaleR.setChecked(true);
                MaleR.setChecked(false);
            }
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

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        birthDayText.setText(sdf.format(myCalendar.getTime()));
    }



    public void showTruitonDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public static class DatePickerFragment extends DialogFragment implements
            DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            final Calendar c = Calendar.getInstance();
            int yearNow = c.get(Calendar.YEAR);
            int age = yearNow - year;

            SharedPreferences.Editor editor = sharedpreferences.edit();
            String dob = day + "/" + (month + 1) + "/" + year;
            editor.putInt(Age, age);
            editor.putString(DOB, dob);
            editor.commit();
            Log.i("INFO", String.valueOf(age));
            birthDayText.setText(dob);
        }
    }
}
