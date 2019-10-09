package com.example.heal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class dataScheme {
    constants const1 = new constants();
    private String URLline = "http://" + const1.address + ":3000/data";
    private String GetURLline = "http://" + const1.address + ":3000/getdata";
    private RequestQueue requestQueue;
    public static final String mypreference = "mypref";
    public static final String Firsname = "Firsname";
    public static final String Lastname = "Lastname";
    public static final String Email = "Email";
    public static final String Telnumber = "Telnumber";
    //Family dicease
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
    //Self dicease
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
    //Blood test
    public static final String s_bloodUpper = "bloodUpper";
    public static final String s_bloodLower = "bloodLower";
    public static final String s_serumLipidProfile = "serumLipidProfile";
    public static final String s_choresterol = "choresterol";
    public static final String s_LDL = "LDL";
    public static final String s_HDL = "HDL";
    public static final String s_TG = "TG";
    public static final String s_fastingBloodGlucose = "fastingBloodGlucose";
    public static final String s_uricAcid = "uricAcid";
    //Dicease HT
    public static final String s_selfLHV = "selfLHV";
    public static final String s_selfProteinuria = "selfProteinuria";
    public static final String s_selfAtherosclerotic = "selfAtherosclerotic";
    public static final String s_selfRetinapathy = "selfRetinapathy";
    public static final String s_selfPVD = "selfPVD";
    public static final String s_selfCKD1 = "selfCKD1";
    public static final String s_selfCKD2 = "selfCKD2";
    public static final String s_selfCKD3 = "selfCKD3";
    public static final String s_selfCKD4 = "selfCKD4";
    //Basic info
    public static final String Sex = "Sex";
    public static final String Age = "Age";
    public static final String DOB = "DOB";
    public static final String Height = "Height";
    public static final String Weight = "Weight";
    public static final String Waist = "Waist";


    final SharedPreferences sharedpreferences;

    public dataScheme(Context act) {
        requestQueue = Volley.newRequestQueue(act);
        sharedpreferences = act.getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

    }

    public void getData(String email){
        JSONObject postparams = new JSONObject();
        try {

            postparams.put(Email, email);

            Log.i("INFO", postparams.toString());
            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                    GetURLline, postparams,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.i("INFO", response.toString());
                            //Success Callback
                            if (response.length() == 0) {

                            } else {

                                try {
                                    JSONObject resp = response.getJSONObject("docs");

                                    Log.i("INFO", resp.toString());
                                    //SharedPreferences.Editor editor = sharedpreferences.edit();

                                    //editor.commit();

                                    SharedPreferences.Editor editor = sharedpreferences.edit();


                                    editor.putFloat(Weight,(float)resp.getDouble(Weight));
                                    editor.putFloat(Height, (float)resp.getDouble(Height));
                                    editor.putFloat(Waist, (float)resp.getDouble(Waist));
                                    editor.putString(Sex, resp.getString(Sex));
                                    editor.putInt(Age, resp.getInt(Age));
                                    editor.putString(DOB, resp.getString(DOB));


                                    editor.putFloat(s_bloodUpper, (float)resp.getDouble(s_bloodUpper));
                                    editor.putFloat(s_bloodLower, (float)resp.getDouble(s_bloodLower));
                                    editor.putFloat(s_serumLipidProfile, (float)resp.getDouble(s_serumLipidProfile));
                                    editor.putFloat(s_choresterol, (float)resp.getDouble(s_choresterol));
                                    editor.putFloat(s_LDL, (float)resp.getDouble(s_LDL));
                                    editor.putFloat(s_HDL, (float)resp.getDouble(s_HDL));
                                    editor.putFloat(s_TG, (float)resp.getDouble(s_TG));
                                    editor.putFloat(s_fastingBloodGlucose, (float)resp.getDouble(s_fastingBloodGlucose));
                                    editor.putFloat(s_uricAcid, (float)resp.getDouble(s_uricAcid));



                                    editor.putBoolean(s_selfDiabtes, resp.getBoolean(s_selfDiabtes));
                                    editor.putBoolean(s_selfGastationalDiabetes, resp.getBoolean(s_selfGastationalDiabetes));
                                    editor.putBoolean(s_selfHighBloodPressure, resp.getBoolean(s_selfHighBloodPressure));
                                    editor.putBoolean(s_selfCoronaryAryeryDicease, resp.getBoolean(s_selfCoronaryAryeryDicease));
                                    editor.putBoolean(s_selfCardiacArrhythmias, resp.getBoolean(s_selfCardiacArrhythmias));
                                    editor.putBoolean(s_selfHighCholesterol, resp.getBoolean(s_selfHighCholesterol));
                                    editor.putBoolean(s_selfGout, resp.getBoolean(s_selfGout));
                                    editor.putBoolean(s_selfPolycysticOvarianSyndrome, resp.getBoolean(s_selfPolycysticOvarianSyndrome));
                                    editor.putBoolean(s_selfDeliveredOverweightBaby, resp.getBoolean(s_selfDeliveredOverweightBaby));
                                    editor.putBoolean(s_selfBloodSugarProblemDuringDietry, resp.getBoolean(s_selfBloodSugarProblemDuringDietry));




                                    editor.putBoolean(s_familyDiabtes, resp.getBoolean(s_familyDiabtes));
                                    editor.putBoolean(s_familyGastationalDiabetes, resp.getBoolean(s_familyGastationalDiabetes));
                                    editor.putBoolean(s_familyHighBloodPressure, resp.getBoolean(s_familyHighBloodPressure));
                                    editor.putBoolean(s_familyCoronaryAryeryDicease, resp.getBoolean(s_familyCoronaryAryeryDicease));
                                    editor.putBoolean(s_familyCardiacArrhythmias, resp.getBoolean(s_familyCardiacArrhythmias));
                                    editor.putBoolean(s_familyHighCholesterol, resp.getBoolean(s_familyHighCholesterol));
                                    editor.putBoolean(s_familyGout, resp.getBoolean(s_familyGout));
                                    editor.putBoolean(s_familyPolycysticOvarianSyndrome, resp.getBoolean(s_familyPolycysticOvarianSyndrome));
                                    editor.putBoolean(s_familyDeliveredOverweightBaby, resp.getBoolean(s_familyDeliveredOverweightBaby));
                                    editor.putBoolean(s_familyBloodSugarProblemDuringDietry, resp.getBoolean(s_familyBloodSugarProblemDuringDietry));



                                    editor.putBoolean(s_selfLHV, resp.getBoolean(s_selfLHV));
                                    editor.putBoolean(s_selfProteinuria, resp.getBoolean(s_selfProteinuria));
                                    editor.putBoolean(s_selfAtherosclerotic, resp.getBoolean(s_selfAtherosclerotic));
                                    editor.putBoolean(s_selfRetinapathy, resp.getBoolean(s_selfRetinapathy));
                                    editor.putBoolean(s_selfPVD, resp.getBoolean(s_selfPVD));
                                    editor.putBoolean(s_selfPVD, resp.getBoolean(s_selfPVD));
                                    editor.putBoolean(s_selfCKD1, resp.getBoolean(s_selfCKD1));
                                    editor.putBoolean(s_selfCKD2, resp.getBoolean(s_selfCKD2));
                                    editor.putBoolean(s_selfCKD3, resp.getBoolean(s_selfCKD3));
                                    editor.putBoolean(s_selfCKD4, resp.getBoolean(s_selfCKD4));




                                    editor.commit();





                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            //Failure Callback
                            Log.i("INFO", "No response");

                        }
                    });

            requestQueue.add(jsonObjReq);
        }
        catch (JSONException e) {
                e.printStackTrace();
            }
    }

    public void upload(){
        JSONObject postparams = new JSONObject();
        try {

            //Basic data

            if(sharedpreferences.contains(Email)) {
                postparams.put(Email, sharedpreferences.getString(Email, ""));
            }

            if(sharedpreferences.contains(Firsname)) {
                postparams.put("firstname", sharedpreferences.getString(Firsname, ""));
            }

            if(sharedpreferences.contains(Lastname)) {
                postparams.put("lastname", sharedpreferences.getString(Lastname, ""));
            }

            if(sharedpreferences.contains(Telnumber)) {
                postparams.put(Telnumber, sharedpreferences.getString(Telnumber, ""));
            }

            //Family dicease

            if(sharedpreferences.contains(s_familyDiabtes)) {
                postparams.put(s_familyDiabtes, sharedpreferences.getBoolean(s_familyDiabtes, false));
            }

            if(sharedpreferences.contains(s_familyGastationalDiabetes)) {
                postparams.put(s_familyGastationalDiabetes, sharedpreferences.getBoolean(s_familyGastationalDiabetes, false));
            }

            if(sharedpreferences.contains(s_familyHighBloodPressure)) {
                postparams.put(s_familyHighBloodPressure, sharedpreferences.getBoolean(s_familyHighBloodPressure, false));
            }

            if(sharedpreferences.contains(s_familyCoronaryAryeryDicease)) {
                postparams.put(s_familyCoronaryAryeryDicease, sharedpreferences.getBoolean(s_familyCoronaryAryeryDicease, false));
            }

            if(sharedpreferences.contains(s_familyCardiacArrhythmias)) {
                postparams.put(s_familyCardiacArrhythmias, sharedpreferences.getBoolean(s_familyCardiacArrhythmias, false));
            }

            if(sharedpreferences.contains(s_familyHighCholesterol)) {
                postparams.put(s_familyHighCholesterol, sharedpreferences.getBoolean(s_familyHighCholesterol, false));
            }

            if(sharedpreferences.contains(s_familyGout)) {
                postparams.put(s_familyGout, sharedpreferences.getBoolean(s_familyGout, false));
            }

            if(sharedpreferences.contains(s_familyPolycysticOvarianSyndrome)) {
                postparams.put(s_familyPolycysticOvarianSyndrome, sharedpreferences.getBoolean(s_familyPolycysticOvarianSyndrome, false));
            }

            if(sharedpreferences.contains(s_familyDeliveredOverweightBaby)) {
                postparams.put(s_familyDeliveredOverweightBaby, sharedpreferences.getBoolean(s_familyDeliveredOverweightBaby, false));
            }

            if(sharedpreferences.contains(s_familyBloodSugarProblemDuringDietry)) {
                postparams.put(s_familyBloodSugarProblemDuringDietry, sharedpreferences.getBoolean(s_familyBloodSugarProblemDuringDietry, false));
            }

            //Self dicease

            if(sharedpreferences.contains(s_selfDiabtes)) {
                postparams.put(s_selfDiabtes, sharedpreferences.getBoolean(s_selfDiabtes, false));
            }

            if(sharedpreferences.contains(s_selfGastationalDiabetes)) {
                postparams.put(s_selfGastationalDiabetes, sharedpreferences.getBoolean(s_selfGastationalDiabetes, false));
            }

            if(sharedpreferences.contains(s_selfHighBloodPressure)) {
                postparams.put(s_selfHighBloodPressure, sharedpreferences.getBoolean(s_selfHighBloodPressure, false));
            }

            if(sharedpreferences.contains(s_selfCoronaryAryeryDicease)) {
                postparams.put(s_selfCoronaryAryeryDicease, sharedpreferences.getBoolean(s_selfCoronaryAryeryDicease, false));
            }

            if(sharedpreferences.contains(s_selfCardiacArrhythmias)) {
                postparams.put(s_selfCardiacArrhythmias, sharedpreferences.getBoolean(s_selfCardiacArrhythmias, false));
            }

            if(sharedpreferences.contains(s_selfHighCholesterol)) {
                postparams.put(s_selfHighCholesterol, sharedpreferences.getBoolean(s_selfHighCholesterol, false));
            }

            if(sharedpreferences.contains(s_selfGout)) {
                postparams.put(s_selfGout, sharedpreferences.getBoolean(s_selfGout, false));
            }

            if(sharedpreferences.contains(s_selfPolycysticOvarianSyndrome)) {
                postparams.put(s_selfPolycysticOvarianSyndrome, sharedpreferences.getBoolean(s_selfPolycysticOvarianSyndrome, false));
            }

            if(sharedpreferences.contains(s_selfDeliveredOverweightBaby)) {
                postparams.put(s_selfDeliveredOverweightBaby, sharedpreferences.getBoolean(s_selfDeliveredOverweightBaby, false));
            }

            if(sharedpreferences.contains(s_selfBloodSugarProblemDuringDietry)) {
                postparams.put(s_selfBloodSugarProblemDuringDietry, sharedpreferences.getBoolean(s_selfBloodSugarProblemDuringDietry, false));
            }

            //Blood test

            if(sharedpreferences.contains(s_bloodUpper)) {
                postparams.put(s_bloodUpper, sharedpreferences.getFloat(s_bloodUpper, 0));
            }

            if(sharedpreferences.contains(s_bloodLower)) {
                postparams.put(s_bloodLower, sharedpreferences.getFloat(s_bloodLower, 0));
            }

            if(sharedpreferences.contains(s_serumLipidProfile)) {
                postparams.put(s_serumLipidProfile, sharedpreferences.getFloat(s_serumLipidProfile, 0));
            }

            if(sharedpreferences.contains(s_choresterol)) {
                postparams.put(s_choresterol, sharedpreferences.getFloat(s_choresterol, 0));
            }

            if(sharedpreferences.contains(s_LDL)) {
                postparams.put(s_LDL, sharedpreferences.getFloat(s_LDL, 0));
            }

            if(sharedpreferences.contains(s_HDL)) {
                postparams.put(s_HDL, sharedpreferences.getFloat(s_HDL, 0));
            }

            if(sharedpreferences.contains(s_TG)) {
                postparams.put(s_TG, sharedpreferences.getFloat(s_TG, 0));
            }

            if(sharedpreferences.contains(s_fastingBloodGlucose)) {
                postparams.put(s_fastingBloodGlucose, sharedpreferences.getFloat(s_fastingBloodGlucose, 0));
            }

            if(sharedpreferences.contains(s_uricAcid)) {
                postparams.put(s_uricAcid, sharedpreferences.getFloat(s_uricAcid, 0));
            }

            //Basic info
            if(sharedpreferences.contains(Sex)) {
                postparams.put(Sex, sharedpreferences.getString(Sex, ""));
            }

            if(sharedpreferences.contains(Age)) {
                postparams.put(Age, sharedpreferences.getInt(Age, 0));
            }

            if(sharedpreferences.contains(DOB)) {
                postparams.put(DOB, sharedpreferences.getString(DOB, ""));
            }

            if(sharedpreferences.contains(Height)) {
                postparams.put(Height, sharedpreferences.getFloat(Height, 0));
            }

            if(sharedpreferences.contains(Weight)) {
                postparams.put(Weight, sharedpreferences.getFloat(Weight, 0));
            }

            if(sharedpreferences.contains(Waist)) {
                postparams.put(Waist, sharedpreferences.getFloat(Waist, 0));
            }


            //Dicease HT
            if(sharedpreferences.contains(s_selfLHV)) {
                postparams.put(s_selfLHV, sharedpreferences.getBoolean(s_selfLHV, false));
            }

            if(sharedpreferences.contains(s_selfProteinuria)) {
                postparams.put(s_selfProteinuria, sharedpreferences.getBoolean(s_selfProteinuria, false));
            }

            if(sharedpreferences.contains(s_selfAtherosclerotic)) {
                postparams.put(s_selfAtherosclerotic, sharedpreferences.getBoolean(s_selfAtherosclerotic, false));
            }

            if(sharedpreferences.contains(s_selfRetinapathy)) {
                postparams.put(s_selfRetinapathy, sharedpreferences.getBoolean(s_selfRetinapathy, false));
            }

            if(sharedpreferences.contains(s_selfPVD)) {
                postparams.put(s_selfPVD, sharedpreferences.getBoolean(s_selfPVD, false));
            }

            if(sharedpreferences.contains(s_selfCKD1)) {
                postparams.put(s_selfCKD1, sharedpreferences.getBoolean(s_selfCKD1, false));
            }

            if(sharedpreferences.contains(s_selfCKD2)) {
                postparams.put(s_selfCKD2, sharedpreferences.getBoolean(s_selfCKD2, false));
            }

            if(sharedpreferences.contains(s_selfCKD3)) {
                postparams.put(s_selfCKD3, sharedpreferences.getBoolean(s_selfCKD3, false));
            }

            if(sharedpreferences.contains(s_selfCKD4)) {
                postparams.put(s_selfCKD4, sharedpreferences.getBoolean(s_selfCKD4, false));
            }




            Log.i("INFO", postparams.toString());




            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                    URLline, postparams,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.i("INFO", response.toString());
                            //Success Callback
                            if(response.length() == 0) {

                            } else {

                                try {
                                    JSONObject resp = response.getJSONObject("user");


                                    //SharedPreferences.Editor editor = sharedpreferences.edit();

                                    //editor.commit();


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            //Failure Callback
                            Log.i("INFO", "No response");

                        }
                    });

            requestQueue.add(jsonObjReq);

        } catch (JSONException e) {
            e.printStackTrace();
        }




    }
}
