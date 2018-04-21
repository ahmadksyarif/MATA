package com.example.abdillahsatari.mata.DataHandler;

/**
 * Created by Abdillah Satari on 12/23/2017.
 */

public class LoginConfig {

    //URL to our login.php file, url bisa diganti sesuai dengan alamat server kita
    public static final String LOGIN_URL = "https://makassar-application-tourism.000webhostapp.com/login.php";
   //public static final String LOGIN_URL = "http://192.168.1.68/Mata_local/login.php";


    //Keys for email and password as defined in our $_POST['key'] in login.php
    public static final String KEY_PASSWORD = "password";
    public static final String Key_EMAIL = "email";

    //If server response is equal to this that means login is successful
    public static final String LOGIN_SUCCESS = "success";
}

