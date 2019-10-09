package com.example.heal;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;





public class selfDiease extends Fragment implements android.widget.CompoundButton.OnCheckedChangeListener{



    CheckBox selfDiabtes;
    CheckBox selfGastationalDiabetes;
    CheckBox selfHighBloodPressure;
    CheckBox selfCoronaryAryeryDicease;
    CheckBox selfCardiacArrhythmias;
    CheckBox selfHighCholesterol;
    CheckBox selfGout;
    CheckBox selfPolycysticOvarianSyndrome;
    CheckBox selfDeliveredOverweightBaby;
    CheckBox selfBloodSugarProblemDuringDietry;


    static SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";

    public static final String s_selfDiabtes = "selfDiabtes";
    public static final String s_selfGastationalDiabetes = "selfGastationalDiabetes";
    public static final String s_selfHighBloodPressure = "selfHighBloodPressure";
    public static final String s_selfCoronaryAryeryDicease = "selfCoronaryAryeryDicease";
    public static final String s_selfCardiacArrhythmias = "selfCardiacArrhythmias";
    public static final String s_selfHighCholesterol = "selfHighCholesterol";
    public static final String s_selfGout = "selfGout";
    public static final String s_selfPolycysticOvarianSyndrome = "selfPolycysticOvarianSyndrome";
    public static final String s_selfDeliveredOverweightBaby = "selfDeliveredOverweightBaby";
    public static final String s_selfBloodSugarProblemDuringDietry = "selfBloodSugarProblemDuringDietry";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {





        return inflater.inflate(R.layout.fragment_self_diease, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        sharedpreferences= this.getActivity().getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        //View view = inflater.inflate(R.layout.fragment_self_diease, container, false);

        Log.i("INFO", "HERE");
        //Log.i("INFO", selfDiabtes);
        selfDiabtes  = view.findViewById(R.id.selfDiabetes);
        selfGastationalDiabetes = view.findViewById(R.id.selfGastationalDiabetes);
        selfHighBloodPressure = view.findViewById(R.id.selfHighBloodPressure);
        selfCoronaryAryeryDicease = view.findViewById(R.id.selfCoronaryAryeryDicease);
        selfCardiacArrhythmias = view.findViewById(R.id.selfCardiacArrhythmias);
        selfHighCholesterol = view.findViewById(R.id.selfHighCholesterol);
        selfGout = view.findViewById(R.id.selfGout);
        selfPolycysticOvarianSyndrome = view.findViewById(R.id.selfPolycysticOvarianSyndrome);
        selfDeliveredOverweightBaby = view.findViewById(R.id.selfDeliveredOverweightBaby);
        selfBloodSugarProblemDuringDietry = view.findViewById(R.id.selfBloodSugarProblemDuringDietry);

        //selfDiabtes.setOnCheckedChangeListener(selfDiease.this);













        //selfDiabtes.setChecked(true);

        selfDiabtes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                Log.i("INFO", "dd changed");
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_selfDiabtes, isChecked);
                editor.commit();



            }
        });



        selfGastationalDiabetes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_selfGastationalDiabetes, isChecked);
                editor.commit();

            }
        });



        selfHighBloodPressure.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_selfHighBloodPressure, isChecked);
                editor.commit();
            }
        });


        selfCoronaryAryeryDicease.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_selfCoronaryAryeryDicease, isChecked);
                editor.commit();

            }
        });


        selfCardiacArrhythmias.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_selfCardiacArrhythmias, isChecked);
                editor.commit();

            }
        });


        selfHighCholesterol.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_selfHighCholesterol, isChecked);
                editor.commit();

            }
        });


        selfGout.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_selfGout, isChecked);
                editor.commit();
            }
        });


        selfPolycysticOvarianSyndrome.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_selfPolycysticOvarianSyndrome, isChecked);
                editor.commit();

            }
        });


        selfDeliveredOverweightBaby.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_selfDeliveredOverweightBaby, isChecked);
                editor.commit();

            }
        });


        selfBloodSugarProblemDuringDietry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_selfBloodSugarProblemDuringDietry, isChecked);


            }
        });



        if(sharedpreferences.contains(s_selfDiabtes)) {
            selfDiabtes.setChecked(sharedpreferences.getBoolean(s_selfDiabtes, false));
        } else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_selfDiabtes, false);
            editor.commit();
        }

        if(sharedpreferences.contains(s_selfGastationalDiabetes)) {
            selfGastationalDiabetes.setChecked(sharedpreferences.getBoolean(s_selfGastationalDiabetes, false));
        } else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_selfGastationalDiabetes, false);
            editor.commit();
        }

        if(sharedpreferences.contains(s_selfHighBloodPressure)) {
            selfHighBloodPressure.setChecked(sharedpreferences.getBoolean(s_selfHighBloodPressure, false));
        } else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_selfHighBloodPressure, false);
            editor.commit();
        }

        if(sharedpreferences.contains(s_selfCoronaryAryeryDicease)) {
            selfCoronaryAryeryDicease.setChecked(sharedpreferences.getBoolean(s_selfCoronaryAryeryDicease, false));
        } else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_selfCoronaryAryeryDicease, false);
            editor.commit();
        }

        if(sharedpreferences.contains(s_selfCardiacArrhythmias)) {
            selfCardiacArrhythmias.setChecked(sharedpreferences.getBoolean(s_selfCardiacArrhythmias, false));
        } else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_selfCardiacArrhythmias, false);
            editor.commit();
        }

        if(sharedpreferences.contains(s_selfHighCholesterol)) {
            selfHighCholesterol.setChecked(sharedpreferences.getBoolean(s_selfHighCholesterol, false));
        } else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_selfHighCholesterol, false);
            editor.commit();
        }

        if(sharedpreferences.contains(s_selfGout)) {
            selfGout.setChecked(sharedpreferences.getBoolean(s_selfGout, false));
        } else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_selfGout, false);
            editor.commit();
        }

        if(sharedpreferences.contains(s_selfPolycysticOvarianSyndrome)) {
            selfPolycysticOvarianSyndrome.setChecked(sharedpreferences.getBoolean(s_selfPolycysticOvarianSyndrome, false));
        } else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_selfPolycysticOvarianSyndrome, false);
            editor.commit();
        }

        if(sharedpreferences.contains(s_selfDeliveredOverweightBaby)) {
            selfDeliveredOverweightBaby.setChecked(sharedpreferences.getBoolean(s_selfDeliveredOverweightBaby, false));
        } else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_selfDeliveredOverweightBaby, false);
            editor.commit();
        }

        if(sharedpreferences.contains(s_selfBloodSugarProblemDuringDietry)) {
            selfBloodSugarProblemDuringDietry.setChecked(sharedpreferences.getBoolean(s_selfBloodSugarProblemDuringDietry, false));
        } else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_selfBloodSugarProblemDuringDietry, false);
            editor.commit();
        }
    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        // checkbox status is changed from uncheck to checked.


        SharedPreferences.Editor editor = sharedpreferences.edit();
        switch (buttonView.getId()){

            case R.id.selfDiabetes:
                Log.i("INFO", "dd changed");

                editor.putBoolean(s_selfDiabtes, isChecked);
                editor.commit();
                break;
            case R.id.selfGastationalDiabetes:

                editor.putBoolean(s_selfGastationalDiabetes, isChecked);
                editor.commit();
                break;


        }

        if (!isChecked) {
            // show password

        } else {
            // hide password

        }
    }
}


