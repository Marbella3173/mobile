package com.example.sesi7;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText loginUsernameET, loginPasswordET;
    Button loginSubmitBtn;
    CheckBox loginRememberCB;
    SharedPreferences userPrefData;

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

        loginUsernameET = findViewById(R.id.loginUsernameET);
        loginPasswordET = findViewById(R.id.loginPasswordET);
        loginSubmitBtn = findViewById(R.id.loginSubmitBtn);
        loginRememberCB = findViewById(R.id.loginRememberCB);

        userPrefData = getSharedPreferences("user_preferences", Context.MODE_PRIVATE);

        checkLogin();

        loginSubmitBtn.setOnClickListener(view -> {
            boolean isRemember = loginRememberCB.isChecked();
            String username = loginUsernameET.getText().toString();
            String password = loginPasswordET.getText().toString();

            // simpan ke sharedPref
            if (isRemember){
                SharedPreferences.Editor editor = userPrefData.edit();
                editor.putString("user_name", username);
                editor.putString("user_password", password);
                editor.putBoolean("user_remember", isRemember);

                editor.apply();
            }

            toHome();
        });
    }

    private void toHome(){
        Intent toHome = new Intent(this, HomeActivity.class);
        startActivity(toHome);
        finish();
    }

    private void checkLogin(){
        boolean isRemember = userPrefData.getBoolean("user_remember", false);

        if (isRemember){
            toHome();;
        }
    }
}