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
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.Request;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class createNewAccountActivity extends AppCompatActivity {
    private Button cancelBt;
    private Button nextBt;
    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText telNumber;
    private EditText password;
    private EditText re_password;
    public static final String mypreference = "mypref";
    public static final String Firsname = "Firsname";
    public static final String Lastname = "Lastname";
    public static final String Email = "Email";
    public static final String Telnumber = "Telnumber";
    constants const1 = new constants();

    private String URLline = "http://" + const1.address + ":3000/users";
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_account);

        requestQueue = Volley.newRequestQueue(createNewAccountActivity.this);
        final SharedPreferences sharedpreferences;
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);


        firstName = findViewById(R.id.reg_firstname);
        lastName = findViewById(R.id.reg_lastname);
        email = findViewById(R.id.reg_email);
        telNumber = findViewById(R.id.reg_phone_number);
        password = findViewById(R.id.reg_password);
        re_password = findViewById(R.id.reg_re_password);


        Log.i("INFO",URLline);

        cancelBt = (Button) findViewById(R.id.reg_cancel);;

        cancelBt.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                //do what you want here
                Intent ganesh = new Intent(createNewAccountActivity.this, MainActivity.class);
                startActivity(ganesh);
            }
        });


        nextBt = (Button) findViewById(R.id.reg_next);;

        nextBt.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                //do what you want here


                final String fn = firstName.getText().toString();
                final String ln = lastName.getText().toString();
                final String em = email.getText().toString();
                final String tn = telNumber.getText().toString();
                final String pass = password.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(Firsname, fn);
                editor.putString(Lastname, ln);
                editor.putString(Email, em);
                editor.putString(Telnumber, tn);
                editor.commit();




                JSONObject postparams = new JSONObject();
                try {


                    postparams.put("firstname",fn);
                    postparams.put("email", em);
                    postparams.put("password",pass);
                    postparams.put("lastname",ln);
                    postparams.put("tel",tn);

                    JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                            URLline, postparams,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    //Success Callback

                                    Intent ganesh = new Intent(createNewAccountActivity.this, appMainActivity.class);
                                    startActivity(ganesh);
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    //Failure Callback
                                    new AlertDialog.Builder(createNewAccountActivity.this)
                                            .setTitle("กรอกข้อมูลไม่ครบ")
                                            .setMessage("กรุณากรอกข้อมูลให้ครบทุกช่อง")

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
