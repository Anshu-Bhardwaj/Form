package com.example.hp.form;

import android.content.Intent;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FormActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    RadioGroup genderRadioGroup;
    EditText name;
    EditText email;
    EditText age;

    public static final String NAME_KEY="user_name";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        findAllViewsId();

        button.setOnClickListener(this);

        sharedPreferences=getSharedPreferences("my_shared_pref",MODE_PRIVATE);

        String user_name= sharedPreferences.getString(NAME_KEY,null);
        if(user_name!=null){
            name.setText(user_name);
        }
    }

    private void findAllViewsId() {
        button =  findViewById(R.id.submit);
        name = findViewById(R.id.name);
        email= findViewById(R.id.email);
        age =  findViewById(R.id.age);
        genderRadioGroup = findViewById(R.id.gender);


    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), DisplayActivity.class);
        Bundle b = new Bundle();

        b.putString("name", name.getText().toString());
        b.putString("email", email.getText().toString());
        b.putString("age", age.getText().toString());
        int id = genderRadioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(id);
        b.putString("gender", radioButton.getText().toString());

        intent.putExtras(b);
        String user_name=name.getText().toString();

        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString(NAME_KEY,user_name);
        editor.commit();
        startActivity(intent);
    }

}
