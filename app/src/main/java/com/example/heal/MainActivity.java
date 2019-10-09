package com.example.heal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private Button regBt;
    private Button loginBt;

    private TextView email;
    private TextView pass;
    constants const1 = new constants();

    private String URLline = "http://" + const1.address + ":3000/users/login";
    RequestQueue requestQueue;

    public static final String mypreference = "mypref";
    public static final String Firsname = "Firsname";
    public static final String Lastname = "Lastname";
    public static final String Email = "Email";
    public static final String Telnumber = "Telnumber";

    private dataScheme dd;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dd = new dataScheme(MainActivity.this);
        final SharedPreferences sharedpreferences;
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);


        requestQueue = Volley.newRequestQueue(MainActivity.this);
        setContentView(R.layout.activity_main);


        email = findViewById(R.id.login_email);
        pass = findViewById(R.id.login_password);

        //Find your views
        regBt = (Button) findViewById(R.id.createAccount);;

        regBt.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                //do what you want here
                Intent ganesh = new Intent(MainActivity.this, discliamActivity.class);
                startActivity(ganesh);
            }
        });

        loginBt = (Button) findViewById(R.id.login);;

        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                //do what you want here

                final String em = email.getText().toString();
                final String passw = pass.getText().toString();

                Log.i("INFO", em);

                JSONObject postparams = new JSONObject();
                try {



                    postparams.put("email", em);
                    postparams.put("password",passw);




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


                                            SharedPreferences.Editor editor = sharedpreferences.edit();
                                            editor.putString(Firsname, resp.getString("firstname"));
                                            editor.putString(Lastname, resp.getString("lastname"));
                                            editor.putString(Email, resp.getString("email"));
                                            editor.putString(Telnumber, resp.getString("tel"));





                                            editor.commit();
                                            dd.getData(resp.getString("email"));

                                            Intent ganesh = new Intent(MainActivity.this, appMainActivity.class);
                                            startActivity(ganesh);
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
                                    new AlertDialog.Builder(MainActivity.this)
                                            .setTitle("เข้าสู่ระบบไม่ได้")
                                            .setMessage("กรุณาตรวจสอบข้อมูลการเข้าสู่ระบบ")

                                            // Specifying a listener allows you to take an action before dismissing the dialog.
                                            // The dialog is automatically dismissed when a dialog button is clicked.
                                            //.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                            //    public void onClick(DialogInterface dialog, int which) {
                                            // Continue with delete operation
                                            //    }
                                            //})

                                            // A null listener allows the button to dismiss the dialog and take no further action.
                                            .setNegativeButton(android.R.string.ok, null)
                                            .setIcon(android.R.drawable.ic_dialog_alert)
                                            .show();
                                }
                            });

                    requestQueue.add(jsonObjReq);

                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        });
    }
}
