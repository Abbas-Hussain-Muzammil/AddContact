package com.example.mycontact_management_app;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

public class SecondActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    public void handleSubmit(View view){

        // Assuming you have EditText fields for user input, you can retrieve their values
        EditText nameEditText = findViewById(R.id.editTextName);
        EditText emailEditText = findViewById(R.id.editTextEmail);

        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();

        // Check if the details are filled in
        if (name.isEmpty() || email.isEmpty()) {
            // Display a Toast message indicating the form is incomplete
            Toast.makeText(this, "Please fill in all details", Toast.LENGTH_SHORT).show();
        } else {

            // Create an Intent to send the data back to MainActivity
            Intent resultIntent = new Intent();
            resultIntent.putExtra("name", name);
            resultIntent.putExtra("email", email);

            // Set the result code to indicate success
            setResult(MainActivity.RESULT_OK, resultIntent);

            // Finish SecondActivity to return to MainActivity
            finish();


        }




    }
}