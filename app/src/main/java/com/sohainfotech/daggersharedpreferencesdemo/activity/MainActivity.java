package com.sohainfotech.daggersharedpreferencesdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sohainfotech.daggersharedpreferencesdemo.R;
import com.sohainfotech.daggersharedpreferencesdemo.dagger.DaggerSharedPrefComponent;
import com.sohainfotech.daggersharedpreferencesdemo.dagger.SharedPrefComponent;
import com.sohainfotech.daggersharedpreferencesdemo.dagger.SharedPrefModule;

import javax.inject.Inject;

//step5:

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etUserName, etNumber;
    private Button btnSave, btnGet;

    private SharedPrefComponent sharedPrefComponent;
    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        sharedPrefComponent = DaggerSharedPrefComponent.builder().
                sharedPrefModule(new SharedPrefModule(this)).build();
        //SharedPreferences dependency object is available to use after this:
        sharedPrefComponent.inject(this);
    }

    private void initViews() {
        etUserName = findViewById(R.id.etUserName);
        etNumber = findViewById(R.id.etNumber);
        btnSave = findViewById(R.id.btnSave);
        btnGet = findViewById(R.id.btnGet);
        btnSave.setOnClickListener(this);
        btnGet.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSave:
                //store values into SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", etUserName.getText().toString().trim());
                editor.putString("number", etNumber.getText().toString().trim());
                editor.apply();
                //clear both edit text
                etUserName.setText("");
                etNumber.setText("");
                break;
            case R.id.btnGet:
                //fetch values from SharedPreferences
                etUserName.setText(sharedPreferences.getString("username", "default"));
                etNumber.setText(sharedPreferences.getString("number", "12345"));
                break;
        }
    }
}