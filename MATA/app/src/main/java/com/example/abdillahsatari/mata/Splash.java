package com.example.abdillahsatari.mata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.example.abdillahsatari.mata.user.UserLogin;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        Thread myThread =new Thread(){
            @Override
            public void run (){
                try {
                    sleep(3000);
                    Intent intent = new Intent(getApplicationContext(),UserLogin.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        };
        myThread.start();
    }
}
