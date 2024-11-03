package com.example.sesi7;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    ImageView homeLogoutIV;
    SharedPreferences userPrefData;
    DBManager dbManager;
    ContactModel contactData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        userPrefData = getSharedPreferences("user_preferences", Context.MODE_PRIVATE);

        dbManager = new DBManager(this);
        dbManager.open();
        contactData = dbManager.getContact();
        dbManager.close();

        TextView homeNameTV = findViewById(R.id.homeNameTV);
        TextView homePhoneTV = findViewById(R.id.homePhoneTV);

        if (contactData != null){
            String name = contactData.getName();
            String phone = contactData.getPhone();

            homeNameTV.setText(name);
            homePhoneTV.setText(phone);
        }else{
            dbManager.open();
            dbManager.addContact("Ario", "09832132");
            dbManager.close();
        }

        homeLogoutIV = findViewById(R.id.homeLogoutIV);

        homeLogoutIV.setOnClickListener(view -> {
            userPrefData.edit().clear().apply();

            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
    }
}