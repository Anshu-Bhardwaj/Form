package com.example.hp.form;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Bundle b = getIntent().getExtras();
        TextView name = findViewById(R.id.nameValue);
        TextView email=findViewById(R.id.emailValue);
        TextView age =  findViewById(R.id.ageValue);
        TextView gender = findViewById(R.id.genderValue);

        name.setText(b.getCharSequence("name"));
        age.setText(b.getCharSequence("age"));
        email.setText(b.getCharSequence("email"));
        gender.setText(b.getCharSequence("gender"));

    }
}
