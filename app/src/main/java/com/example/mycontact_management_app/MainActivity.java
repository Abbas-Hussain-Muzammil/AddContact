package com.example.mycontact_management_app;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {



    private static final int SECOND_ACTIVITY_REQUEST_CODE = 1;
    ActivityResultLauncher<Intent> callSecondActivity;
    TextView myAwesomeTextView;
    TextView myAwesomeTextView2;

    Button updateButton;
    private TextView textViewName, textViewEmail;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myAwesomeTextView = (TextView)findViewById(R.id.tv1);
        myAwesomeTextView2 = (TextView)findViewById(R.id.tv2);
        updateButton = findViewById(R.id.addContactButton);

        callSecondActivity = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Intent data = result.getData();
                        if (result.getResultCode() == Activity.RESULT_OK && data != null) {
                            String name = data.getStringExtra("name");
                            String email = data.getStringExtra("email");

                            myAwesomeTextView.setText("Name: " + name );
                            myAwesomeTextView2.setText("Email: " + email);
                            updateButton.setText("Add more contacts");
                        }
                    }
                }

        );



    }

    // This method is called when the button is clicked
    public void onClick(View view) {
        // Create an Intent to start the SecondActivity

        Intent intent = new Intent(this, SecondActivity.class);
        callSecondActivity.launch(intent);


    }











}








