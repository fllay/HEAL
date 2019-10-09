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
import android.widget.RadioButton;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link diceaseHT.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link diceaseHT#newInstance} factory method to
 * create an instance of this fragment.
 */
public class diceaseHT extends Fragment {


    CheckBox selfLHV;
    CheckBox selfProteinuria;
    CheckBox selfAtherosclerotic;
    CheckBox selfRetinapathy;
    CheckBox selfPVD;
    RadioButton selfCKD1;
    RadioButton selfCKD2;
    RadioButton selfCKD3;
    RadioButton selfCKD4;

    static SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";

    public static final String s_selfLHV = "selfLHV";
    public static final String s_selfProteinuria = "selfProteinuria";
    public static final String s_selfAtherosclerotic = "selfAtherosclerotic";
    public static final String s_selfRetinapathy = "selfRetinapathy";
    public static final String s_selfPVD = "selfPVD";
    public static final String s_selfCKD1 = "selfCKD1";
    public static final String s_selfCKD2 = "selfCKD2";
    public static final String s_selfCKD3 = "selfCKD3";
    public static final String s_selfCKD4 = "selfCKD4";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {





        return inflater.inflate(R.layout.fragment_dicease_ht, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        sharedpreferences= this.getActivity().getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        //View view = inflater.inflate(R.layout.fragment_self_diease, container, false);

        Log.i("INFO", "HERE");
        //Log.i("INFO", selfDiabtes);



        selfLHV = view.findViewById(R.id.self_LVH);
        selfProteinuria = view.findViewById(R.id.self_proteinuria);
        selfAtherosclerotic = view.findViewById(R.id.self_atherosclerotic);
        selfRetinapathy = view.findViewById(R.id.self_retinopathy);
        selfPVD = view.findViewById(R.id.self_PVD);
        selfCKD1 = view.findViewById(R.id.self_ckd1);
        selfCKD2 = view.findViewById(R.id.self_ckd2);
        selfCKD3 = view.findViewById(R.id.self_ckd3);
        selfCKD4 = view.findViewById(R.id.self_ckd4);



        //selfDiabtes.setOnCheckedChangeListener(selfDiease.this);


        //selfDiabtes.setChecked(true);

        selfLHV.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                Log.i("INFO", "dd changed");
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_selfLHV, isChecked);
                editor.commit();



            }
        });



        selfProteinuria.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_selfProteinuria, isChecked);
                editor.commit();

            }
        });



        selfAtherosclerotic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_selfAtherosclerotic, isChecked);
                editor.commit();
            }
        });


        selfRetinapathy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_selfRetinapathy, isChecked);
                editor.commit();

            }
        });


        selfPVD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_selfPVD, isChecked);
                editor.commit();

            }
        });


        selfCKD1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_selfCKD1, isChecked);
                editor.commit();

            }
        });


        selfCKD2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_selfCKD2, isChecked);
                editor.commit();
            }
        });


        selfCKD3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_selfCKD3, isChecked);
                editor.commit();

            }
        });


        selfCKD4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(s_selfCKD4, isChecked);
                editor.commit();

            }
        });






        if(sharedpreferences.contains(s_selfLHV)) {
            selfLHV.setChecked(sharedpreferences.getBoolean(s_selfLHV, false));
        } else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_selfLHV, false);
            editor.commit();
        }

        if(sharedpreferences.contains(s_selfProteinuria)) {
            selfProteinuria.setChecked(sharedpreferences.getBoolean(s_selfProteinuria, false));
        } else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_selfProteinuria, false);
            editor.commit();
        }

        if(sharedpreferences.contains(s_selfAtherosclerotic)) {
            selfAtherosclerotic.setChecked(sharedpreferences.getBoolean(s_selfAtherosclerotic, false));
        } else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_selfAtherosclerotic, false);
            editor.commit();
        }

        if(sharedpreferences.contains(s_selfRetinapathy)) {
            selfRetinapathy.setChecked(sharedpreferences.getBoolean(s_selfRetinapathy, false));
        } else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_selfRetinapathy, false);
            editor.commit();
        }

        if(sharedpreferences.contains(s_selfPVD)) {
            selfPVD.setChecked(sharedpreferences.getBoolean(s_selfPVD, false));
        } else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_selfPVD, false);
            editor.commit();
        }

        if(sharedpreferences.contains(s_selfCKD1)) {
            selfCKD1.setChecked(sharedpreferences.getBoolean(s_selfCKD1, false));
        } else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_selfCKD1, false);
            editor.commit();
        }

        if(sharedpreferences.contains(s_selfCKD2)) {
            selfCKD2.setChecked(sharedpreferences.getBoolean(s_selfCKD2, false));
        } else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_selfCKD2, false);
            editor.commit();
        }

        if(sharedpreferences.contains(s_selfCKD3)) {
            selfCKD3.setChecked(sharedpreferences.getBoolean(s_selfCKD3, false));
        } else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_selfCKD3, false);
            editor.commit();
        }

        if(sharedpreferences.contains(s_selfCKD4)) {
            selfCKD4.setChecked(sharedpreferences.getBoolean(s_selfCKD4, false));
        } else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(s_selfCKD4, false);
            editor.commit();
        }


    }


}
