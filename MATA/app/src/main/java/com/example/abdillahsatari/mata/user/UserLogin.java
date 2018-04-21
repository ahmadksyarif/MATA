//package com.example.inkak.emsys.Login;
//package com.example.abdillahsatari.emsys;
//package com.example.sony.emsys;
/**
 * Created by abdillahsatari on 12/20/2017.
 */

package com.example.abdillahsatari.mata.user;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.abdillahsatari.mata.DataHandler.Config;
import com.example.abdillahsatari.mata.DataHandler.LoginConfig;
import com.example.abdillahsatari.mata.MainActivity;
import com.example.abdillahsatari.mata.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UserLogin extends Activity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Context context;
    private Button Login;
    private ProgressDialog pDialog;
    private TextView signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);
        context = UserLogin.this;

        //Initializing views
        pDialog = new ProgressDialog(context);
        editTextUsername = (EditText) findViewById(R.id.userEmail);
        editTextPassword = (EditText) findViewById(R.id.userPassword);

        Login = (Button) findViewById(R.id.login_btn);
        signup = (TextView) findViewById(R.id.textSignUp);

        //Adding click listener
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        signup.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SignUp.class);
                startActivity(intent);
            }
        });
    }

    private void login() {
        //Getting values from edit texts
        final String email = editTextUsername.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();
        pDialog.setMessage("Processing...");
        showDialog();
        //Creating a string request
        StringRequest stringRequest = new StringRequest(Request.Method.POST, LoginConfig.LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //If we are getting success from server
                        if (response.contains(LoginConfig.LOGIN_SUCCESS)) {
                            hideDialog();
                            getData();

                        } else {
                            hideDialog();
                            //Displaying an error message on toast
                            Toast.makeText(context, "Invalid username or password", Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                        hideDialog();
                        Toast.makeText(context, "The server unreachable", Toast.LENGTH_LONG).show();

                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //Adding parameters to request
                params.put(LoginConfig.Key_EMAIL, email);
                params.put(LoginConfig.KEY_PASSWORD, password);

                //returning parameter
                return params;
            }
        };

        //Adding the string request to the queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

    private void getData() {
        String id = editTextUsername.getText().toString().trim();
        String url = Config.DATA_URL+id;

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context,error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    private void showJSON(String response) {

        String email = "";
        String username = "";
        String hp = "";
        JSONObject collegeData = null;
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Config.JSON_ARRAY);
            collegeData = result.getJSONObject(0);

            email = collegeData.getString(Config.KEY_EMAIL);
            username = collegeData.getString(Config.KEY_USERNAME);
            hp = collegeData.getString(Config.KEY_NO_HP);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        finish();

        Bundle bundle = new Bundle();
        bundle.putString("user_name", (username).toString());
        bundle.putString("email", (email).toString());
        bundle.putString("no_hp", (hp).toString());
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
}
