//package com.example.inkak.emsys;
//package com.example.abdillahsatari.emsys;
//package com.example.sony.emsys;
/**
 * Created by abdillahsatari on 12/23/2017.
 */

package com.example.abdillahsatari.mata.user;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.abdillahsatari.mata.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SignUp extends Activity implements View.OnClickListener{

    EditText Username;
    EditText No_hp;
    EditText Email;
    EditText Password;
    EditText Re_Password;
    Button signup;
    String var_user, var_hp, var_email, var_password,
            var_re_pass;
    String get_nama, get_ktp, get_alamat, get_email, get_password, get_repass;
    String DataParseUrl = "https://makassar-application-tourism.000webhostapp.com/inserted.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Username = (EditText) findViewById(R.id.userName);
        No_hp = (EditText) findViewById(R.id.userNo);
        Email = (EditText) findViewById(R.id.userEmail);
        Password = (EditText) findViewById(R.id.userPassword);
        Re_Password = (EditText) findViewById(R.id.userCPassword);

        signup = (Button) findViewById(R.id.btn_signup);
        signup.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                var_user = Username.getText().toString();
                var_hp = No_hp.getText().toString();
                var_email = Email.getText().toString();
                var_password = Password.getText().toString();
                var_re_pass = Re_Password.getText().toString();

                SendDataToServer(var_user, var_hp, var_email,var_password,var_re_pass);

                Intent input = new Intent(SignUp.this,
                        UserLogin.class);
                startActivity(input);
            }
        });
    }

    private void SendDataToServer(final String var_user, final String var_hp, final String var_email, final String var_password, final String var_re_pass ) {
        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                String QuickUsername = var_user ;
                String QuickHp = var_hp ;
                String QuickEmail = var_email ;
                String QuickPassword = var_password;
                String QuickRePass = var_re_pass ;


                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                nameValuePairs.add(new BasicNameValuePair("username1", QuickUsername));
                nameValuePairs.add(new BasicNameValuePair("no_hp1", QuickHp));
                nameValuePairs.add(new BasicNameValuePair("email1", QuickEmail));
                nameValuePairs.add(new BasicNameValuePair("password1", QuickPassword));
                nameValuePairs.add(new BasicNameValuePair("repass1", QuickRePass));
                //nameValuePairs.add(new BasicNameValuePair("bitmap", QuickFoto));

                try {
                    HttpClient httpClient = new DefaultHttpClient();

                    HttpPost httpPost = new HttpPost(DataParseUrl);

                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity = response.getEntity();


                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }
                return "Data Telah Ditambahkan";
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                Toast.makeText(SignUp.this, "Your Account Has Created", Toast.LENGTH_LONG).show();

            }
        }
        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
        sendPostReqAsyncTask.execute(var_user, var_hp, var_email, var_password, var_re_pass);
    }

    @Override
    public void onClick(View v) {

    }
}
