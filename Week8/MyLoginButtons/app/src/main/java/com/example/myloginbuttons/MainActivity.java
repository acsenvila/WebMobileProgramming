package com.example.myloginbuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }//end of onCreate(Bundle savedInstanceState)

    public void validateLoginID(View v) {

        EditText usernameCtrl = (EditText) findViewById(R.id.UserID);
        EditText passwordCtrl = (EditText) findViewById(R.id.UserPwd);
        String username = usernameCtrl.getText() .toString();
        String password = passwordCtrl.getText() .toString();

        boolean validatingFlag = false;

        //verifying if the username and password are not empty

        if (!username.isEmpty() && !password.isEmpty()) {
            if (username.equals("admin") && password.equals("admin")) {
                validatingFlag = true;

            } //end of user/admin

        }//end user username empty

        if (!validatingFlag) {
            //write code to handle application when validation flag is false - TOAST
            Toast.makeText(getApplicationContext(),"Failed to Login", Toast.LENGTH_SHORT).show();


        } else {
            //write code to handle application when validation flag is true
            reDirectToHomePage (v);


        }//end of Else


    }

    public void reDirectToHomePage(View view) {
        Intent redirect = new Intent(MainActivity.this, HomeScreen.class);
        startActivity(redirect);

    } //end of public void reDirectToHomePage(View view)




} //end MainActivity Class
