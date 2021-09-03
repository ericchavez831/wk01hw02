package com.cst438.wk01hw02;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // getting the values passed in
        EditText username1 = findViewById(R.id.username);
        EditText password1 = findViewById(R.id.password);
        String username = username1.getText().toString();
        String password = password1.getText().toString();
        Button loginAccount;
        loginAccount = findViewById(R.id.login);

        loginAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Where you check if the username and password are valid

                String username = username1.getText().toString();
                String password = password1.getText().toString();
            }
        });
    }
}