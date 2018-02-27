package com.example.janmejay.meete.controller.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.janmejay.meete.R;
import com.example.janmejay.meete.controller.Home.HomeActivity;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void btnhome(View view) {
        startActivity(new Intent(this, HomeActivity.class));
    }

    public void tvSignUp(View view) {
        startActivity(new Intent(this,SignUpActivity.class));
    }

    public void tvFrogot(View view) {
        startActivity(new Intent(this, forgotPasswordActivity.class));
    }
}
