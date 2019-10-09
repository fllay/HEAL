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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link familyDicease.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link familyDicease#newInstance} factory method to
 * create an instance of this fragment.
 */
public class familyDicease extends Fragment {


    CheckBox familyDiabtes;
    CheckBox familyGastationalDiabetes;
    CheckBox familyHighBloodPressure;
    CheckBox familyCoronaryAryeryDicease;
    CheckBox familyCardiacArrhythmias;
    CheckBox familyHighCholesterol;
    CheckBox familyGout;
    CheckBox familyPolycysticOvarianSyndrome;
    CheckBox familyDeliveredOverweightBaby;
    CheckBox familyBloodSugarProblemDuringDietry;


    static SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";

    public static final String s_familyDiabtes = "familyDiabtes";
    public static final String s_familyGastationalDiabetes = "familyGastationalDiabetes";
    public static final String s_familyHighBloodPressure = "familyHighBloodPressure";
    public static final String s_familyCoronaryAryeryDicease = "familyCoronaryAryeryDicease";
    public static final String s_familyCardiacArrhythmias = "familyCardiacArrhythmias";
    public static final String s_familyHighCholesterol = "familyHighCholesterol";
    public static final String s_familyGout = "familyGout";
    public static final String s_familyPolycysticOvarianSyndrome = "familyPolycysticOvarianSyndrome";
    public static final String s_familyDeliveredOverweightBaby = "familyDeliveredOverweightBaby";
    public static final String s_familyBloodSugarProblemDuringDietry = "familyBloodSugarProblemDuringDietry";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_family_dicease, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        sharedpreferences= this.getActivity().getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        //View view = inflater.inflate(R.layout.fragment_family_diease, container, false);

        Log.i("INFO", "HERE");
        //Log.i("INFO", familyDiabtes);
        familyDiabtes  = view.findViewById(R.id.familyDiabetes);
        familyGastationalDiabetes = view.findViewById(R.id.familyGastationalDiabetes);
        familyHighBloodPressure = view.findViewById(R.id.familyHighBloodPressure);
        familyCoronaryAryeryDicease = view.findViewById(R.id.familyCoronaryAryeryDicease);
        familyCardiacArrhythmias = view.findViewById(R.id.familyCardiacArrhythmias);
        familyHighCholesterol = view.findViewById(R.id.familyHighCholesterol);
        familyGout = view.findViewById(R.id.familyGout);
        familyPolycysticOvarianSyndrome = view.findViewById(R.id.familyPolycysticOvarianSyndrome);
        familyDeliveredOverweightBaby = view.findViewById(R.id.familyDeliveredOverweightBaby);
        familyBloodSugarProblemDuringDietry = view.findViewById(R.id.familyBloodSugarProblemDuringDietry);

        //familyDiabtes.setOnCheckedChangeListener(familyDiease.this);


        //familyDiabtes.setChecked(true);



        familyDiabtes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                Log.i("INFO", "dd changed");
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_familyDiabtes, isChecked);
                editor.commit();



            }
        });



        familyGastationalDiabetes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_familyGastationalDiabetes, isChecked);
                editor.commit();

            }
        });



        familyHighBloodPressure.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_familyHighBloodPressure, isChecked);
                editor.commit();
            }
        });


        familyCoronaryAryeryDicease.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_familyCoronaryAryeryDicease, isChecked);
                editor.commit();

            }
        });


        familyCardiacArrhythmias.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_familyCardiacArrhythmias, isChecked);
                editor.commit();

            }
        });


        familyHighCholesterol.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_familyHighCholesterol, isChecked);
                editor.commit();

            }
        });


        familyGout.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_familyGout, isChecked);
                editor.commit();
            }
        });


        familyPolycysticOvarianSyndrome.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_familyPolycysticOvarianSyndrome, isChecked);
                editor.commit();

            }
        });


        familyDeliveredOverweightBaby.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_familyDeliveredOverweightBaby, isChecked);
                editor.commit();

            }
        });


        familyBloodSugarProblemDuringDietry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_familyBloodSugarProblemDuringDietry, isChecked);
                editor.commit();

            }
        });



        if(sharedpreferences.contains(s_familyDiabtes)) {
            familyDiabtes.setChecked(sharedpreferences.getBoolean(s_familyDiabtes, false));
        } else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_familyDiabtes, false);
            editor.commit();
        }

        if(sharedpreferences.contains(s_familyDiabtes)) {
            familyGastationalDiabetes.setChecked(sharedpreferences.getBoolean(s_familyGastationalDiabetes, false));
        }else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_familyDiabtes, false);
            editor.commit();
        }

        if(sharedpreferences.contains(s_familyHighBloodPressure)) {
            familyHighBloodPressure.setChecked(sharedpreferences.getBoolean(s_familyHighBloodPressure, false));
        }else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_familyHighBloodPressure, false);
            editor.commit();
        }

        if(sharedpreferences.contains(s_familyCoronaryAryeryDicease)) {
            familyCoronaryAryeryDicease.setChecked(sharedpreferences.getBoolean(s_familyCoronaryAryeryDicease, false));
        }else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_familyCoronaryAryeryDicease, false);
            editor.commit();
        }

        if(sharedpreferences.contains(s_familyCardiacArrhythmias)) {
            familyCardiacArrhythmias.setChecked(sharedpreferences.getBoolean(s_familyCardiacArrhythmias, false));
        }else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_familyCardiacArrhythmias, false);
            editor.commit();
        }

        if(sharedpreferences.contains(s_familyHighCholesterol)) {
            familyHighCholesterol.setChecked(sharedpreferences.getBoolean(s_familyHighCholesterol, false));
        }else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_familyHighCholesterol, false);
            editor.commit();
        }

        if(sharedpreferences.contains(s_familyGout)) {
            familyGout.setChecked(sharedpreferences.getBoolean(s_familyGout, false));
        }else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_familyGout, false);
            editor.commit();
        }

        if(sharedpreferences.contains(s_familyPolycysticOvarianSyndrome)) {
            familyPolycysticOvarianSyndrome.setChecked(sharedpreferences.getBoolean(s_familyPolycysticOvarianSyndrome, false));
        }else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_familyPolycysticOvarianSyndrome, false);
            editor.commit();
        }

        if(sharedpreferences.contains(s_familyDeliveredOverweightBaby)) {
            familyDeliveredOverweightBaby.setChecked(sharedpreferences.getBoolean(s_familyDeliveredOverweightBaby, false));
        }else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_familyDeliveredOverweightBaby, false);
            editor.commit();
        }

        if(sharedpreferences.contains(s_familyBloodSugarProblemDuringDietry)) {
            familyBloodSugarProblemDuringDietry.setChecked(sharedpreferences.getBoolean(s_familyBloodSugarProblemDuringDietry, false));
        }else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_familyBloodSugarProblemDuringDietry, false);
            editor.commit();
        }
    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        // checkbox status is changed from uncheck to checked.


        SharedPreferences.Editor editor = sharedpreferences.edit();
        switch (buttonView.getId()){

            case R.id.familyDiabetes:
                Log.i("INFO", "dd changed");

                editor.putBoolean(s_familyDiabtes, isChecked);
                editor.commit();
                break;
            case R.id.familyGastationalDiabetes:

                editor.putBoolean(s_familyGastationalDiabetes, isChecked);
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
