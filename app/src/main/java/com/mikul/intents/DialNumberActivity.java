package com.mikul.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DialNumberActivity extends AppCompatActivity {

    private TextView textViewNumber;
    private Button buttonDial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial_number);

        textViewNumber = findViewById(R.id.textViewNumber);
        buttonDial = findViewById(R.id.buttonDial);

        Intent intent = getIntent();
        if (intent.hasExtra("phone_number")) {
            String phoneNumber = intent.getStringExtra("phone_number");
            textViewNumber.setText(phoneNumber);

            buttonDial.setOnClickListener(view -> {
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(dialIntent);
            });
        }
    }
}
