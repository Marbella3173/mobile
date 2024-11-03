package com.example.gslcsesi4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText loginNameET, loginBinusianET;
    TextView loginTitleTV, loginNameTV, loginBinusianTV, loginRoleTV;
    Spinner loginRoleSpinner;
    String[] roles = {"Choose your role", "Student", "Lecturer", "Admin", "Staff"};
    Integer index = 0;
    Button loginRegisterButton;

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
        loginBinusianET = findViewById(R.id.loginBinusianET);
        loginRegisterButton = findViewById(R.id.loginRegisterButton);
        Spinner loginRoleSpinner = findViewById(R.id.loginRoleSpinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, roles);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        loginRoleSpinner.setAdapter(adapter);

        loginRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = loginNameET.getText().toString();
                String id = loginBinusianET.getText().toString();
                String role = roles[index];

                Intent pindahIntent = new Intent(MainActivity.this, HomeActivity.class);

                pindahIntent.putExtra("Name", name);
                pindahIntent.putExtra("ID", id);
                pindahIntent.putExtra("Role", role);

                startActivity(pindahIntent);
            }
        });

        loginRoleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedRole = parentView.getItemAtPosition(position).toString();
                // Do something with the selected role
                index = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Another interface callback
            }
        });
    }
}