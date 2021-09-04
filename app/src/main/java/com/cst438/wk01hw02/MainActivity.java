package com.cst438.wk01hw02;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

/**
 *
 * <h1> Retrofit API</h1>
 * This application allows you to login in to and see their posts
 *
 * <h1><b>Main Activity</b></h1>
 * The main activity presents the user with a login screen.
 * If the users are entering invalid credentials then they will receive a message
 * that notifies them on what is invalid.
 *
 * @author Eric Chavez Velez
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void nextActivity(View view){
        EditText usernameET = findViewById(R.id.username);
        EditText passwordET = findViewById(R.id.password);
        String username = usernameET.getText().toString();
        String password = passwordET.getText().toString();
        // Clear the Edit Test Focus
        clearET();
        int userId;

        // Creating a list with all different users
        ArrayList<User> allUsers = populateUsers();

        // find the user id in the array list
        userId = userFound(allUsers, username, password);

        if(userId > 0){ // User found
            Toast.makeText(MainActivity.this,"Login Success!", Toast.LENGTH_SHORT).show();

            // Put the userId into a bundle and pass it into landing page activity
            Bundle extraInfo = new Bundle();
            extraInfo.putString("userId", String.valueOf(userId));
            extraInfo.putString("username", username);
            Intent intent = LandingPageActivity.getIntent(getApplicationContext(), extraInfo);
            startActivity(intent);
        }else if(userId == -1){
            clearUsernameET();
        }else if(userId == -2){
            clearPasswordET();
        }

    }

    /**
     * This Function populates the application with hard-coded users in the application.
     *
     * @return an ArrayList with all the Users
     */
    public static ArrayList<User> populateUsers(){
        ArrayList<User> allUsers = new ArrayList<>();

        allUsers.add(new User("bret","bret123",1));
        allUsers.add(new User("Antonette","ant123",2));
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

    /**
     *
     * This function searches through the ArrayList to find a specified User in the list.
     *
     * @param allUsers
     * @param username
     * @param password
     * @return an int value that returns the userId
     */
    public static int userFound(ArrayList<User> allUsers, String username, String password){

        for(int i = 0; i < allUsers.size(); i++){
            // checks if there is a match with users created in populateUsers()
            if(allUsers.get(i).getUsername().equals(username)){
                // Successful login attempt
                if(allUsers.get(i).getPassword().equals(password)) {
                    return allUsers.get(i).getUserId();
                }
                else{
                    return -2; // Password is wrong
                }
            }
        }
        return -1; // Username is wrong
    }

    /**
     * This function clears the edit text highlight
     */
    private void clearET(){
        EditText usernameET = findViewById(R.id.username);
        EditText passwordET = findViewById(R.id.password);
        usernameET.clearFocus();
        passwordET.clearFocus();
        usernameET.setSelectAllOnFocus(false);
        passwordET.setSelectAllOnFocus(false);
    }

    /**
     * This function clears the edit text highlight that is added when the user input an
     * incorrect password
     */
    private void clearPasswordET(){
        EditText passwordET = findViewById(R.id.password);
        passwordET.setSelectAllOnFocus(true);
        passwordET.requestFocus();
        Toast.makeText(MainActivity.this,"Password is incorrect", Toast.LENGTH_SHORT).show();
    }

    /**
     * This function clears the edit text highlight that is added when the user input an
     * incorrect username
     */
    private void clearUsernameET(){
        EditText usernameET = findViewById(R.id.username);
        usernameET.setSelectAllOnFocus(true);
        usernameET.requestFocus();
        Toast.makeText(MainActivity.this,"Username is incorrect", Toast.LENGTH_SHORT).show();
    }
}