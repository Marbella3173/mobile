package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity { //implements View.OnClickListener {

    EditText loginNameET, loginAgeET;
    Button loginSubmitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loginNameET = findViewById(R.id.loginNameET);
        loginAgeET = findViewById(R.id.loginAgeET);
        loginSubmitBtn = findViewById(R.id.loginSubmitBtn);

        // cara 1
        loginSubmitBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // coding...
                String name = loginNameET.getText().toString();
                int age = Integer.parseInt(loginAgeET.getText().toString());
                Intent pindahIntent = new Intent(MainActivity.this, HomeActivity.class);
                pindahIntent.putExtra("username", name);
                pindahIntent.putExtra("age", age);

                startActivity(pindahIntent);
            }
        });

//        // cara 2
//        loginSubmitBtn.setOnClickListener(this);
    }

//    @Override
//    public void onClick(View view) {
//        int selectedId = view.getId();
//        if(selectedId == R.id.loginSubmitBtn){
//            //coding...
//        }
//    }
}