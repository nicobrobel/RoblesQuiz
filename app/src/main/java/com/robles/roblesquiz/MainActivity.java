package com.robles.roblesquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText User, Pass;
    Button remember, login;
    SharedPreferences preferences;
    private SharedPreferences.Editor loginPrefsEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User = (EditText) findViewById(R.id.et_username);
        Pass = (EditText) findViewById(R.id.et_pass);
        remember = (Button) findViewById(R.id.btn_remember);
        login = (Button) findViewById(R.id.btn_log);
        preferences = getPreferences(Context.MODE_PRIVATE);

    }

    public void Save(View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", User.getText().toString());
        editor.putString("password", Pass.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
    }

    public void nextActivity(View view) {
        String username = String.valueOf(User.getText());
        String password = String.valueOf(Pass.getText());

        if (username.equals("nico") && password.equals("robles")) {
            Intent intent = new Intent(this, LandingPage.class);
            startActivity(intent);
        }
        else if (username.equals("user") && password.equals("password")) {
            Intent intent = new Intent(this, LandingPage.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Login Failure", Toast.LENGTH_SHORT).show();
        }
    }


    /* public void nextActivity (View view) {
        Intent intent = new Intent(this, LandingPage.class);
        startActivity(intent);
    }
    */

}
