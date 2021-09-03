package com.cst438.wk01hw02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

     // getting the values passed in

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginAccount;
        loginAccount = findViewById(R.id.login);
        EditText usernameET = findViewById(R.id.username);
        EditText passwordET = findViewById(R.id.password);

        loginAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Where you check if the username and password are valid
                String username = usernameET.getText().toString();
                String password = passwordET.getText().toString();
                clearET();
                int userId;

                // Creating a list with all different users
                ArrayList<User> allUsers = populateUsers();

                // find the user id in the array list
                userId = userFound(allUsers, username, password);

                // it is a user then we want to redirect to a new activity
                if(userId != -1){
                    Intent i = new Intent(MainActivity.this, LandingPageActivity.class);
                    // Put the userId into a bundle and pass it into landing page activity
                    Bundle extraInfo = new Bundle();
                    extraInfo.putString("userId", String.valueOf(userId));
                    i.putExtras(extraInfo);
                    startActivity(i);
                }
            }
        });

    }

    // Populate the list with users
    private ArrayList<User> populateUsers(){
        ArrayList<User> allUsers = new ArrayList<>();

        allUsers.add(new User("bret","bret123",1));
        allUsers.add(new User("Anotnette","ant123",2));
        allUsers.add(new User("Samantha","sam123",3));
        allUsers.add(new User("Karianne","kari123",4));
        allUsers.add(new User("Kamren","kam123",5));
        allUsers.add(new User("Leopoldo_Corkery","leo123",6));
        allUsers.add(new User("Kurtis Weissnat","kurt123",7));
        allUsers.add(new User("Maxime_Nienow","max123",8));
        allUsers.add(new User("Delphine","del123",9));
        allUsers.add(new User("Moriah.Stanton","mor123",10));

        return allUsers;
    }

    // Finds the user in the array list
    private int userFound(ArrayList<User> allUsers, String username, String password){

        EditText usernameET = findViewById(R.id.username);
        EditText passwordET = findViewById(R.id.password);
        boolean usernameFound = false;
        // for loop to iterate through the array list that contains user
        for(int i = 0; i < allUsers.size(); i++){
            // checks if there is a match with users created in populateUsers() and users entered
            if(allUsers.get(i).getUsername().equals(username)){
                usernameFound = true;

                // Successful login attempt
                if(allUsers.get(i).getPassword().equals(password)) {
                    Toast.makeText(this,"Login Success!", Toast.LENGTH_SHORT).show();
                    return allUsers.get(i).getUserId();
                }
                else{
                    // Password gets highlighted
                    passwordET.setSelectAllOnFocus(true);
                    passwordET.requestFocus();
                    Toast.makeText(this,"Password is incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        }
        if(usernameFound == false){
            // Username get highlighted
            usernameET.setSelectAllOnFocus(true);
            usernameET.requestFocus();
            Toast.makeText(this,"Username is incorrect", Toast.LENGTH_SHORT).show();
        }

        // return false if the user is not found
        return -1;
    }

    // Function that clears the edit text highlight
    private void clearET(){
        EditText usernameET = findViewById(R.id.username);
        EditText passwordET = findViewById(R.id.password);
        usernameET.clearFocus();
        passwordET.clearFocus();
        usernameET.setSelectAllOnFocus(false);
        passwordET.setSelectAllOnFocus(false);
    }

}