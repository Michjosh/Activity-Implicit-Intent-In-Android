package com.mikul.intents;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CollectNumberActivity extends AppCompatActivity {

    private EditText editTextNumber;
    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_number);

        editTextNumber = findViewById(R.id.editTextNumber);
        buttonNext = findViewById(R.id.buttonNext);

        buttonNext.setOnClickListener(view -> {
            String phoneNumber = editTextNumber.getText().toString().trim();

            if (isValidNigerianPhoneNumber(phoneNumber)) {
                Intent intent = new Intent(this, DialNumberActivity.class);
                intent.putExtra("phone_number", phoneNumber);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Invalid Nigerian phone number", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private boolean isValidNigerianPhoneNumber(String phoneNumber) {
        String nigerianNumberPattern = "^(\\+234|0)?[789][01]\\d{8}$";
        return phoneNumber.matches(nigerianNumberPattern);
    }

}
